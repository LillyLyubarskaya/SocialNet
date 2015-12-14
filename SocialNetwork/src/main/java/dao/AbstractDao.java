package dao;

import org.hibernate.Session;
import org.hibernate.SessionException;

import java.util.List;


/**
 * Created by Lilly_94 on 21.11.2015.
 */
public abstract class AbstractDao<T> {

    public T create(T entity) {
        Session session = null;
        T result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            fillSave(session, entity);
            session.getTransaction().commit();
        } catch (SessionException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }


    public void delete(T entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            fillDelete(session,entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public abstract T getById(int id);
    public T update(T entity) {
        Session session = null;
        T result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = fillUpdate(session, entity);
            session.getTransaction().commit();
        } catch (SessionException e) {
            e.printStackTrace();
            //  logger.error("Exeption in update method");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
    public List<T> getAll() {
        Session session = null;
        List<T> enities = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            enities = fillListEntity(session);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return enities;
    }
    public abstract T fillSave(Session session, T entity);

    public abstract T fillUpdate(Session session, T entity);

    public abstract T loadEntity(Session session, int id);

    public abstract List<T> fillListEntity(Session session);

    public abstract void fillDelete(Session session, T entity);

}
