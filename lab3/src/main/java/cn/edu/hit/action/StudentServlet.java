package cn.edu.hit.action;

import java.io.*;

import cn.edu.hit.dao.StudentDao;
import cn.edu.hit.dao.impl.StudentDaoImpl;
import cn.edu.hit.entity.Student;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        StudentDao studentDao = new StudentDaoImpl();
        if(action.equals("add")){
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String age = request.getParameter("age");
            String birthday = request.getParameter("birthday");
            String mid = request.getParameter("mid");

            studentDao.add(new Student(sid,sname,gender,Integer.valueOf(age),birthday,mid));
        } else if (action.equals("modify")) {
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String age = request.getParameter("age");
            String birthday = request.getParameter("birthday");
            String mid = request.getParameter("mid");

            studentDao.modify(new Student(sid,sname,gender,Integer.valueOf(age),birthday,mid));
        } else if (action.equals("remove")) {
            String sid = request.getParameter("sid");
            studentDao.remove(sid);
        }
        response.sendRedirect("student.jsp");
    }

    public void destroy() {
    }
}