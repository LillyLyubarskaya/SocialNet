package logic;

import dao.HibernateUtil;
import dao.UserDao;
import model.User;
import model.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Lilly_94 on 21.11.2015.
 */
public class UserLogic {
    private static UserLogic userLogic;
    private static UserDao dao=new UserDao();
    private UserLogic(){};
    public static UserLogic getInstance(){
        if(userLogic==null){
            userLogic=new UserLogic();
        }
        return userLogic;
    }

    public static void setDao(UserDao dao) {
        UserLogic.dao = dao;
    }

    public static UserDao getDao() {

        return dao;
    }

    public User getUser(String email,String password){
        User currentUser=null;
        for (User user : dao.getAll()){
            if (user.getEmail().equals(email)&& user.getPassword().equals(password)){
                currentUser = user;
                break;
            }
        }
        return currentUser;
    }
    public boolean hasUser(String email){
        boolean is=false;
        if(dao.getAll()!=null){
            for (User user : dao.getAll()){
                if (user.getEmail().equals(email)){
                    is=true;
                    break;
                }
            }
        }
        return is;
    }
    public User searchUser(int id){
        return dao.getById(id);
    }
    public void updateUser(User user){
        dao.update(user);
    }
    public List<User> getAll(){
        return dao.getAll();
    }
    public void createUser(User user){
        dao.create(user);
    }
    public int countAge(User user){
        UserInfo ui=user.getUserInfo();
        Calendar dob=Calendar.getInstance();
        dob.setTime(ui.getBirthday());
        Calendar today=Calendar.getInstance();
        int age=today.get(Calendar.YEAR)-dob.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_YEAR)<dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age;
    }
    public void saveUserInfo(UserInfo ui){
       dao.saveUserInfo(ui);
    }
}
