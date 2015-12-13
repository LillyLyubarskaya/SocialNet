package logic;

import dao.MessageDao;
import model.Message;
import model.User;
import utils.DateComparator;

import java.util.*;

/**
 * Created by Lilly_94 on 26.11.2015.
 */
public class MessageLogic {
    private static MessageLogic instance;
    MessageDao messageDao=new MessageDao();
    private MessageLogic(){}
    public static MessageLogic getInstance(){
        if(instance==null){
            instance=new MessageLogic();
        }
        return instance;
    }
    public List<Message> sortByDate(Collection<Message> list){
        ArrayList<Message> lst=new ArrayList<Message>();
        lst.addAll(list);
        lst.sort(new DateComparator());
        return lst;
    }
    public void create(Message m){
        messageDao.create(m);
    }
    public User getForeignUser(Message m,User user){
        if(m.getFrom().getId()!=user.getId()){
            return m.getFrom();
        }else{
            return m.getTo();
        }
    }
}
