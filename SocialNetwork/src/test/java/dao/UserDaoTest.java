package dao;

import logic.UserLogic;
import model.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.List;
public class UserDaoTest {
    @Ignore
    @Test
    public void getAllTest(){
        UserDao userDao=new UserDao();
        List<User> res=userDao.getAll();
        Assert.assertTrue(res.get(0).getEmail().compareTo("haruki@mail.com")==0);
    }
    @Ignore
    @Test
    public void createTest(){
        UserLogic userLogic=UserLogic.getInstance();
        User user=new User();
        user.setEmail("xxc@mailo.com");
        user.setPassword("XWEERRaaa");
        userLogic.createUser(user);
        User u=userLogic.getUser("xxc@mailo.com","XWEERRaaa");
        Assert.assertTrue(u!=null);
    }
    @Ignore
    @Test
    public void deleteTest(){
        UserLogic userLogic=UserLogic.getInstance();
        User user=new User();
        user.setEmail("qwerty@mail.com");
        user.setPassword("Awe2rGfuz");
        userLogic.createUser(user);
        User u=userLogic.getUser("qwerty@mail.com","Awe2rGfuz");
        Assert.assertTrue(u!=null);
        UserDao userDao=new UserDao();
        userDao.delete(user);
        u=userLogic.getUser("qwerty@mail.com","Awe2rGfuz");
        Assert.assertTrue(u==null);
    }
}