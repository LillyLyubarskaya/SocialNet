package logic;

import dao.DialogDao;
import dao.HibernateUtil;
import model.Dialog;
import model.Message;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionException;

import java.util.*;

/**
 * Created by Lilly_94 on 29.11.2015.
 */
public class DialogLogic {
    private static DialogLogic instance;
    private static MessageLogic messageLogic=MessageLogic.getInstance();
    private static DialogDao dao=new DialogDao();
    private  static UserLogic userLogic=UserLogic.getInstance();
    public void setUserLogic(UserLogic userLogic) {
        this.userLogic = userLogic;
    }
    public static void setMessageLogic(MessageLogic messageLogic) {
        DialogLogic.messageLogic = messageLogic;
    }
    private DialogLogic(){}
    public static DialogLogic getInstance(){
        if(instance==null){
            instance=new DialogLogic();
        }
        return instance;
    }
    public void createDialog(Dialog dialog){dao.create(dialog);}
    public List<Dialog> getAll(){
        return dao.getAll();
    }

    /**
     * Very stupid
     * @param id1
     * @param id2
     * @return
     */
    public Dialog searchDialog(int id1,int id2){
        List<Dialog> dialogs=reduce(dao.getAll());
        Dialog res=null;
        for(Dialog d:dialogs){
            boolean flag=true;
            Set<Message> m=d.getMessages();
            for(Message message:m){
               int i=message.getFrom().getId();
                int j=message.getTo().getId();
                if((i==id1 && j==id2) || (j==id1 && i==id2)){
                    res=d;
                    break;
                }
            }
        }
        return res;
    }
    public List<Dialog> reduce( List<Dialog> dialogs){
        List<Dialog> new_dialogs=new ArrayList<Dialog>();
        for(Dialog d:dialogs){
            if(!new_dialogs.contains(d)){
                new_dialogs.add(d);
            }
        }
        return new_dialogs;
    }
    public ArrayList<Dialog> searchDialogs(int id1){
        List<Dialog> dialogs =reduce(dao.getAll());
        ArrayList<Dialog> result=new ArrayList<Dialog>();
        for(Dialog d:dialogs){
            Set<Message> m=d.getMessages();
            for(Message message:m){
                int i=message.getFrom().getId();
                int j=message.getTo().getId();
                if(i==id1 || j==id1){
                    result.add(d);
                    break;
                }
            }
        }
        System.out.println("DIALOG AMOUNT " + dialogs.size());
        System.out.println("DIALOG AMOUNT "+result.size());
        return result;
    }
    public Message getLastMessage(Dialog d){
        if(d!=null && !d.getMessages().isEmpty()){
            return null;
        }else{
            return null;
        }
    }
    public Dialog getById(int id){
        return dao.getById(id);
    }
    public void updateDialog(Dialog d){
        dao.update(d);
    }

    public static void setDao(DialogDao dao) {
        DialogLogic.dao = dao;
    }

    public static DialogDao getDao() {

        return dao;
    }

    public void addNewMessage(Dialog d,String text,User currUser,int uid){
        Message message=new Message();
        message.setText(text);
        message.setDate(new Date());
        message.setFrom(currUser);
        User to=userLogic.searchUser(uid);
        message.setTo(to);
        messageLogic.create(message);
        d.getMessages().add(message);
        dao.update(d);
    }
    public Message getLast(Dialog d){
        List<Message> m=messageLogic.sortByDate(d.getMessages());
        return m.get(m.size()-1);
    }

}
