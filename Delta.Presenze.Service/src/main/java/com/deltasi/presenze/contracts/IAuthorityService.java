/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.contracts;

import com.deltasi.presenze.model.Authorities;
import com.deltasi.presenze.model.User;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface IAuthorityService {
    public void addUtenteToAuthority(Authorities authority);
 
    public List<User> getAllUtentiByAuthority(String authority);
 
    public void removeUtenteFromAuthoriy(Integer iduser, String authority);
 
    public Authorities getAuthorityByUtente(String UserName);
 
   
    
}
