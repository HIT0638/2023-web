package cn.edu.hit.action;

import cn.edu.hit.dao.LoginDao;
import cn.edu.hit.dao.impl.LoginDaoImpl;
import cn.edu.hit.entity.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");
        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
        LoginDao loginDao = new LoginDaoImpl();
        if (loginDao.login(uid, pwd)) {
//            设置Session
            HttpSession session = request.getSession();
            session.setAttribute("admin", new Admin(uid, pwd));

//            写 Cookie
            String remeberMe = request.getParameter("remeberMe");
            if (remeberMe != null && remeberMe.equals("1")) {
                Cookie cookie = new Cookie("admin", uid);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie);
            }

            response.sendRedirect("student.jsp");
        } else {
            PrintWriter out = response.getWriter();

            out.println("<h2>illegal enter,Please <a href=\"login.jsp\">login</a></h2>");
        }
    }
}
