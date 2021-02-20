package com.blb.servley;

import com.blb.entity.User;
import com.blb.service.impl.UserService;
import com.blb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
   public UserService userService=new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        User user=new User();
        User u=new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            u=userService.GetuserByuserName(user);
//            System.out.println(u.getUsername()+' '+u.getPassword());
//    //        resp.sendRedirect("login.jsp");
//            System.out.println(username+' '+password);
             if("null".equals(u.getUsername())) {
                 System.out.println("用户不存在");
                 req.getServletContext().setAttribute("key", "该用户不存在");
                 resp.sendRedirect("login.jsp");
             }
             else if(username.equals(u.getUsername())&&!password.equals(u.getPassword()))
             {
                 req.getServletContext().setAttribute("key", "密码错误");
                 resp.sendRedirect("login.jsp");
             }
             else if(username.equals(u.getUsername())&&password.equals(u.getPassword()))
             {
                        List<User> list = new ArrayList<>();
        try {
            list = userService.GetAllUser();
            for(User l:list)
//            {
//                System.out.println(l.getUsername()+' '+l.getPassword()+' '+l.getEmail()+' '+l.getHobby());
//            }
            req.getServletContext().setAttribute("key",list);
            req.getServletContext().setAttribute("name",u);
            resp.sendRedirect("index.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



             }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        List<User> list= null;
//        try {
//            list = userService.GetAllUser();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        req.getServletContext().setAttribute("key",list);
//        resp.sendRedirect("index.jsp");

    }
}
