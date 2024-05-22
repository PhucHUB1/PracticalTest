package phuc.servlet.admin;

import phuc.dao.EmployeeDAO;
import phuc.Database.ConnectionDB;
import phuc.entity.Employee;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //Lấy dữ liệu từ file employee.jsp
            String fullName = req.getParameter("fullName");
            String dateOfBirth = req.getParameter("dateOfBirth");
            String address = req.getParameter("address");
            String position = req.getParameter("position");
            String department = req.getParameter("department");


            Employee employee = new Employee(fullName, dateOfBirth, address, position, department);
            EmployeeDAO docDAO = new EmployeeDAO(ConnectionDB.getConnection());
            boolean isSuccess = docDAO.registeremployee(employee);
            HttpSession session = req.getSession();

            if (isSuccess) {
                session.setAttribute("successMsg", "Employee added successfully");
                resp.sendRedirect("admin/view_employee.jsp");
            } else {
                session.setAttribute("errorMsg", "Something went wrong on server");
                resp.sendRedirect("admin/add_employee.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}