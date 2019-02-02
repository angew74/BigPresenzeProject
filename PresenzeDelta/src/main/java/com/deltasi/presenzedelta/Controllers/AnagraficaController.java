/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenzedelta.Controllers;

import com.deltasi.presenze.contracts.IPersonaService;
import com.deltasi.presenze.model.Persona;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/anagrafica")
public class AnagraficaController {
    
    
    
    @Autowired
    IPersonaService personaservice;
    
     @GetMapping(value = "/list")
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

}