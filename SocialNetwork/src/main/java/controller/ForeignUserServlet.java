package controller;

import logic.UserLogic;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lilly_94 on 25.11.2015.
 */
@WebServlet(name = "foreignUserServlet", urlPatterns = {"/foreignUserServlet"})
public class ForeignUserServlet extends HttpServlet{
    UserLogic ul=UserLogic.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        User user=ul.searchUser(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/foreign_profile.jsp").forward(req, resp);
    }
}
