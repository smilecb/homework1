<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2 0002
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.blb.entity.User" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<% List<User> list= (List<User>) application.getAttribute("key");
  User name =(User) application.getAttribute("name");
%>
<%
String msg=(String)request.getAttribute("msg");
msg=msg==null?" ":msg;
%>
<%=msg%>
  欢迎你，<%=name.getUsername() %>
  <table border="1">
  <tr>
    <td>id</td>
    <td>用户名</td>
    <td>密码</td>
    <td>兴趣爱好</td>
    <td>邮箱</td>
    <td>修改</td>
    <td>删除</td>
  </tr>
  <%
    for(User u:list){
  %>
    <tr>
      <td><%=u.getId()%></td>
      <td><%=u.getUsername()%></td>
      <td><%=u.getPassword()%></td>
      <td><%=u.getHobby()%></td>
      <td><%=u.getEmail()%></td>
      <td><a href="update.jsp?id=<%=u.getId()%>&username=<%=u.getUsername()%>&password=<%=u.getPassword()%>&hobby=<%=u.getHobby()%>&email=<%=u.getEmail()%>">修改</a></td>
      <td><a href="delete?id=<%=u.getId()%>">删除</a></td>
    </tr>
  <%}%>

</table>
  </body>
</html>
