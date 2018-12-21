/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.service;

import com.deltasi.presenze.contracts.IUtenteService;
import com.deltasi.presenze.dao.PersonaDao;
import com.deltasi.presenze.dao.UtenteDao;
import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.model.Utente;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AdminDSI
 */
public class UtenteService implements IUtenteService{

    
     @Autowired
    private UtenteDao utenteDAO;
    
    @Override
    @Transactional 
    public void addUtente(Utente utente) {
      utenteDAO.addUtente(utente);
    }

    @Override
    public List<Utente> getAllUtenti() {
       return utenteDAO.getAllUtenti();
    }

    @Override
    public void deleteUtente(Integer id) {
       utenteDAO.deleteUtente(id);
    }

    @Override
    public Utente getUtente(int id) {
       return utenteDAO.getUtente(id);
    }

    @Override
    public Utente updateUtente(Utente utente) {
        return utenteDAO.updateUtente(utente);
    }
    
}
