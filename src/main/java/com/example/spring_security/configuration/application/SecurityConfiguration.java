package com.example.spring_security.configuration.application;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author ogbozoyan
 * @date 25.05.2023
 */
@EnableWebSecurity // tells this is to Spring Security configuration that take this class like a configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("**/").permitAll()
                .antMatchers("/admin").fullyAuthenticated()
                .and()
                .oauth2Login(withDefaults()) // this is for OAuth2
                .formLogin(withDefaults()); // this is for form login
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); //Not recommended
    }
}
