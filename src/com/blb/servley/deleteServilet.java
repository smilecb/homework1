package com.blb.servley;

import com.blb.entity.User;
import com.blb.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/delete")
public class deleteServilet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User u=(User)req.getServletContext().getAttribute("name");
        User user=new User();
        user.setId(id);
//        System.out.println("开始删除");
        if(u.getId().equals(id))
        {
            req.setAttribute("msg","不能删除该用户");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }
        List<User> l=new ArrayList<>();
        try {
            userService.deleteUser(user);
            l=userService.GetAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getServletContext().setAttribute("key",l);
        resp.sendRedirect("index.jsp");
    }
}
