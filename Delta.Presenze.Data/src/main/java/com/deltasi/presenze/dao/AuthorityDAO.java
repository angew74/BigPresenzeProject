/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.dao.interfaces.IAuthorityDAO;
import com.deltasi.presenze.model.Authorities;
import com.deltasi.presenze.model.User;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nick
 */
@Repository
public class AuthorityDAO implements IAuthorityDAO {
 private static final Logger logger = LogManager.getLogger(UserDao.class);

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addUtenteToAuthority(Authorities authority) {        
        sessionFactory.getCurrentSession().saveOrUpdate(authority);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
