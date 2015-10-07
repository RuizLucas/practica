package com.ctj.framework.model.dao.impl;

import com.ctj.framework.model.dao.PersonaDAO;
import com.ctj.framework.model.entitie.Persona;
import com.ctj.framework.model.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ruizhe
 */
public class PersonaDAOImpl implements PersonaDAO {

    @Override
    public void guardarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(persona);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }            
            System.out.println(e.getLocalizedMessage());
        } finally {
            session.close();
        }

    }
}
