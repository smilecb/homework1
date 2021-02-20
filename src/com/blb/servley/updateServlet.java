package com.blb.servley;

import com.blb.entity.User;
import com.blb.service.impl.UserService;

import javax.security.auth.login.CredentialException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update")
public class updateServlet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");
        String email = req.getParameter("email");
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setHobby(hobby);
        user.setEmail(email);
//       System.out.println(id+' '+username+' '+password+' '+hobby+' '+email);
        try {
            userService.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<User> list = new ArrayList<>();
        try {
            list=userService.GetAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        User name =(User) req.getServletContext().getAttribute("name");
//        if(!id.equals(name.getId()))
//        {
//            req.getServletContext().setAttribute("name",user);
//        }
        User name=(User)req.getServletContext().getAttribute("name");
        if(id.equals(name.getId()))
        {
            req.getServletContext().setAttribute("name",user);
        }
        req.getServletContext().setAttribute("key",list);
        resp.sendRedirect("index.jsp");
    }
}
