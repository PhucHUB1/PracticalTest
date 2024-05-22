package phuc.servlet.user;

import phuc.dao.UserDAO;
import phuc.Database.ConnectionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/userChangePassword")
public class UserChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        UserDAO userDAO = new UserDAO(ConnectionDB.getConnection());
        //boolean f = uDAO.checkOldPassword(userId, oldPassword);

        HttpSession session = req.getSession();

        if (userDAO.checkOldPassword(userId, oldPassword)) {

            if (userDAO.changePassword(userId, newPassword)) {

                session.setAttribute("successMsg", "Password change successfully");
                resp.sendRedirect("change_password.jsp");

            } else {

                session.setAttribute("errorMsg", "Something wrong on server");
                resp.sendRedirect("change_password.jsp");

            }

        } else {
            session.setAttribute("errorMsg", "Old password incorrect");
            resp.sendRedirect("change_password.jsp");
        }
    }
}