package phuc.servlet.admin;

import phuc.dao.EmployeeDAO;
import phuc.Database.ConnectionDB;
import phuc.entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/updateemployee")
public class UpdateEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            // get all data which is coming from employee.jsp employee details
            String fullName = req.getParameter("fullName");
            String dateOfBirth = req.getParameter("dateOfBirth");
            String address = req.getParameter("address");
            String position = req.getParameter("position");
            String department = req.getParameter("department");

            //Lấy id từ request
            int id = Integer.parseInt(req.getParameter("id"));

            Employee employee = new Employee(id, fullName, dateOfBirth, address, position, department);

            EmployeeDAO docDAO = new EmployeeDAO(ConnectionDB.getConnection());

            boolean isSuccess = docDAO.updateemployee(employee);
            HttpSession session = req.getSession();

            if (isSuccess) {
                session.setAttribute("successMsg", "employee update Successfully");
                resp.sendRedirect("admin/view_employee.jsp");
            } else {
                session.setAttribute("errorMsg", "Something went wrong on server!");
                resp.sendRedirect("admin/view_employee.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}