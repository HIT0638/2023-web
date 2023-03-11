<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册信息确认</title>
</head>
<body>
<h1>注册信息确认</h1>
<ul>
    <li><p><b>姓名:</b>
        <%= request.getParameter("name")%>
pro    </p></li>
    <li><p><b>民族:</b>
        <%= request.getParameter("race")%>
    </p></li>
    <li><p><b>身份证号:</b>
        <%= request.getParameter("id")%>
    </p></li>
    <li><p><b>政治面貌:</b>
        <%= request.getParameter("pols")%>
    </p></li>
    <li><p><b>性别:</b>
        <%= request.getParameter("sex")%>
    </p></li>
    <li><p><b>专业:</b>
        <% String[] majors = request.getParameterValues("major"); %>
        <% if (majors != null){ %>
        <% for(String item : majors){ %>
            <%= item + " " %>
            <%}%>
        <%}%>
        </p></li>
    <li><p><b>学校:</b>
        <%= request.getParameter("school")%>
    </p></li>
    <li><p><b>个人简介:</b>
        <%= request.getParameter("profile")%>
    </p></li>
</ul>
</body>
</html>