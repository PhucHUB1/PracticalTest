package phuc.servlet.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //Chỉ cần nhập email là admin@gmail.com, password là admin
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            HttpSession session = req.getSession();

            if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
                // Đăng nhập thành công -> Chuyền về home
                session.setAttribute("adminObj", 'a');
                resp.sendRedirect("index.jsp");
            } else {
                session.setAttribute("errorMsg", "Invalid Username or Password.");
                resp.sendRedirect("admin_login.jsp");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}