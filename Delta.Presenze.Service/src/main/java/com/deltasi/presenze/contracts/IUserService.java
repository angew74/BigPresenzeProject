/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.contracts;

import com.deltasi.presenze.model.User;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface IUserService {

    public void addUtente(User utente);
 
    public List<User> getAllUtenti();
 
    public void deleteUtente(Integer id);
 
    public User getUtente(int id);
 
    public User updateUtente(User utente);    
    
}