<%@page import="phuc.Database.ConnectionDB" %>
<%@page import="phuc.dao.EmployeeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin page</title>
    <%--Styles--%>
    <%@include file="../component/css.jsp" %>
</head>

<body>
<%@include file="../component/navbar.jsp" %>

<!-- adminObj session maintain if "adminObj" empty than go and login first...-->
<!-- no one can access admin dashboard without login as admin-->
<c:if test="${empty adminObj }">
    <c:redirect url="./admin_login.jsp"></c:redirect>
</c:if>


<div class="container p-5">
    <p class="text-center text-danger fs-3">Admin Dashboard</p>

    <!-- message print -->
    <!-- for success msg -->
    <c:if test="${not empty successMsg }">
        <p class="text-center text-success fs-5">${successMsg}</p>
        <c:remove var="successMsg" scope="session"/>
    </c:if>

    <!-- for error msg -->
    <c:if test="${not empty errorMsg }">
        <p class="text-center text-danger fs-5">${errorMsg}</p>
        <c:remove var="errorMsg" scope="session"/>
    </c:if>
    <!-- End of message print -->


    <!-- create connection with db and others -->
    <%
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionDB.getConnection());
        int totalNumberOfemployee = employeeDAO.countTotalemployee();
        int totalNumberOfUser = employeeDAO.countTotalemployee();
    %>

    <!-- row-1 -->
    <div class="row">
        <div class="col-md-4">
            <div class="card ">
                <div class="card-body text-center text-danger">
                    <i class="fas fa-user-circle fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        employee <br><%= totalNumberOfemployee %>

                    </p>
                </div>
            </div>

        </div>
        <div class="col-md-4">
            <div class="card ">
                <div class="card-body text-center text-danger">
                    <i class="fas fa-user-circle fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        User <br><%= totalNumberOfUser %>
                    </p>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>