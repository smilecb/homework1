package com.blb.dao.impl;

import com.blb.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoImpl  {
    public User GetuserByuserName(User user) throws SQLException;
    List<User> GetAllUser() throws SQLException;
    public int addUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
}
