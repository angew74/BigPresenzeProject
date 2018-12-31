/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.service;

import com.deltasi.presenze.dao.PersonaDao;
import com.deltasi.presenze.dao.UtenteDao;
import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.deltasi.presenze.contracts.IUserService;

/**
 *
 * @author AdminDSI
 */

@Service("UserService")
public class UserService implements UserDetailsService , IUserService {

  
    
     @Autowired
    private UtenteDao utenteDAO;
    
    @Override
    @Transactional 
    public void addUtente(User utente) {
      utenteDAO.addUtente(utente);
    }

    @Override
    public List<User> getAllUtenti() {
       return utenteDAO.getAllUtenti();
    }

    @Override
    public void deleteUtente(Integer id) {
       utenteDAO.deleteUtente(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUtente(int id) {
       return utenteDAO.getUtente(id);
    }

    @Override
    public User updateUtente(User utente) {
        return utenteDAO.updateUtente(utente);
    }
    
     @Override
     @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
       User user = utenteDAO.findUserByUsername(username);
    UserBuilder builder = null;
    if (user != null) {
      
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.disabled(!user.isEnabled());
      builder.password(user.getPassword());
      String[] authorities = user.getAuthorities()
          .stream().map(a -> a.getAuthority()).toArray(String[]::new);

      builder.authorities(authorities);
    } else {
      throw new UsernameNotFoundException("User not found.");
    }
    return builder.build();
    }
    
}
