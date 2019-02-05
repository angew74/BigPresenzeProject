/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenzedelta.Controllers;

import com.deltasi.presenze.contracts.IPresenzaService;
import com.deltasi.presenze.contracts.IUserService;
import com.deltasi.presenze.model.Presenza;
import com.deltasi.presenze.model.PresenzeJsonResponse;
import com.deltasi.presenze.model.User;
import com.deltasi.spring.helpers.ISecurityProvider;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nick
 */
@Controller
@RequestMapping(value = "/presenze")
public class PresenzeController {
    
    @Autowired
    IUserService userservice;
    
    @Autowired
    IPresenzaService presenzaservice;
    
    @Autowired
    ISecurityProvider mysecurityprovider;
    
    
    
    @GetMapping(value = "/inserimento")
    public ModelAndView index(Model model, Principal principal) {

        List<User> list = null;
        ModelAndView modelAndView = new ModelAndView("presenze/inserimento");
        modelAndView.addObject("titlepage", "Inserimento Presenza");
        String username = mysecurityprovider.getUserNameAuthenticathed();
        User user = userservice.getByUsername(username);
        PresenzeJsonResponse response = new PresenzeJsonResponse();
          String[] authorities = user.getAuthorities()
          .stream().map(a -> a.getAuthority()).toArray(String[]::new);
        if(Arrays.stream(authorities).anyMatch("ADMIN"::equals))
        {
            list = userservice.getAllUtenti();
        }
        try {                 
            modelAndView.addObject("Users", list);
            response.setUser(user);
            modelAndView.addObject("Presenze", response);            
        } catch (Exception ex) {
            String error = ex.getMessage();
            ModelAndView errormodelAndView = new ModelAndView("common/error");
            errormodelAndView.addObject("titlepage", "Pagina Errore");
            errormodelAndView.addObject("Error", error);
            return errormodelAndView;
        }

        return modelAndView;     
    }
    
     @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    // @ResponseBody
    public @ResponseBody
    PresenzeJsonResponse AddUser(Presenza presenza,
            BindingResult result, ModelMap mode) {
        PresenzeJsonResponse p = new PresenzeJsonResponse();
       return p;
    }    

}
