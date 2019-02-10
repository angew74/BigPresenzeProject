/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.service;

import com.deltasi.presenze.contracts.IPresenzaService;
import com.deltasi.presenze.dao.PresenzaDAO;
import com.deltasi.presenze.dao.UserDao;
import com.deltasi.presenze.model.Presenza;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nick
 */

@Service
@Transactional
public class PresenzaService implements IPresenzaService {

     private static final Logger logger = LogManager.getLogger(UserService.class);
    
    @Autowired
    private PresenzaDAO presenzaDAO;
    
    @Override
    public void addPresenza(Presenza presenza) {
       presenzaDAO.addPresenza(presenza);
    }

    @Override
    public List<Presenza> getAllPresenze() {
     return presenzaDAO.getAllPresenze();
    }

    @Override
    public void deletePresenza(Integer id) {
     presenzaDAO.deletePresenza(id);
    }

    @Override
    public Presenza getPresenza(int id) {
      return presenzaDAO.getPresenza(id);
    }

    @Override
    public List<Presenza> getPresenzeByDay(Date day) {
       return presenzaDAO.getPresenzeByDay(day);
    }

    @Override
    public List<Presenza> getPresenzeByUser(String username) {
     return presenzaDAO.getPresenzeByUser(username);
    }

    @Override
    public Presenza updatePresenza(Presenza presenza) {
       return presenzaDAO.updatePresenza(presenza);
    }
    
    @Override
    public Presenza getPresenzaByUseridGiorno(int userid, Date giorno)
    {
        return presenzaDAO.getPresenzaByUseridGiorno(userid, giorno);
    }
    
}
