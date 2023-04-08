<%--
  Created by IntelliJ IDEA.
  User: 15629
  Date: 2023/3/23
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="checkLogin.jsp" %>
<jsp:useBean id="StudentDao" class="cn.edu.hit.dao.impl.StudentDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="MajorDao" class="cn.edu.hit.dao.impl.MajorDaoImpl" scope="session"></jsp:useBean>
<%@ page import="cn.edu.hit.dao.MajorDao,cn.edu.hit.entity.Major,java.util.List" %>
<%@ page import="cn.edu.hit.dao.impl.MajorDaoImpl" %>
<%@ page import="cn.edu.hit.entity.Student" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<%
    String sid = request.getParameter("sid");
    String sname, gender, birthday, mid;
    Integer age;

    Student stu = StudentDao.getBySid(sid);
    sname = stu.getSname();
    gender = stu.getGender();
    birthday = stu.getBirthday();
    mid = stu.getMid();
    age = stu.getAge();
%>
<h2>新增学生</h2>
    <form method="post" action="student-servlet">
        <input type="hidden" name="action" value="modify"/>
        <table>
            <tr>
                <td>学号</td>
                <td><input type="text" id="sid" name="sid" value="<%=sid%>" readonly="true"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" id="sname" name="sname" value="<%=sname%>"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="gender" value="m" <% if(gender.equals("m")) out.print("checked = \"true\"");%>/>男
                    <input type="radio" name="gender" value="w" <% if(gender.equals("w")) out.print("checked = \"true\"");%>>女
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="number" id="age" name="age" value="<%=age%>"></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="date" id="birthday" name="birthday" value="<%=birthday%>"></td>
            </tr>
            <tr>
                <td>专业</td>
                <td>
                    <select name="mid" id="mid">
                        <option value="00">---请选择专业---</option>
                        <%
                            MajorDao majorDao = new MajorDaoImpl();
                            List<Major> majorList = majorDao.getAll("select * from major");
                            String midshow, mnameshow;
                            for (Major major : majorList) {
                                midshow = major.getMid();
                                mnameshow = major.getMname();
                        %>
                        <option value="<%=midshow%>" <%if(midshow.equals(mid)) out.print("selected=\"true\"");%>><%=mnameshow%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
        </table>
        <button type="submit" value="提交">提交修改</button>
    </form>
</body>
</html>
