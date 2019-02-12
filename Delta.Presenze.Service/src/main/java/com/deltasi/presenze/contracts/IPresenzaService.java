/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.contracts;

import com.deltasi.presenze.model.DaylyPoint;
import com.deltasi.presenze.model.MonthlyPoint;
import com.deltasi.presenze.model.Presenza;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface IPresenzaService {

    void addPresenza(Presenza presenza);

    List<Presenza> getAllPresenze();

    void deletePresenza(Integer id);

    Presenza getPresenza(int id);

    List<Presenza> getPresenzeByDay(LocalDate day);

    List<Presenza> getPresenzeByUser(String username);

    Presenza updatePresenza(Presenza presenza);

    Presenza getPresenzaByUseridGiorno(int userid, LocalDate giorno);
   
   List<MonthlyPoint> getMesePresenzeByUserId(int userid, int anno);
   
    List<DaylyPoint> getGiornoPresenzeByUserId(int userid, int anno);

}
