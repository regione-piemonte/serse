package it.csi.serse.serseweb.utils;

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

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	@Value("${mail.indirizzo.assistenza}")
	public String mailAssistenza;

	@Value("${mail.smtp.server}")
	public String smtpServer;

	@Value("${mail.smtp.port}")
	public Integer smtpPort;

	@Value("${mail.smtp.auth}")
	public Boolean smtpAuth;

	@Value("${mail.smtp.user}")
	public String smtpUser;

	@Value("${mail.smtp.password}")
	public String smtpPassword;

	public void sendMail(String dest, String mitt, String oggetto, String testoEmail)
			throws MessagingException {

		// Creazione di una mail session
		Properties props = new Properties();

		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", Integer.toString(smtpPort));
		props.put("mail.smtp.auth", Boolean.toString(smtpAuth));
		props.put("mail.smtp.socketFactory.port", Integer.toString(smtpPort));

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(smtpUser, smtpPassword);
					}
				});

		// Creazione del messaggio da inviare
		MimeMessage message = new MimeMessage(session);
		message.setSubject(oggetto);
		message.setText(testoEmail);

		// Aggiunta degli indirizzi del mittente e del destinatario
		InternetAddress fromAddress = new InternetAddress(mitt);
		InternetAddress toAddress = new InternetAddress(dest);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);

		// Invio del messaggio
		Transport.send(message);
	}

	public void sendMailAssistenza(String oggetto, String testoEmail) throws MessagingException {
		sendMail(mailAssistenza, mailAssistenza, oggetto, testoEmail);
	}

	public String getMailAssistenza() {
		return mailAssistenza;
	}

}
