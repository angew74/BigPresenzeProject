/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao.interfaces;

import com.deltasi.presenze.model.Presenza;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface IPresenzaDAO {

    void addPresenza(Presenza persona);

    List<Presenza> getAllPresenze();

    void deletePresenza(Integer id);

    Presenza updatePresenza(Presenza persona);

    Presenza getPresenza(int id);

    Presenza getPresenzaByUseridGiorno(int userid, LocalDate giorno);

    List<Presenza> getPresenzeByDay(LocalDate day);

    List<Presenza> getPresenzeByUser(String username);
}
