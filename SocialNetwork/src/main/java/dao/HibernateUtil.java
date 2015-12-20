package dao;


import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;


/**
 * Created by Lilly_94 on 21.11.2015.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    static {
        try {
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception he) {
            System.out.println("Error creating Session: " + he);
        }
    }
    public static boolean checkConnection(){
        boolean result;
        Session session=sessionFactory.openSession();
        List<User> users=new UserDao().getAll();
        return result=(users!=null)? true:false;
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
