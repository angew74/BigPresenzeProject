/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.service;

import com.deltasi.presenze.contracts.IAuthorityService;
import com.deltasi.presenze.dao.UserDao;
import com.deltasi.presenze.model.User;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nick
 */
public class AuthorityService implements IAuthorityService{

      private static final Logger logger = LogManager.getLogger(UserService.class);
    
    @Autowired
    private AuthorityDao authorityDAO;
    
    @Override
    public void addUtenteToAuthority(User utente, String authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUtentiByAuthority(String authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUtenteFromAuthoriy(Integer iduser, String authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getAuthorityByUtente(String UserName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
