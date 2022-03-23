/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import static com.Stock.Stock.Security.Role.*;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import org.springframework.security.web.csrf.CsrfFilter;

/**
 *
 * @author rnavas
 */
@Configuration
@EnableWebSecurity
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter {

    /* Other code */
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ConfigurationSecurity(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;

    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        /* other code */
//        http
//                .authorizeRequests()
//                .antMatchers("/","index")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                
//                
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout().and()
//                .addFilterAfter(new configurationCrsfFilter(), CsrfFilter.class)
//                .csrf().csrfTokenRepository(csrfTokenRepository());
//    }
//    
//    
    @Override
protected void configure(HttpSecurity http) throws Exception {
	/* other code */
        http 
                
                
                .authorizeRequests()
                
                .anyRequest().authenticated()
                .and()
                .formLogin()
               
                .permitAll()
                .and()
                .logout().and()
                .httpBasic().and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
}
    

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails Raul = User.builder()
                .username("raul")
                .password(passwordEncoder.encode("123"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(Raul);
    }

}
