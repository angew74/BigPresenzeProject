/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.contracts;

import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.model.Utente;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface IUtenteService {

    public void addUtente(Utente utente);
 
    public List<Utente> getAllUtenti();
 
    public void deleteUtente(Integer id);
 
    public Utente getUtente(int id);
 
    public Utente updateUtente(Utente utente);
}