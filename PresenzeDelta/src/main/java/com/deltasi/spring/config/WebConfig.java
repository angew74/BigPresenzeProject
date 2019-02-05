/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.config;

import com.deltasi.spring.helpers.MySecurityProvider;
import com.deltasi.spring.interceptors.SessionTimerInterceptor;
import com.deltasi.spring.interceptors.UserInterceptor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author AdminDSI
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.deltasi.presenzedelta.Controllers", "com.deltasi.spring.helpers"})
public class WebConfig implements WebMvcConfigurer {

     public WebConfig() {
        super();
    }
    
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
  }
  
  @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

@Bean
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public MySecurityProvider mysecurityprovider()
{
    MySecurityProvider provider = new MySecurityProvider();
    return provider;
}
  
   @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/anonymous.html");

        registry.addViewController("/login.html");
        registry.addViewController("/index.html");
        registry.addViewController("/admin.html");
        registry.addViewController("/home.html");
        registry.addViewController("/logout.html");
        registry.addViewController("/menu.html");
        registry.addViewController("/head.html");
        registry.addViewController("/users/register.html");
        registry.addViewController("/users/manage.html");
    }
  
   
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/")  
          .setCachePeriod(3600)
          .resourceChain(true)
         .addResolver(new PathResourceResolver());
         registry.addResourceHandler("/images/**").addResourceLocations("/css/images/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
         registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        
    }
  
  @Override
    public void addInterceptors(final InterceptorRegistry registry) {        
        registry.addInterceptor(new UserInterceptor());
        registry.addInterceptor(new SessionTimerInterceptor());
    }
/*
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
  }*/
    @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
 
   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }
 
   @Override
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource());
      return validator;
   }
}
