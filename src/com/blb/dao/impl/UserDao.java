package com.blb.dao.impl;

import com.blb.entity.User;
import com.blb.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoImpl{

    @Override

    public User GetuserByuserName(User user) throws SQLException {
       User user1=new User();
       user1.setUsername("null");
        ResultSet rs= DBUtil.executeQuery("SELECT * FROM t_user where username=?",user.getUsername());
        while (rs.next())
        {

            String id = rs.getString("id");
            String username=rs.getString("username");
            String password=rs.getString("password");
            String hobby=rs.getString("hobby");
            String email=rs.getString("email");
            user1.setPassword(password);
            user1.setId(id);
            user1.setUsername(username);
            user1.setHobby(hobby);
            user1.setEmail(email);
            return user1;

        }
        return user1;
    }

    @Override
    public List<User> GetAllUser() throws SQLException {
        ResultSet resultSet=DBUtil.executeQuery("SELECT * FROM t_user");
        List<User> list=new ArrayList<>();
        while (resultSet.next())
        {
            User u=new User();
            u.setPassword(resultSet.getString("password"));
            u.setUsername(resultSet.getString("username"));
            u.setEmail(resultSet.getString("email"));
            u.setHobby(resultSet.getString("hobby"));
            u.setId(resultSet.getString("id"));
            list.add(u);

        }

        return list;
    }

    @Override
    public int addUser(User user) throws SQLException {
        User user1=user;
        ResultSet resultSet=DBUtil.executeQuery("SELECT * FROM t_user where username=?",user.getUsername());
      while(resultSet.next())
      {
          return 0;
      }
        return DBUtil.execute("INSERT INTO t_user (id,username,password,hobby,email) VALUES(?,?,?,?,?)",user1.getId(),user1.getUsername(),user1.getPassword(),user1.getHobby(),user1.getEmail());
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        DBUtil.execute("DELETE FROM t_user WHERE id=?",user.getId());
    }

    @Override
    public void updateUser(User user) throws SQLException {
        DBUtil.execute("UPDATE t_user SET username=?,PASSWORD=?,hobby=?,email=? WHERE id=?",user.getUsername(),user.getPassword(), user.getHobby(),user.getEmail(),user.getId());
    }


}
