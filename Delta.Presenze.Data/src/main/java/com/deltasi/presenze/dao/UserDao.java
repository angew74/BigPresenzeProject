/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.idao.IUtenteDao;
import com.deltasi.presenze.model.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */

@Repository
public class UserDao implements IUtenteDao {

     @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addUtente(User utente) {
          sessionFactory.getCurrentSession().saveOrUpdate(utente);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUtenti() {
         return sessionFactory.getCurrentSession().createQuery("from Users")
                .list();
    }

    @Override
    public void deleteUtente(Integer id) {
         User utente = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != utente) {
            this.sessionFactory.getCurrentSession().delete(utente);
        }
    }

    @Override
    public User updateUtente(User utente) {
            sessionFactory.getCurrentSession().update(utente);
        return utente;
    }

    @Override
    public User getUtente(int id) {
       return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }
    
    @Override
    public User findUserByUsername(String username)
    {
           return (User) sessionFactory.getCurrentSession().get(User.class, username);
    }    
}
