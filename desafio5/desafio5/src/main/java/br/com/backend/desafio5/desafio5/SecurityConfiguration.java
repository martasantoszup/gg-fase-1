package br.com.backend.desafio5.desafio5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/java/people/**").permitAll()
                .antMatchers(HttpMethod.POST, "/java/people").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/java/people/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/java/people/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("tom")
                .password("{noop}tom123")
                .roles("ADMIN")
                .and()
                .withUser("jerry")
                .password("{noop}jerry123")
                .roles("USER");
    }

}
