/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao.interfaces;

import com.deltasi.presenze.model.Presenza;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface IPresenzaDAO {
    public void addPresenza(Presenza persona);
 
    public List<Presenza> getAllPresenze();
 
    public void deletePresenza(Integer id);
 
    public Presenza updatePresenza(Presenza persona);
 
    public Presenza getPresenza(int id);
}
