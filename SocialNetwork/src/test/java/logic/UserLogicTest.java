package logic;

import dao.UserDao;
import model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
/**
 * Created by Lilly_94 on 13.12.2015.
 */
public class UserLogicTest {
    private static UserLogic userLogic;
    private static UserDao userDao;
    private static ArrayList<User> res;
    @BeforeClass
    public static void initTest() {
        userLogic=UserLogic.getInstance();
        userDao=mock(UserDao.class);
        userLogic.setDao(userDao);
        int amount=3;
        res=new ArrayList<User>();
        String [] emails={"haruki@mail.com","kyon@mail.com","yuki@mail.com"};
        String [] passwords={"rA354567S","REjljhlkdv","dfjfggtg"};
        for(int i=0;i<amount;i++ ){
            User user=new User();
            user.setEmail(emails[i]);
            user.setPassword(passwords[i]);
            user.setStatus(1);
            res.add(user);
        }
    }
    @Test
    public void userCreationTest() {
        User user=new User();
        user.setEmail("example@hotmail.com");
        user.setPassword("Aqwedgdrr");
        user.setStatus(1);
        userLogic.createUser(user);
        verify(userDao).create(user);
    }
    @Test
    public void userGetTest() {
        doReturn(res).when(userDao).getAll();
        User result=userLogic.getUser("haruki@mail.com","rA354567S");
        Assert.assertTrue(result.getEmail().compareTo("haruki@mail.com")==1);
    }
}
