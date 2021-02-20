<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2 0002
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
 String key=(String) application.getAttribute("key");
 key=key==null?" ":key;
%>
<%=key
%>
<form action="login">
    用户名:<input type="text" name="username">
    <br>
    密码:<input type="password" name="passwd">
    <br>
    <input type="submit" name="登录" value="登录">

    %>
    <a href="register.jsp">注册</a>
</form>
</body>
</html>
