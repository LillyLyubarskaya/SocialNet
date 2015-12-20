package dao;

import model.Dialog;
import model.Message;
import org.hibernate.Session;
import org.hibernate.SessionException;
import java.util.List;

/**
 * Created by Lilly_94 on 29.11.2015.
 */
public class MessageDao extends AbstractDao<Message> {
    @Override
    public Message getById(int id) {
        Session session = null;
       Message result = null;
        try {
            session = backOff();
            session.beginTransaction();
            result = (Message)session.get(Message.class,id);
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
    public Message fillSave(Session session, Message entity) {
        session.save(entity);
        return null;
    }

    @Override
    public Message fillUpdate(Session session, Message entity) {
        session.update(entity);
        return null;
    }

    @Override
    public Message loadEntity(Session session, int id) {
        session.load(Dialog.class,id);
        return null;
    }

    @Override
    public List<Message> fillListEntity(Session session) {
        List<Dialog> responce;
        responce = session.createCriteria(Message.class).list();
        return null;
    }

    @Override
    public void fillDelete(Session session, Message entity) {
        session.delete(entity);
    }
}
