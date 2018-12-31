/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Nick
 */
public class PresenzeWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext sc) throws ServletException {

        // Load Spring web application configuration
         AnnotationConfigWebApplicationContext root = 
          new AnnotationConfigWebApplicationContext();
          root.scan("com.deltasi");
        sc.addListener(new ContextLoaderListener(root));
 
        ServletRegistration.Dynamic appServlet = 
          sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}

