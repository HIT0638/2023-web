<%--
  Created by IntelliJ IDEA.
  User: 15629
  Date: 2023/3/24
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登陆</title>
</head>
<body>
    <h3>学生管理</h3>
    <form action="login-servlet" method="post">
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="uid" id="uid"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="pwd" id="pwd"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="checkbox" name="remeberMe" value="1">记住我</td>
            </tr>
        </table>
    </form>
</body>
</html>
