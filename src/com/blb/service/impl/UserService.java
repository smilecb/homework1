package com.blb.service.impl;

import com.blb.dao.impl.UserDao;
import com.blb.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserServiceImpl {
    private UserDao userDao=new UserDao();
    @Override
    public User GetuserByuserName(User user) throws SQLException {
        return userDao.GetuserByuserName(user);
    }

    @Override
    public List<User> GetAllUser() throws SQLException {
        return userDao.GetAllUser();
    }

    @Override
    public int addUser(User user) throws SQLException {
       return   userDao.addUser(user);

    }

    @Override
    public void deleteUser(User user) throws SQLException {
         userDao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
       userDao.updateUser(user);
    }


}
