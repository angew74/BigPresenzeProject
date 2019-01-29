/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenzedelta.Controllers;

import com.deltasi.presenze.contracts.IUserService;
import com.deltasi.presenze.model.User;
import com.deltasi.presenze.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nick
 */

@Controller
@RequestMapping(value = "/users")
public class UsersController {
  
    
 @Autowired
 IUserService userservice;
    
     @GetMapping(value = "/manage")
     public ModelAndView index(Model model, Principal principal) {
    
     List<User> list = null;
     ModelAndView modelAndView = new ModelAndView("users/manage");
    modelAndView.addObject("titlepage", "Homepage");
     try {           
             list = userservice.getAllUtenti();
             modelAndView.addObject("Users",list);
     }
     catch(Exception ex)
     {
         String error = ex.getMessage();
          ModelAndView errormodelAndView = new ModelAndView("common/error");
          modelAndView.addObject("titlepage", "Homepage");     
          modelAndView.addObject("Error", error);
          return errormodelAndView;
     }
   
    return modelAndView;
   /* model.addAttribute("titlepage", "Homepage");
    model.addAttribute("message", "You are logged in as " + principal.getName());
    return "users/manage.html";*/
  }
}
