<%@ page import="cn.edu.hit.entity.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 15629
  Date: 2023/3/24
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%
  Admin admin = (Admin)session.getAttribute("admin");
  if(admin == null){
    out.println("Illegal User. Please <a href=\"login.jsp\">login</a>");
    return;
  }
%>
