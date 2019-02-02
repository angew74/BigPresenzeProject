/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.dao.interfaces.IPresenzaDAO;
import com.deltasi.presenze.model.Presenza;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nick
 */
@Repository
public class PresenzaDAO implements IPresenzaDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addPresenza(Presenza presenza) {
       sessionFactory.getCurrentSession().saveOrUpdate(presenza);
    }

    @Override
    public List<Presenza> getAllPresenze() {
          return sessionFactory.getCurrentSession().createQuery("from Presenza")
                .list();
    }

    @Override
    public void deletePresenza(Integer id) {
       Presenza presenza = (Presenza) sessionFactory.getCurrentSession().load(
                Presenza.class, id);
        if (null != presenza) {
            this.sessionFactory.getCurrentSession().delete(presenza);
        }
    }

    @Override
    public Presenza updatePresenza(Presenza presenza) {
          sessionFactory.getCurrentSession().update(presenza);
        return presenza;      
    }

    @Override
    public Presenza getPresenza(int id) {
         return (Presenza) sessionFactory.getCurrentSession().get(
                Presenza.class, id);
    }
    
}
