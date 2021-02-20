package com.blb.util;

import java.sql.*;

public class DBUtil {
    private static Connection conn = null;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/one?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "root", "199866");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行查询
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sql, String... params) throws SQLException{
        return getParams(sql, params).executeQuery();
    }

    /**
     * 执行添加、删除、修改
     * @param sql
     * @param params
     * @throws SQLException
     */
    public static int execute(String sql, String... params) throws SQLException{
            return   getParams(sql, params).executeUpdate();
    }

    /**
     * 参数处理
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    private static PreparedStatement getParams(String sql, String... params) throws SQLException{
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            prepareStatement.setObject(i+1, params[i]);
        }
        return prepareStatement;
    }
}
