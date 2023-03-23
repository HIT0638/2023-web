<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="studentDao" class="cn.edu.hit.dao.impl.StudentDaoImpl"></jsp:useBean>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.hit.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生管理</title>
</head>
<body>
<table border="1">
    <tr>
    <td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>专业</td><td>修改</td><td>删除</td>
    </tr>
    <%
        List<Student> studentList = studentDao.getAll("select sid, sname, gender, age, birthday, student.mid, major.mname from student, major where student.mid = major.mid");
        String sid, sname, gender, birthday, mname;
        Integer age;
        for(Student stu : studentList){
            sid = stu.getSid();
            sname = stu.getSname();
            gender = stu.getGender();
            birthday = stu.getBirthday();
            mname = stu.getMname();
            age = stu.getAge();
            %>
    <tr>
    <td><%=sid%></td><td><%=sname%></td><td><%=gender%></td><td><%=age%></td><td><%=mname%></td><td>修改</td><td>删除</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
