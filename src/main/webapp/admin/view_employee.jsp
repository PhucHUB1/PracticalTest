<%@page import="phuc.dao.EmployeeDAO" %>
<%@page import="java.util.List" %>
<%@ page import="phuc.Database.ConnectionDB" %>
<%@ page import="phuc.entity.Employee" %>
<%@ page import="phuc.dao.EmployeeDAO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee page</title>
    <%--Styles--%>
    <%@include file="../component/css.jsp" %>
</head>

<body>
<%--NavBar--%>
<%@include file="navbar.jsp" %>



<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card my-card">
                <div class="card-body">
                    <p class="fs-3 text-center text-danger">List of employees</p>

                    <!-- message print -->
                    <!-- for success msg -->
                    <c:if test="${not empty successMsg }">
                        <p class="text-center text-success fs-3">${successMsg}</p>
                        <c:remove var="successMsg" scope="session"/>
                    </c:if>

                    <!-- for error msg -->
                    <c:if test="${not empty errorMsg }">
                        <p class="text-center text-danger fs-3">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session"/>
                    </c:if>
                    <!-- End of message print -->

                    <!-- Show list -->
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Full Name</th>
                            <th scope="col">Birth</th>
                            <th scope="col">Address</th>
                            <th scope="col">Position</th>
                            <th scope="col">Department</th>
                            <th colspan="2" class="text-center" scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionDB.getConnection());
                            List<Employee> allEmployee = employeeDAO.getAllemployee();
                            for (Employee employeeList : allEmployee) {
                        %>
                        <tr>
                            <th scope="row"><%= employeeList.getId()%>
                            </th>
                            <th><%=employeeList.getFullName()%>
                            </th>
                            <td><%=employeeList.getDateOfBirth()%>
                            </td>
                            <td><%=employeeList.getAddress()%>
                            </td>
                            <td><%=employeeList.getPosition()%>
                            </td>
                            <td><%=employeeList.getDepartment()%>
                            </td>

                            <td>
                                <a class="btn btn-sm btn-primary" href="edit_employee.jsp?id=<%=employeeList.getId()%>">Edit</a></td>
                            <td>
                                <a class="btn btn-sm btn-danger" href="../deleteemployee?id=<%= employeeList.getId()%>">Delete</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>

                        </tbody>
                    </table>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>