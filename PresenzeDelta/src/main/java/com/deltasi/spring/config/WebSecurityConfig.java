/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.config;

import com.deltasi.presenze.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author AdminDSI
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
     private static final Logger logger = LogManager.getLogger(WebSecurityConfig.class);
    
    @Autowired   
  private UserDetailsService  userDetailsService;
   
  
    
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     logger.debug("Sono dentro configure");
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll();
    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
    .and()
    .authorizeRequests().antMatchers("/login**").permitAll()    
    .and()
    .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
    .and()
    .logout().logoutSuccessUrl("/login").permitAll()
    .and()
    .csrf().disable();
  }
    
}
