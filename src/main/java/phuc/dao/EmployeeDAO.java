package phuc.dao;

import  phuc.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final Connection connection;

    public EmployeeDAO(Connection connection) {
//        super();
        this.connection = connection;
    }

    // Add new employee
    public boolean registeremployee(Employee employee) {
        boolean f = false;
        try {
            String sql = "insert into phuc.employee(fullName,dateOfBirth,address,position,department ) values(?,?,?,?,?)";

            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, employee.getFullName());
            pstmt.setString(2, employee.getDateOfBirth());
            pstmt.setString(3, employee.getAddress());
            pstmt.setString(4, employee.getPosition());
            pstmt.setString(5, employee.getDepartment());

            pstmt.executeUpdate();
            // if query inserted or all ok than
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }


    // getAll employees list
    public List<Employee> getAllemployee() {

        Employee employee = null;
        List<Employee> docList = new ArrayList<Employee>();

        try {

            String sql = "select * from phuc.employee order by id desc";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setFullName(resultSet.getString("fullName"));
                employee.setDateOfBirth(resultSet.getString("dateOfBirth"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPosition(resultSet.getString("position"));
                employee.setDepartment(resultSet.getString("department"));
                docList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return docList;
    }

    // Get employee by id
    public Employee getemployeeById(int id) {

        Employee employee = null;

        try {

            String sql = "select * from phuc.employee where id=?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setFullName(resultSet.getString("fullName"));
                employee.setDateOfBirth(resultSet.getString("dateOfBirth"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPosition(resultSet.getString("position"));
                employee.setDepartment(resultSet.getString("department"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    // Update employee by id
    public boolean updateemployee(Employee employee) {

        boolean f = false;

        try {

            String sql = "update phuc.employee set fullName=?,dateOfBirth=?,address=?,position=?,department=? where id=?";

            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, employee.getFullName());
            pstmt.setString(2, employee.getDateOfBirth());
            pstmt.setString(3, employee.getAddress());
            pstmt.setString(4, employee.getPosition());
            pstmt.setString(5, employee.getDepartment());

            // need to set id also for update
            pstmt.setInt(6, employee.getId());

            pstmt.executeUpdate();
            // if query updated or all ok than
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    // Delete employee by id
    public boolean deleteemployeeById(int id) {

        boolean f = false;

        try {

            String sql = "delete from phuc.employee where id=?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    // show total number of dynamic value in admin panel

    // create all count method here to reduce code line...
    // Count total employee Number
    public int countTotalemployee() {

        int i = 0;

        try {
            String sql = "select * from phuc.employee";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
}