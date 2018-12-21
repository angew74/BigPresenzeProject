/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.idao.IUtenteDao;
import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.model.Utente;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */

@Repository
public class UtenteDao implements IUtenteDao {

     @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addUtente(Utente utente) {
          sessionFactory.getCurrentSession().saveOrUpdate(utente);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Utente> getAllUtenti() {
         return sessionFactory.getCurrentSession().createQuery("from Users")
                .list();
    }

    @Override
    public void deleteUtente(Integer id) {
         Utente utente = (Utente) sessionFactory.getCurrentSession().load(
                Utente.class, id);
        if (null != utente) {
            this.sessionFactory.getCurrentSession().delete(utente);
        }
    }

    @Override
    public Utente updateUtente(Utente utente) {
            sessionFactory.getCurrentSession().update(utente);
        return utente;
    }

    @Override
    public Utente getUtente(int id) {
       return (Utente) sessionFactory.getCurrentSession().get(
                Utente.class, id);
    }
    
}
