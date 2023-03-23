package cn.edu.hit.studentservlet.action;

import java.io.*;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSON;

import cn.edu.hit.studentservlet.dao.StudentDao;
import cn.edu.hit.studentservlet.dao.impl.StudentDaoImpl;
import cn.edu.hit.studentservlet.entity.Student;
import com.mysql.cj.xdevapi.JsonArray;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//import static com.mysql.cj.xdevapi.Type.JSON;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charSet=UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Hello
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if(action.equals("add")){
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            Integer age = Integer.valueOf(request.getParameter("age"));
            String mid = request.getParameter("mid");
            String birthday = request.getParameter("birthday");

            StudentDao stuDao = new StudentDaoImpl();
            if(stuDao.add(new Student(sid,sname,gender,age,birthday,mid)) == false){
                out.println(JSON.toJSONString("exist"));
            }
        }
        else if (action.equals("getAll")){
            StudentDao stuDao = new StudentDaoImpl();
            List<Student> stus = stuDao.getAll("select * from student");
            out.println(JSON.toJSONString(stus));
        }


    }
    public void destroy() {
    }
}