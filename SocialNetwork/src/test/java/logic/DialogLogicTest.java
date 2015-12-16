package logic;

import dao.DialogDao;
import dao.UserDao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import model.Dialog;
import model.Message;
import model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Lilly_94 on 13.12.2015.
 */
public class DialogLogicTest {
    private static MessageLogic messageLogic;
    private static DialogLogic dialogLogic;
    private static DialogDao dialogDao;
    private static UserLogic userLogic;
    private static ArrayList<User> users;
    private static ArrayList<Dialog> dialogs;
    @BeforeClass
    public static void initTest() {
        dialogLogic = DialogLogic.getInstance();
        dialogDao = mock(DialogDao.class);
        messageLogic=mock(MessageLogic.class);
        userLogic=mock(UserLogic.class);
        dialogLogic.setUserLogic(userLogic);
        DialogLogic.setMessageLogic(messageLogic);
        dialogLogic.setDao(dialogDao);
        int amount = 3;
        users = new ArrayList<User>();
        dialogs=new ArrayList<Dialog>();
        String[] emails = {"haruki@mail.com", "kyon@mail.com", "yuki@mail.com"};
        String[] passwords = {"rA354567S", "REjljhlkdv", "dfjfggtg"};
        for (int i = 0; i < amount; i++) {
            User user = new User();
            user.setEmail(emails[i]);
            user.setPassword(passwords[i]);
            user.setId(i+1);
            user.setStatus(1);
            users.add(user);
        }
        int counter=0;
        User user=users.get(0);
        for(User other:users){
            if(user.getId()!=other.getId()){
                Dialog d=new Dialog();
                dialogs.add(d);
                d.setId(counter+1);
                Set<Message> messages=new HashSet<Message>();
                Message m=new Message();
                m.setFrom(user);
                m.setTo(other);
                m.setDate(new Date());
                m.setText("Hello");
                messages.add(m);
                d.setMessages(messages);
                counter++;
            }
        }
    }
    @Test
    public void dialogCreationTest() {
       Dialog dialog=new Dialog();
       dialogLogic.createDialog(dialog);
        verify(dialogDao).create(dialog);
    }
    @Test
    public void addNewMessageTest() {
        doReturn(dialogs).when(dialogDao).getAll();
        doReturn(users.get(2)).when(userLogic).searchUser(3);
        Dialog d=dialogLogic.searchDialog(1,3);
        dialogLogic.addNewMessage(d,"Text",users.get(0),3);
        verify(dialogDao).update(d);
        verify(userLogic).searchUser(3);
    }
    @Test
    public void searchDialogTest(){
        doReturn(dialogs).when(dialogDao).getAll();
        Dialog d=dialogLogic.searchDialog(1,3);
        verify(dialogDao).getAll();
        Set<Message> m=d.getMessages();
        for(Message message:m){
            Assert.assertTrue(message.getFrom().getId()==3 || message.getTo().getId()==3);
        }
    }
    @Test
    public void getByIdTest(){
        doReturn(dialogs.get(0)).when(dialogDao).getById(1);
        Dialog d=dialogLogic.getById(1);
        verify(dialogDao).getById(1);
        Assert.assertTrue(d.getId()==1);
    }
}