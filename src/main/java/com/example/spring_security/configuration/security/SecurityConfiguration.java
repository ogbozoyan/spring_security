package com.example.spring_security.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ogbozoyan
 * @date 25.05.2023
 */
@EnableWebSecurity // tells this is to Spring Security configuration that take this class like a configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /* From Memory
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("user")
                .roles("USER");
    }*/

    /*
     * For this we need to create a UserDetailsService
     * */
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN") // only admin can access to this page
                .antMatchers("/user").hasAnyRole("USER", "ADMIN") // only user and admin can access to this page
                .antMatchers("/").permitAll()
                .and().formLogin();// everyone can access to this page
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); //Not recommended
    }
}
