package cn.edu.hit.action;

import cn.edu.hit.dao.LoginDao;
import cn.edu.hit.dao.impl.LoginDaoImpl;
import cn.edu.hit.entity.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
        LoginDao loginDao = new LoginDaoImpl();
        if (loginDao.login(uid, pwd)) {

            HttpSession session = request.getSession();
            session.setAttribute("admin",new Admin(uid,pwd));
            response.sendRedirect("student.jsp");
        } else {
            PrintWriter out = response.getWriter();

            out.println("<h2>Illigal enter,Please<a href=\"login.jsp\">login</a></h2>");
        }
    }
}
