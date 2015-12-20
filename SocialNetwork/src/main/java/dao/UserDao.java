package dao;

import model.User;
import model.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionException;
import java.util.List;

/**
 * Created by Lilly_94 on 21.11.2015.
 */
public class UserDao extends AbstractDao<User> {
    @Override
    public User getById(int id) {
        Session session = null;
        User result = null;
        try {
            session = backOff();
            session.beginTransaction();
            result = (User)session.get(User.class,id);
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
    public User fillSave(Session session, User entity) {
        session.save(entity);
        return null;
    }

    @Override
    public User fillUpdate(Session session, User entity) {
        session.update(entity);
        return null;
    }

    @Override
    public User loadEntity(Session session, int id) {
        session.load(User.class,id);
        return null;
    }

    @Override
    public List<User> fillListEntity(Session session) {
        List<User> response;
        response = session.createCriteria(User.class).list();
        return response;
    }

    @Override
    public void fillDelete(Session session, User entity) {
        session.delete(entity);
    }
    public void saveUserInfo(UserInfo ui){
        Session session = null;
        try {
            session = backOff();
            session.beginTransaction();
            session.save(ui);
            session.getTransaction().commit();
        } catch (SessionException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }
}
