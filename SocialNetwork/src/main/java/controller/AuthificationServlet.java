package controller;

import logic.UserLogic;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Lilly_94 on 21.11.2015.
 */
@WebServlet("/login")
public class AuthificationServlet  extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user=UserLogic.getInstance().getUser(email,password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if(user.getUserInfo()==null){
                req.getRequestDispatcher("/info.jsp").forward(req, resp);
            }else{
                req.setAttribute("user",user);
                req.getRequestDispatcher("/userServlet").forward(req, resp);
            }
            req.getRequestDispatcher("/error_auth.jsp").forward(req, resp);
        }
        else{
            System.out.println("ERROR!!!");
            req.getRequestDispatcher("/error_auth.jsp").forward(req, resp);
        }


    }



}
