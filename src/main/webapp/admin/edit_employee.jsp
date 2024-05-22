<%@ page import="phuc.dao.EmployeeDAO" %>
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
    <title>employee page</title>
    <%--Styles--%>
    <%@include file="../component/css.jsp" %>
</head>

<body>
<%--NavBar--%>
<%@include file="../component/navbar.jsp" %>

<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-4 offset-4">
            <div class="card my-card">
                <div class="card-body">
                    <p class="fs-3 text-center text-danger">Edit Details</p>

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


                    <%
                        //get specific employee id with the help of request.getParameter()
                        //which is coming from url for employee editing(which i pass through url when press edit employee)...
                        int id = Integer.parseInt(request.getParameter("id")); //this "id" is prefix name in URL
                        EmployeeDAO docDAO = new EmployeeDAO(ConnectionDB.getConnection());
                        Employee employee = docDAO.getemployeeById(id);//call getemployeeById(id) which return employee of specific id
                    %>

                    <!-- boostrap form -->
                    <!-- employees details form with specific id's employees submitted data/details with editable field -->

                    <form action="../updateemployee" method="post">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input name="fullName" type="text" placeholder="Enter full name" class="form-control" value="<%=employee.getFullName()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input name="dateOfBirth" type="date" placeholder="Enter Birthday" class="form-control" value="<%=employee.getDateOfBirth()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input name="address" type="text" placeholder="Enter address" class="form-control" value="<%=employee.getAddress()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Position</label>
                            <input name="position" type="text" placeholder="Enter position" class="form-control" value="<%=employee.getPosition()%>">
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Department</label>
                            <input name="department" type="text" placeholder="Enter position" class="form-control" value="<%=employee.getDepartment()%>">
                            </select>
                        </div>

                        <!-- for update data of specific user's id used "hidden" id -->
                        <div class="mb-3">
                            <input name="id" type="hidden" class="form-control" value="<%=employee.getId()%>">
                        </div>

                        <button type="submit" class="btn btn-success text-white col-md-12">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>