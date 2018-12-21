/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.idao;

import com.deltasi.presenze.model.Persona;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface IPersonaDao {
 
    public void addPersona(Persona persona);
 
    public List<Persona> getAllPersone();
 
    public void deletePersona(Integer id);
 
    public Persona updatePersona(Persona persona);
 
    public Persona getPersona(int id);
}