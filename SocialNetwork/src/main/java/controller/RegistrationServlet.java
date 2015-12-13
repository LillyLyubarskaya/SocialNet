package controller;

import logic.UserLogic;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Lilly_94 on 22.11.2015.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    UserLogic userLogic=UserLogic.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String usrPass = request.getParameter("password");
        String usrPassConfirm = request.getParameter("passwordConfirm");
        int error=0;
        if (email.isEmpty() || usrPass.isEmpty() || usrPassConfirm.isEmpty()) {
            error=1;
        }
        if (!usrPass.equals(usrPassConfirm)) {
            error=2;
        }
        if(UserLogic.getInstance().hasUser(email)){
            error=3;
        }
        if(error==0){
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(usrPass);
            newUser.setStatus(1);
            userLogic.createUser(newUser);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }

    }

}
