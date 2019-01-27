/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 *
 * @author AdminDSI
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
  private static final Logger logger = LogManager.getLogger(WebSecurityConfig.class);
    
  @Autowired   
  private UserDetailsService  userDetailsService;
   
   @Bean("authenticationManager")
   @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
    
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
   @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new PDeltaUrlAuthenticationSuccessHandler();
    }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     logger.debug("Sono dentro configure");
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
 // http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
  //  .and()
  //  .authorizeRequests().antMatchers("/login**").permitAll()
 //   .and()
 //   .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
 //   .and()
 //   .logout().logoutSuccessUrl("/login").permitAll()
   // .and()
 //   .csrf().disable()
 //   .and()
  // @formatter:off
        http.authorizeRequests()
            .antMatchers("/anonymous*").anonymous()
            .antMatchers("/login*").permitAll()
            .anyRequest().authenticated()
            
            .and()
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login")
            .successHandler(myAuthenticationSuccessHandler())
            .failureUrl("/login.html?error=true")
            
            .and()
            .logout().deleteCookies("JSESSIONID")
            
            .and()
            .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)
            
            .and()
            .csrf().disable()
            ;
        // @formatter:on
  }
  
  @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**")         
         .and()
         .ignoring().antMatchers("/webjars/**");
    }

    
}
