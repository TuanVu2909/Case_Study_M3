<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 03/06/2023
  Time: 9:25 SA
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

<div class="container">
    <h1 style="text-align: center">List Home_Stay</h1>
    <div class="row">
        <div class="col-lg-2">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/Home_StayServlet?action=create">Create
                new Search</a>
        </div>
        <div class="col-lg-6">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/UserServlet">Back Home User</a>
        </div>
        <div class="col-lg-2">
            <form action="/Home_StayServlet?action=search" method="post">
                <input type="text" name="search">
                <button class="btn btn-info" type="submit">Search</button>
            </form>
        </div>
        <div class="col-lg-2">
            <form action="/Home_StayServlet?action=search2" method="post">
                <button class="btn btn-info" type="submit">Search2</button>
            </form>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Thời gian thuê</th>
            <th>Home_Name</th>
            <th>User_Name</th>
            <th>Status</th>
            <th colspan="2" style="text-align: center">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${booking}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.start_date} </td>
                <td>${b.homeStay.home_name}</td>
                <td>${b.user.username}</td>
                <td>${b.homeStay.status.name}</td>
                <td>
                    <a class="btn btn-warning" href="/Home_StayServlet?action=update&&id=${b.id}">Info</a>
                </td>
                <td>
                    <button class="btn btn-danger" onclick="deleteS(${b.id})">Delete</button>
                </td>
                <td>
                    <a class="btn btn-warning" href="/Home_StayServlet?action=booking&&id=${b.id}">Booking</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script>
    function deleteS(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/Home_StayServlet?action=delete&&id=` + id
        }
    }
</script>
</html>
