package org.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService userService = UserService.getInstance();
        User user = userService.checkLogin(email, password);

        if(user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.html"); // Chuyển hướng đến trang chủ
        } else {
            request.setAttribute("loginError", "Invalid email or password");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}
