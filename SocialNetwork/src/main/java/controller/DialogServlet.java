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
import java.util.ArrayList;

/**
 * Created by Lilly_94 on 29.11.2015.
 */
@WebServlet(name = "dialogServlet", urlPatterns = {"/dialogServlet"})
public class DialogServlet extends HttpServlet{
    DialogLogic dialogLogic=DialogLogic.getInstance();
    UserLogic userLogic=UserLogic.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User)req.getSession().getAttribute("user");
        ArrayList<Dialog> dialogs=dialogLogic.searchDialogs(user.getId());
        req.setAttribute("dialogs",dialogs);
        req.getRequestDispatcher("/dialog_list.jsp").forward(req, resp);

    }

}
