package electronics.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/**", "/css/**", "/js/**", "/images/**", "/public/rest/**").permitAll()
                );

        http.exceptionHandling((exception) -> exception.accessDeniedPage("/403"));
        http.csrf().disable();

        return http.build();
    }
}
