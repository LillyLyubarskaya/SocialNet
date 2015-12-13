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
@WebServlet(name = "newMessageServlet", urlPatterns = {"/newMessageServlet"})
public class NewMessageServlet extends HttpServlet{
    DialogLogic dialogLogic=DialogLogic.getInstance();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        int uid=Integer.parseInt(req.getParameter("uid"));
        Dialog d=dialogLogic.getById(id);
        String text=req.getParameter("text");
        User currUser=(User)req.getSession().getAttribute("user");
        dialogLogic.addNewMessage(d,text,currUser,uid);
        req.setAttribute("dialog",d);
        UserLogic userLogic=UserLogic.getInstance();
        User fUser=userLogic.searchUser(uid);
        req.setAttribute("user",fUser);
        req.getRequestDispatcher("/message_list.jsp").forward(req, resp);
    }
}
