package controller;

import com.sun.net.httpserver.HttpServer;
import logic.UserLogic;
import model.User;
import model.UserInfo;
import org.apache.commons.io.IOUtils;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Lilly_94 on 22.11.2015.
 */
@WebServlet("/info")
@MultipartConfig(maxFileSize = 16177215)
public class InformationServlet extends HttpServlet {
    UserLogic userLogic=UserLogic.getInstance();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String date = req.getParameter("birthday");
        String position = req.getParameter("position");
        Part filePart = req.getPart("photo");
        UserInfo userInfo=new UserInfo();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        userInfo.setName(name);
        userInfo.setSurname(surname);
        userInfo.setPosition(position);
        try {
            userInfo.setBirthday(formatter.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user=(User)req.getSession().getAttribute("user");
        user.setUserInfo(userInfo);
        userInfo.setImage(Utils.savePart(filePart));
        userLogic.updateUser(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/userServlet").forward(req, resp);
    }


}
