/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.service;

import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.contracts.IPersonaService;
import com.deltasi.presenze.dao.PersonaDao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AdminDSI
 */

@Service
@Transactional
public class PersonaService implements IPersonaService {

    
    @Autowired
    private PersonaDao personaDAO;
    
    @Override
    @Transactional
    public void addPersona(Persona persona) {
        personaDAO.addPersona(persona);
    }

    @Override
    @Transactional
    public List<Persona> getAllPersone() {
       return personaDAO.getAllPersone();
    }

    @Override
    @Transactional
    public void deletePersona(Integer id) {
       personaDAO.deletePersona(id);
    }

    @Override    
    public Persona getPersona(int id) {
       return personaDAO.getPersona(id);
    }

    @Override    
    public Persona updatePersona(Persona persona) {
     return  personaDAO.updatePersona(persona);
    }
    
     public void setPersonaDap(PersonaDao personaDao) {
        this.personaDAO = personaDao;
    }
    
}
