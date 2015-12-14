package controller;

import logic.DialogLogic;
import logic.UserLogic;
import model.Dialog;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Lilly_94 on 29.11.2015.
 */
@WebServlet(name = "messageServlet", urlPatterns = {"/messageServlet"})
public class MessageServlet extends HttpServlet {
    DialogLogic dialogLogic=DialogLogic.getInstance();
    UserLogic userLogic=UserLogic.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id=Integer.parseInt(req.getParameter("id"));
        User user=(User)req.getSession().getAttribute("user");
        Dialog d=dialogLogic.searchDialog(user.getId(),id);
        if(d==null){
            d=new Dialog();
            dialogLogic.createDialog(d);
        }
        User foreignUser=userLogic.searchUser(id);
        req.setAttribute("user",foreignUser);
        req.setAttribute("dialog",d);
        req.getRequestDispatcher("/message_list.jsp").forward(req, resp);
    }

}
