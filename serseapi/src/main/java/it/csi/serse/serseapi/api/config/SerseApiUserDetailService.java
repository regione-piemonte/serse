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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class SerseApiUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    Environment env;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userPrefix = "security.users." + username;

        String pass = env.getProperty(userPrefix + ".password");

        String passEncoded = passwordEncoder.encode(pass);

        String roles = env.getProperty(userPrefix + ".roles");

        List<GrantedAuthority> grantAutorities = new ArrayList<>();
        if (roles != null) {
            String[] rolesArray = roles.split(",");
            for (String r : rolesArray) {
                GrantedAuthority role = new SimpleGrantedAuthority(r.trim());
                grantAutorities.add(role);
            }
        }

        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                username,
                passEncoded, grantAutorities);
        return user;
    }

}
