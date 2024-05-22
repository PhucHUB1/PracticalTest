package phuc.servlet.admin;

import phuc.dao.EmployeeDAO;
import phuc.Database.ConnectionDB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/deleteemployee")
public class DeleteEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //get id(which is coming as string value) and convert into int
        int id = Integer.parseInt(req.getParameter("id"));

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionDB.getConnection());
        HttpSession session = req.getSession();

        boolean isSuccess = employeeDAO.deleteemployeeById(id);

        if (isSuccess) {
            session.setAttribute("successMsg", "employee deleted successfully");
            resp.sendRedirect("admin/view_employee.jsp");
        } else {
            session.setAttribute("errorMsg", "Something went wrong on server");
            resp.sendRedirect("admin/view_employee.jsp");
        }
    }


}