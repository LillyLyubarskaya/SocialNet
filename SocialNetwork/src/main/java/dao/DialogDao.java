package dao;

import model.Dialog;

import org.hibernate.Session;
import org.hibernate.SessionException;
import java.util.List;


/**
 * Created by Lilly_94 on 29.11.2015.
 */
public class DialogDao extends AbstractDao<Dialog> {
    public Dialog getById(int id) {
        Session session = null;
        Dialog result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = (Dialog)session.get(Dialog.class,id);
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

    @Override
    public Dialog fillSave(Session session, Dialog entity) {
        session.save(entity);
        return null;
    }

    @Override
    public Dialog fillUpdate(Session session, Dialog entity) {
        session.update(entity);
        return null;
    }

    @Override
    public Dialog loadEntity(Session session, int id) {
        session.load(Dialog.class,id);
        return null;
    }

    @Override
    public List<Dialog> fillListEntity(Session session) {
        List<Dialog> response = session.createCriteria(Dialog.class).list();
        System.out.println("AMOUNT DIALOG "+response.size());
        return response;
    }

    @Override
    public void fillDelete(Session session,Dialog entity) {
        session.delete(entity);
    }
}


