package it.csi.serse.serseapi.api.config;

/*-
 * Copyright © 2025 Regione Piemonte
 *
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://interoperable-europe.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 * or
 * https://opensource.org/license/EUPL-1.2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.serse.serseapi.utils.Constants;
import it.csi.serse.serseapi.utils.DumpUtils;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoggingAspectConfig {
	public static final int MAX_COLLECTION_SIZE_LOGGING = 100;
	protected static Logger BUSINESS_LOGGER = LoggerFactory.getLogger(Constants.COD_COMPONENTE + ".business");
	protected static Logger INTEGRATION_LOGGER = LoggerFactory.getLogger(Constants.COD_COMPONENTE + ".integration");
	
	protected static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	

	public Object objectValue(Object object) {
		if (object != null) {
			try {
				if (object.getClass().isArray()) {
					int len = Array.getLength(object);
					boolean serialize = len <= MAX_COLLECTION_SIZE_LOGGING;
					if (!serialize) {
						return object.getClass().getSimpleName() + "[" + len + "]";
					}
				}
				if (object instanceof List) {
					int len = ((List<?>) object).size();
					boolean serialize = len <= MAX_COLLECTION_SIZE_LOGGING;
					if (!serialize) {
						return object.getClass().getSimpleName() + "[" + len + "]";
					}
				}
				if (object instanceof Map) {
					int len = ((Map<?, ?>) object).size();
					boolean serialize = len <= MAX_COLLECTION_SIZE_LOGGING;
					if (!serialize) {
						return object.getClass().getSimpleName() + "[" + len + "]";
					}
				}
				return OBJECT_MAPPER.writeValueAsString(object);
			} catch (IOException e) {
			}
		}
		return object;
	}

	@Around("execution(* it.csi.serse.serseapi.api.manager..*.*(..))")
	public Object aroundBusiness(ProceedingJoinPoint jp) throws Throwable {
		return around(jp, BUSINESS_LOGGER);
	}

	private String getLogHeader(final String methodName, final String className, final boolean debugEnabled,
			Object[] args) {
		String logHeader;
		if (debugEnabled) {
			StringBuilder sb = new StringBuilder("[").append(className).append(".").append(methodName);
			if (args.length > 0) {
				sb.append("(");

				for (int i = 0; i < args.length; i++) {
					if (i > 0) {
						sb.append(",");
					}
					sb.append(objectValue(args[i]));
				}
				sb.append(")");
			}
			sb.append("] ");
			logHeader = sb.toString();
			BUSINESS_LOGGER.debug(logHeader + "BEGIN. ");
		} else {
			logHeader = null;
		}
		return logHeader;
	}

	@Around("execution(* it.csi.serse.serseapi.integration..*.*(..))")
	public Object aroundIntegration(ProceedingJoinPoint jp) throws Throwable {
		return around(jp, INTEGRATION_LOGGER);
	}


	private Object around(ProceedingJoinPoint jp, Logger logger) throws Throwable {
		final String methodName = jp.getSignature().getName();
		final String className = jp.getSignature().getDeclaringType().getSimpleName();
		final boolean debugEnabled = INTEGRATION_LOGGER.isDebugEnabled();
		String logHeader;
		Object[] args = jp.getArgs();
		if (debugEnabled) {
			StringBuilder sb = new StringBuilder("[").append(className).append(".").append(methodName);
			if (args.length > 0) {
				sb.append("(");

				for (int i = 0; i < args.length; i++) {
					if (i > 0) {
						sb.append(",");
					}
					sb.append(objectValue(args[i]));
				}
				sb.append(")");
			}
			sb.append("] ");
			logHeader = sb.toString();
			logger.debug(logHeader + "BEGIN.");
		} else {
			logHeader = null;
		}
		Object result = jp.proceed(args);
		if (debugEnabled) {
			logger.debug(logHeader + "END.  returning " + objectValue(result));
		}
		return result;
	}

	@AfterThrowing(pointcut = "execution(* it.csi.serse.serseapi.integration..*.*(..))", throwing = "exception")
	public void afterThrowingIntegration(JoinPoint jp, Exception exception) throws Throwable {
		final String methodName = jp.getSignature().getName();
		final String className = jp.getSignature().getDeclaringType().getSimpleName();
		Object[] args = jp.getArgs();
		String logHeader = getLogHeader(methodName, className, true, args);
		StringBuilder sb = new StringBuilder();
		INTEGRATION_LOGGER.error(logHeader + "BEGIN. ");

		sb.append("*************** INIZIO DUMP ECCEZIONE  ***************");
		sb.append("\n**************** [START DAO OF STACKTRACE] ***************\n");
		sb.append(DumpUtils.getStackTraceAsString(exception));
		sb.append("\n**************** [END OF DAO STACKTRACE] *****************\n");

		sb.append("**************** FINE DUMP ECCEZIONE *****************");
		INTEGRATION_LOGGER.error(sb.toString());
		INTEGRATION_LOGGER.error(logHeader + "END.  ");
	}

	@AfterThrowing(pointcut = "execution(* it.csi.serse.serseapi.api.manager..*.*(..))", throwing = "exception")
	public void afterThrowingBusiness(JoinPoint jp, Exception exception) throws Throwable {
		String startMsg = "\n**************** [START OF BEAN STACKTRACE] ***************\n";
		String endMsg = "\n**************** [END OF BEAN STACKTRACE] *****************";
		afterThrowing(jp, exception, BUSINESS_LOGGER, startMsg, endMsg);
	}



	private void afterThrowing(JoinPoint jp, Exception exception, Logger logger, String startMsg, String endMsg) {
		final String methodName = jp.getSignature().getName();
		final String className = jp.getSignature().getDeclaringType().getSimpleName();
		Object[] args = jp.getArgs();
		String logHeader = getLogHeader(methodName, className, true, args);
		StringBuilder sb = new StringBuilder();
		logger.error(logHeader + "BEGIN. ");
		sb.append(startMsg);
		sb.append(DumpUtils.getStackTraceAsString(exception));
		sb.append(endMsg);
		logger.error(sb.toString());
		logger.error(logHeader + "END.");
	}
}