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
import com.deltasi.spring.interceptors.UserInterceptor;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping(value = "/inserimento")
    public ModelAndView index(Model model, Principal principal) {

        List<User> list = null;
        ModelAndView modelAndView = new ModelAndView("presenze/inserimento");
        modelAndView.addObject("titlepage", "Inserimento Presenza");
        if (UserInterceptor.isUserLogged()) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userservice.getByUsername(username);
            PresenzeJsonResponse response = new PresenzeJsonResponse();
            String[] authorities = user.getAuthorities()
                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);
            if (Arrays.stream(authorities).anyMatch("ADMIN"::equals)) {
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
        } else {
            ModelAndView errormodelAndView = new ModelAndView("/logout");
            return errormodelAndView;
        }
        return modelAndView;
    }

    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    // @ResponseBody
    public @ResponseBody
    PresenzeJsonResponse AddPresenza(@RequestBody @ModelAttribute("presenza") Presenza presenza, BindingResult result) {
        PresenzeJsonResponse response = new PresenzeJsonResponse();
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
            try {
                String convingresso = presenza.getPartialoraingresso().replace(':', '.');
                Double ingresso = NumberUtils.toDouble(convingresso);
                String convuscita = presenza.getPartialorauscita().replace(':', '.');
                Double uscita = NumberUtils.toDouble(convuscita);
                if (uscita != 0) {
                    int orepermesso = presenza.getOrepermesso();
                    int pausapranzo = presenza.getPausapranzo();
                    int permessomaternita = presenza.getPermessomaternita();
                    int pmalattiafiglio = presenza.getPermessomalattafiglio();
                    double orepranzo = pausapranzo / 60;
                    Double orecomplessive = uscita - ingresso + orepermesso - orepranzo + permessomaternita + pmalattiafiglio;
                    if (orecomplessive != 8) {
                        errors = new HashMap<String, String>();
                        errors.put("Errrore in banca dati", "Totale deve essere di 8 ore");
                        response.setValidated(false);
                        response.setErrorMessages(errors);
                        return response;
                    } else {
                        response.setValidated(true);
                        errors = new HashMap<String, String>();
                        response.setErrorMessages(errors);
                    }
                }

            } catch (Exception ex) {
                errors = new HashMap<String, String>();
                errors.put("Errrore in banca dati", ex.getMessage());
                response.setValidated(false);
                response.setErrorMessages(errors);
            }
        } else {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", "Sessione scaduta");
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }

}
