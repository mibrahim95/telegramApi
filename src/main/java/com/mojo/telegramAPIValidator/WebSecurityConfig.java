package com.mojo.telegramAPIValidator;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Configuration
    public class BasicAuthWebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http
                    .cors()
                    .and()
                    .csrf().disable()
                    .logout().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .regexMatchers("(\\/)(env|health|info|loggers)?(\\/\\w+)?").permitAll()
                    .anyRequest().authenticated()
                    .and().httpBasic();
        }
    }
}
