/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenzedelta.Controllers;

import com.deltasi.presenze.contracts.IPresenzaService;
import com.deltasi.presenze.contracts.IUserService;
import com.deltasi.presenze.model.Presenza;
import com.deltasi.presenze.model.PresenzaJson;
import com.deltasi.presenze.model.RiepilogoJson;
import com.deltasi.presenze.model.User;
import com.deltasi.spring.helpers.PBusinessRules;
import com.deltasi.spring.interceptors.UserInterceptor;
import java.security.Principal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

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
    public ModelAndView inserimento(Model model, Principal principal) {

        List<User> list = null;
        ModelAndView modelAndView = new ModelAndView("presenze/inserimento");
        Presenza p = new Presenza();
        modelAndView.addObject("titlepage", "Inserimento Presenza");
        if (UserInterceptor.isUserLogged()) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userservice.getByUsername(username);
            PresenzaJson response = new PresenzaJson();
            String[] authorities = user.getAuthorities()
                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);
            if (Arrays.stream(authorities).anyMatch("ADMIN"::equals)) {
                list = userservice.getAllUtenti();
                p.setGiorno(LocalDate.now());
                model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                LocalDate oggi = LocalDate.now();
                p = presenzaservice.getPresenzeByDay(oggi).stream().filter(x -> x.getUserid() == user.getId()).findFirst().get();
                if (p != null && p.getOrauscita() != null) {
                    ModelAndView listmodelview = new ModelAndView("presenze/riepilogo");
                    listmodelview.addObject("titlepage", "Riepilogo presenze");
                    return listmodelview;
                }
            }
            try {
                modelAndView.addObject("Users", list);
                response.setPresenza(p);
                response.setUser(user);
                modelAndView.addObject("Presenza", response);
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
    PresenzaJson AddPresenza(@RequestBody @ModelAttribute("PresenzeJson") PresenzaJson pjson, BindingResult result) {
        PresenzaJson response = new PresenzaJson();
        Presenza presenza = pjson.getPresenza();
        PBusinessRules rules = new PBusinessRules();
        int iduser;
        LocalDate giorno;
        boolean modify = false;
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
                Presenza oldp = new Presenza();
                iduser = presenza.getUserid();
                giorno = presenza.getGiorno();
                oldp = presenzaservice.getPresenzaByUseridGiorno(iduser, giorno);
                if (oldp.IsFull()) {
                    errors = new HashMap<String, String>();
                    errors.put("Errrore in banca dati", "Presenza già inserita usare funzione modifica");
                    response.setValidated(false);
                    response.setErrorMessages(errors);
                    return response;
                } else if (oldp.IsHalfEmpty()) {
                    modify = true;
                    presenza.setId(oldp.getId());
                } else if (oldp.IsEmpty()) {
                    modify = false;
                    presenza.setId(oldp.getId());
                }
                errors = rules.ValidatePresenza(presenza);
                if (errors != null) {
                    response.setErrorMessages(errors);
                    response.setValidated(false);
                    return response;
                }
                Date oggi = Date.from(Instant.now());
                presenza.setDataope(oggi);
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                User u = userservice.getUtente(presenza.getUserid());
                presenza.setUser(u);
                presenza.setUtente(username);
                if (modify) {
                    presenzaservice.updatePresenza(presenza);
                } else {
                    presenzaservice.addPresenza(presenza);
                }
                errors = new HashMap<String, String>();
                response.setErrorMessages(errors);
                response.setValidated(true);
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

    @GetMapping(value = "/riepilogo")
    public ModelAndView riepilogo(Model model, Principal principal) {
        List<User> list = null;
        ModelAndView modelAndView = new ModelAndView("presenze/riepilogo");
        //   Presenza p = new Presenza();
        modelAndView.addObject("titlepage", "Riepilogo Presenze");
        if (UserInterceptor.isUserLogged()) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userservice.getByUsername(username);
            RiepilogoJson response = new RiepilogoJson();
            String[] authorities = user.getAuthorities()
                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);
            if (Arrays.stream(authorities).anyMatch("ADMIN"::equals)) {
                list = userservice.getAllUtenti();
            }
            try {
                modelAndView.addObject("Users", list);
                response.setUser(user);
                modelAndView.addObject("Riepilogo", response);
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

    @PostMapping(value = "/modifica")
    public @ResponseBody
    PresenzaJson ModificaPresenza(@RequestBody @ModelAttribute("Presenza") Presenza presenza, BindingResult result) {
        PresenzaJson response = new PresenzaJson();
        PBusinessRules rules = new PBusinessRules();
        Map<String, String> errors = null;
        int iduser;        
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
            response.setValidated(false);
            response.setErrorMessages(errors);
            return response;
        }
        try {
            if (UserInterceptor.isUserLogged()) {
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                iduser = presenza.getUserid();               
                errors = rules.ValidatePresenza(presenza);     
                if (errors != null) {
                    response.setErrorMessages(errors);
                    response.setValidated(false);
                    return response;
                }
                User u = userservice.getUtente(presenza.getUserid());
                presenza.setUser(u);
                Date oggi = Date.from(Instant.now());
                presenza.setDataope(oggi);
                presenza.setUtente(username);
                presenzaservice.updatePresenza(presenza);
                response.setValidated(true);
            }
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }
}
