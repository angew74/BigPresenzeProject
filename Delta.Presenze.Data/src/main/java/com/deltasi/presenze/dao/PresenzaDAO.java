/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.dao.interfaces.IPresenzaDAO;
import com.deltasi.presenze.model.DaylyPoint;
import com.deltasi.presenze.model.MonthlyPoint;
import com.deltasi.presenze.model.Presenza;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nick
 */
@Repository
public class PresenzaDAO implements IPresenzaDAO {

    private static final Logger logger = LogManager.getLogger(UserDao.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPresenza(Presenza presenza) {
        sessionFactory.getCurrentSession().save(presenza);
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

    @Override
    public Presenza getPresenzaByUseridGiorno(int userid, LocalDate giorno) {
        Presenza p = new Presenza();
        List<Presenza> q;
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(
                    "select p from Presenza p  where p.user.id=:user_id and giorno=:giorno_p");
            query.setParameter("user_id", userid);
            query.setParameter("giorno_p", giorno);
            q = query.getResultList();
            if (q.size() > 0) {
                p = q.get(0);
            }
        } catch (HibernateException ex) {
            logger.error(ex.getMessage() + " stack trace" + Arrays.toString(ex.getStackTrace()));

        }
        return p;
    }

    @Override
    public List<Presenza> getPresenzeByDay(LocalDate day
    ) {
        return sessionFactory.getCurrentSession().createQuery(
                "select p from Presenza p where giorno=:giorno_p").setParameter("giorno_p", day).getResultList();

    }

    @Override
    public List<Presenza> getPresenzeByUser(String username
    ) {
        return sessionFactory.getCurrentSession().createQuery(
                "select p from Presenza p Users u where p.user.id=u.id and u.username=:user_name").setParameter("user_name", username).getResultList();
    }

    public List<MonthlyPoint> getMesePresenzeByUserId(int userid, int anno) {
        Query query = null;
        try 
        {
        query = sessionFactory.getCurrentSession().createQuery("SELECT \n"
                + "count(*) as totale, \n"
                + "extract(month from this_.giorno) as mese, \n"
                + "extract(year from this_.giorno) as  anno, \n"
                + " this_.user.id as iduser, \n"
                + " this_.user.username as username \n"
                + "FROM Presenza this_ \n"
                + " where this_.user.id=" + userid + " \n"
                + " and extract(year from this_.giorno)=" +anno + " \n"
                + "GROUP BY \n"
                + "extract(month from this_.giorno), \n"
                + "extract(year from this_.giorno), \n"
                + " this_.user.id, \n"
                + " this_.user.username  \n"
                + "ORDER BY \n"
                + "this_.user.id, extract(year from this_.giorno) asc \n");
        }
             catch (HibernateException ex) {
            logger.error(ex.getMessage() + " stack trace" + Arrays.toString(ex.getStackTrace()));
                     }
        query.setResultTransformer(Transformers.aliasToBean(MonthlyPoint.class));
        return (List<MonthlyPoint>) query.list();
    }
    
     public List<DaylyPoint> getGiornoPresenzeByUserId(int userid, int mese) {
        Query query = null;
        try 
        {
        query = sessionFactory.getCurrentSession().createQuery("SELECT \n"
                + " id as idgiorno, \n"
                + " giorno as datagiorno, \n"              
                + " this_.user.id as iduser, \n"
                + " this_.user.username as username \n"
                + "FROM Presenza this_ \n"
                + " where this_.user.id=" + userid + " \n"
                + " and extract(month from this_.giorno)=" +mese + " \n"            
                + "ORDER BY \n"
                + "this_.user.id, giorno asc \n");
        }
             catch (HibernateException ex) {
            logger.error(ex.getMessage() + " stack trace" + Arrays.toString(ex.getStackTrace()));
                     }
        query.setResultTransformer(Transformers.aliasToBean(DaylyPoint.class));
        return (List<DaylyPoint>) query.list();
    }
}
