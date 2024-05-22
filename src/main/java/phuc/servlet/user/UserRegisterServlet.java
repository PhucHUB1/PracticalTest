package phuc.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import phuc.Database.ConnectionDB;
import phuc.dao.UserDAO;
import phuc.entity.User;

import java.io.IOException;

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Lấy dữ liệu được gửi từ file register.jsp --> Rồi dùng dữ liệu đó để tạo User mới

            // Registration
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // Set all data to User Entity
            User user = new User(fullName, email, password);

            // Create Connection with DB
            UserDAO userDAO = new UserDAO(ConnectionDB.getConnection());

            // Get session
            HttpSession session = req.getSession();

            // Lưu dữ liệu vào DB
            // Call userRegister() and pass user object to insert or save user into DB.
            boolean isSuccess = userDAO.userRegister(user); // userRegister() method return boolean type value

            if (isSuccess) {
                session.setAttribute("successMsg", "Register Successfully");
                //which page you want to show this msg
                resp.sendRedirect("register.jsp");
            } else {
                session.setAttribute("errorMsg", "Something went wrong!");
                //which page you want to show this msg
                resp.sendRedirect("register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}