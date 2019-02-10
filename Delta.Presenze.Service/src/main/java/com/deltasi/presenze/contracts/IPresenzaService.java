/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.contracts;


import com.deltasi.presenze.model.Presenza;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface IPresenzaService {
    
     public void addPresenza(Presenza presenza);
 
    public List<Presenza> getAllPresenze();
 
    public void deletePresenza(Integer id);
 
    public Presenza getPresenza(int id);
    
    public List<Presenza> getPresenzeByDay(Date day);
    
    public List<Presenza> getPresenzeByUser(String username);
 
    public Presenza updatePresenza(Presenza presenza);
    public Presenza getPresenzaByUseridGiorno(int userid, Date giorno);
}
