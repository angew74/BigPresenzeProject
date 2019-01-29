/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.model.Persona;
import com.deltasi.presenze.dao.interfaces.IPersonaDao;
import java.util.List; 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author AdminDSI
 */

@Repository
public class PersonaDao implements IPersonaDao{

     @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public void addPersona(Persona persona) {
        sessionFactory.getCurrentSession().saveOrUpdate(persona);
 
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Persona> getAllPersone() {
 
        return sessionFactory.getCurrentSession().createQuery("from Persona")
                .list();
    }
 
    @Override
    public void deletePersona(Integer id) {
        Persona persona = (Persona) sessionFactory.getCurrentSession().load(
                Persona.class, id);
        if (null != persona) {
            this.sessionFactory.getCurrentSession().delete(persona);
        }
 
    }
 
    @Override
    public Persona getPersona(int id) {
        return (Persona) sessionFactory.getCurrentSession().get(
                Persona.class, id);
    }
 
    @Override
    public Persona updatePersona(Persona persona) {
        sessionFactory.getCurrentSession().update(persona);
        return persona;
    } 

   
    
}
