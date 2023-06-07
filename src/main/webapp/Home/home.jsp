<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 03/06/2023
  Time: 6:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${sessionScope.username !=null}">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="btn btn-outline-success login-btn" href="/Login/login.jsp">Booking</a>
        </li>

        <li class="nav-item">
            <a class="btn btn-outline-success login-btn" href="/Login/login.jsp">Login</a>
        </li>
    </ul>
</c:if>
<form class="form-inline my-2 my-lg-0">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
</form>
<c:if test="${sessionScope.username ==null}">
    <div>
        <a class="btn btn-outline-success login-btn" href="/Login/login.jsp">Login</a>
    </div>

    <div>
        <a class="btn btn-outline-success register-btn" href="/User/Register.jsp">Register</a>
    </div>
</c:if>
<c:if test="${sessionScope.username !=null}">
    <div>
        <p>${sessionScope.username.username}</p>
        <a class="btn btn-outline-success register-btn" href="/UserServlet?action=logout">Logout</a>
    </div>
</c:if>


<div class="row">
    <c:forEach items="${home_stay}" var="h">

    <div class="card" style="width: 20rem;margin-right: 10px">
        <img src="https://noithatkendesign.vn/storage/app/media/1%20b%C3%ACa/khong-gian-sinh-hoat-chung-ccasa-hostel-nha-trang.jpg"
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${h.home_name}</h5>
            <p class="card-text">${h.address}</p>
            <h5>${h.price}</h5>
            <a href="#" class="btn btn-primary">Book</a>
        </div>
    </div>
    </c:forEach>



</body>
</html>
