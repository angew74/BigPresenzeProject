/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.presenze.dao;

import com.deltasi.presenze.dao.interfaces.IUserDao;
import com.deltasi.presenze.model.User;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao implements IUserDao {

    private static final Logger logger = LogManager.getLogger(UserDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUtente(User utente) {
        sessionFactory.getCurrentSession().saveOrUpdate(utente);
    }

    @Override   
    public List<User> getAllUtenti() {             
         @SuppressWarnings("unchecked")
          TypedQuery<User> query;     
        query = sessionFactory.getCurrentSession().createQuery("from User");
      /*  } catch (HibernateException ex) {
            logger.error(ex.getMessage() + " stack trace" + Arrays.toString(ex.getStackTrace()));
        } catch (Exception ex) {
            logger.error(ex.getMessage() + " stack trace" + Arrays.toString(ex.getStackTrace()));
        }*/
         return query.getResultList();
    }

    @Override
    public void deleteUtente(Integer id) {
        User utente = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != utente) {
            this.sessionFactory.getCurrentSession().delete(utente);
        }
    }

    @Override
    public User updateUtente(User utente) {
        try
        {
        sessionFactory.getCurrentSession().update(utente);
        }
        catch(HibernateException h)
        {
             logger.error(h.getMessage().toString());
        }
        return utente;
    }

    @Override
    public User getUtente(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findUserByUsername(String username) {
        User user;
        user = new User();
        try {
            List<User> users = sessionFactory.getCurrentSession().createQuery(
                    "select u from User u where u.username like :user_name").setParameter("user_name", username).getResultList();
            if (users.size() > 0) {
                user = users.get(0);
            }
        } catch (HibernateException ex) {
            logger.error(ex.getMessage().toString());
        }
        return user;
    }

}
