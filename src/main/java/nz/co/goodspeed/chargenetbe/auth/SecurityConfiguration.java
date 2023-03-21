package nz.co.goodspeed.chargenetbe.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {


    @Bean
    @Profile("!dev")
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

    @Bean
    @Profile("dev")
    public SecurityFilterChain filterChainDev(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest()
                .permitAll();

        return http.build();
    }

}
