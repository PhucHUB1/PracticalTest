<%--<%@page import="com.hms.entity.employee"%>--%>
<%--<%@page import="com.hms.dao.employeeDAO"%>--%>
<%--<%@page import="com.hms.entity.Specialist"%>--%>
<%--<%@page import="java.util.List"%>--%>
<%--<%@page import="com.hms.db.DBConnection"%>--%>
<%--<%@page import="com.hms.dao.SpecialistDAO"%>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add</title>
    <%--Styles--%>
    <%@include file="../component/css.jsp" %>
</head>

<body>
<%--NavBar--%>
<%@include file="navbar.jsp"%>

<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-5 offset-4">
            <div class="card my-card">
                <div class="card-body">
                    <p class="fs-3 text-center text-danger">Add</p>

                    <!-- message print -->
                    <!-- for success msg -->
                    <c:if test="${not empty successMsg }">
                        <p class="text-center text-success fs-3">${successMsg}</p>
                        <c:remove var="successMsg" scope="session" />
                    </c:if>

                    <!-- for error msg -->
                    <c:if test="${not empty errorMsg }">
                        <p class="text-center text-danger fs-3">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <!-- End of message print -->

                    <!-- boostrap form -->
                    <form action="../addEmployee" method="post">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input name="fullName" type="text" placeholder="Enter full name" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input name="dateOfBirth" type="date" placeholder="Enter DOB" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input name="address" type="text" placeholder="Enter Address" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Position</label>
                            <input name="position" type="text" placeholder="Enter Position" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Department</label>
                            <input name="department" type="text" placeholder="Enter Department" class="form-control">
                        </div>

                        <button type="submit" class="btn btn-danger text-white col-md-12">Add</button>
                    </form>
                </div>

            </div>
        </div>

    </div>
</div>

</body>
</html>