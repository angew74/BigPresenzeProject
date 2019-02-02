/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.service;

import com.deltasi.presenze.contracts.IAuthorityService;
import com.deltasi.presenze.dao.AuthorityDAO;
import com.deltasi.presenze.dao.UserDao;
import com.deltasi.presenze.model.Authorities;
import com.deltasi.presenze.model.User;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nick
 */
@Service
@Transactional
public class AuthorityService implements IAuthorityService{

      private static final Logger logger = LogManager.getLogger(UserService.class);
    
    @Autowired
    private AuthorityDAO authorityDAO;
    
    @Override
    public void addUtenteToAuthority(Authorities authority) {
       authorityDAO.addUtenteToAuthority(authority);
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
    public Authorities getAuthorityByUtente(String UserName) {
        return authorityDAO.getAuthorityByUtente(UserName);
    }
    
}
