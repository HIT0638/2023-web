package cn.edu.hit.studentservlet.action;

import java.io.*;
import java.util.Date;
import java.util.List;

import cn.edu.hit.studentservlet.dao.StudentDao;
import cn.edu.hit.studentservlet.dao.impl.StudentDaoImpl;
import cn.edu.hit.studentservlet.entity.Student;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static com.mysql.cj.xdevapi.Type.JSON;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class StudentServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charSet=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        String action = request.getParameter("action");
        if(action.equals("add")){
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            Integer age = Integer.valueOf(request.getParameter("age"));
            String mid = request.getParameter("mid");
            Date birthday = new Date(request.getParameter("birthday"));

            StudentDao stuDao = new StudentDaoImpl();
            stuDao.add(new Student(sid,sname,gender,age,birthday,mid));
        }
        else if (action.equals("getAll")){
            StudentDao stuDao = new StudentDaoImpl();
            List<Student> stus = stuDao.getAll("");
            out.println(stus.toString());
        }


    }


    public void destroy() {
    }
}