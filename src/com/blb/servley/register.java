package com.blb.servley;

import com.blb.entity.User;
import com.blb.service.impl.UserService;
import com.blb.service.impl.UserServiceImpl;
import com.blb.util.DBUtil;
import com.blb.util.GetId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class register extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");
        String email = req.getParameter("email");
        String id=GetId.getUserId();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setHobby(hobby);
        user.setEmail(email);
        user.setId(id);
        int rs=0;
//        System.out.println(user.getUsername()+' '+user.getPassword()+' '+user.getHobby()+' '+user.getEmail()+' '+user.getId());
        try {
            rs=userService.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(rs!=0)
        req.getServletContext().setAttribute("key", "注册成功");
        else
            req.getServletContext().setAttribute("key","用户名已存在，注册失败");
        resp.sendRedirect("login.jsp");

    }
}
