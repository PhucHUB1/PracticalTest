<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
    <%--Styles--%>
    <%@include file="../component/css.jsp" %>
</head>

<body>
<%--NavBar--%>
<%@include file="../component/navbar.jsp" %>

<%--Admin Login--%>
<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-header text-center text-white bg-primary">

                    <p class="fs-4 text-center text-white mt-2">
                        <i class="fa fa-universal-access"></i> Admin Login
                    </p>
                </div>
                <div class="card-body">
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


                    <!-- boostrap form -->
                    <form action="adminLogin" method="post">
                        <div class="mb-3">
                            <label class="form-label">Email address</label> <input
                                name="email" type="email" placeholder="Enter Email"
                                class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label> <input
                                name="password" type="password" placeholder="Enter password"
                                class="form-control">
                        </div>

                        <button type="submit"
                                class="btn btn-primary text-white col-md-12">Submit
                        </button>
                    </form>
                    <!-- end of boostrap form -->
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>