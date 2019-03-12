/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenzedelta.Controllers;

import com.deltasi.presenze.contracts.IPersonaService;
import com.deltasi.presenze.contracts.IUserService;
import com.deltasi.presenze.model.AnagraficaJsonResponse;
import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.model.User;
import com.deltasi.spring.interceptors.UserInterceptor;
import java.security.Principal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/anagrafica")
public class AnagraficaController {
    
    
    
    @Autowired
    IPersonaService personaservice;
    
    @Autowired
    IUserService userservice;
    
     @GetMapping(value = "/list")
     @Secured("ROLE_ADMIN")
    public ModelAndView index(Model model, Principal principal) {

        List<Persona> list = null;
        ModelAndView modelAndView = new ModelAndView("anagrafica/list");
        modelAndView.addObject("titlepage", "Elenco Anagrafiche");
        try {
            list = personaservice.getAllPersone();
            modelAndView.addObject("Persone", list);
        } catch (Exception ex) {
            String error = ex.getMessage();
            ModelAndView errormodelAndView = new ModelAndView("common/error");
            modelAndView.addObject("titlepage", "Pagina Errore");
            modelAndView.addObject("Error", error);
            return errormodelAndView;
        }

        return modelAndView;     
    }

    
      @GetMapping(value = "/create")
      @Secured("ROLE_ADMIN")
    public ModelAndView create(Model model, Principal principal) {

        List<Persona> list = null;
        ModelAndView modelAndView = new ModelAndView("anagrafica/create");
        modelAndView.addObject("titlepage", "Creazione Anagrafica");
        try {
          
        } catch (Exception ex) {
            String error = ex.getMessage();
            ModelAndView errormodelAndView = new ModelAndView("common/error");
            modelAndView.addObject("titlepage", "Pagina Errore");
            modelAndView.addObject("Error", error);
            return errormodelAndView;
        }

        return modelAndView;     
    }
    
    /**
     *
     * @param pjson
     * @param result
     */
    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    public AnagraficaJsonResponse AddAnagrafica(@RequestBody @ModelAttribute("Persona") Persona pjson, BindingResult result) {
        AnagraficaJsonResponse response = new AnagraficaJsonResponse();
          Map<String, String> errors = null;
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
            response.setValidated(false);
            response.setErrorMessages(errors);
            return response;
        }
         if (UserInterceptor.isUserLogged()) {
        personaservice.addPersona(pjson);
            Date oggi = Date.from(Instant.now());
                pjson.setDataope(oggi);
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                User u = userservice.getUtente(pjson.getUser().getId());
                pjson.setUser(u);
                pjson.setUtente(username);
         }
         return response;
    }
}