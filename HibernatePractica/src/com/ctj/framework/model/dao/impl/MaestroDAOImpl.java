package com.ctj.framework.model.dao.impl;

import com.ctj.framework.model.dao.MaestroDAO;
import com.ctj.framework.model.entitie.Maestro;
import com.ctj.framework.model.hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Asus
 */
public class MaestroDAOImpl implements MaestroDAO {

    @Override
    public List<Maestro> getListMaestro() {
        List<Maestro> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Maestro.class);
            list = (List<Maestro>) criteria.list();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        } finally {
            session.close();
            return list;
        }
    }

    @Override
    public Maestro getMaestro(int leNumero) {
        Maestro maestro = new Maestro();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Maestro.class);
            criteria.add(Restrictions.eq("leNumero", leNumero));
            maestro = (Maestro) criteria.uniqueResult();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        } finally {
            session.close();
            return maestro;
        }
    }
}
