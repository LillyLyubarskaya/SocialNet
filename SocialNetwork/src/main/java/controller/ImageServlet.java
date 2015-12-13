package controller;

import logic.UserLogic;
import model.User;
import model.UserInfo;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Lilly_94 on 01.12.2015.
 */
@WebServlet(name = "imageServlet", urlPatterns = {"/imageServlet"})
public class ImageServlet extends HttpServlet{
    UserLogic userLogic=UserLogic.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        User user=userLogic.searchUser(id);
        UserInfo userInfo=user.getUserInfo();
        String path=userInfo.getImage();
        File file=new File(path);
        byte [] data= IOUtils.toByteArray(new FileInputStream(file));
        resp.setContentType("image/jpeg");
        resp.getOutputStream().write(data);
    }

}
