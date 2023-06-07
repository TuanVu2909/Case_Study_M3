<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 05/06/2023
  Time: 4:10 CH
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
</div>
<div class="col-lg-2">
    <form action="/BookingServlet?action=search3&&id=${homestay.id}" method="post">
        <button class="btn btn-info" type="submit">Search2</button>



<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Home_Name</th>
        <th>Address</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>User Name</th>
        <th>Price</th>
        <th>Avatar</th>
        <th colspan="2" style="text-align: center">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${homestay.id}</td>
        <td>${homestay.home_name}</td>
        <td>${homestay.address}</td>
        <td><input type="date" name="startDate" placeholder="YYYY/NN/ZZ"></td>
        <td><input type="date" name="endDate" placeholder="YYYY/NN/ZZ"></td>
        <td>${homestay.user.username}</td>
        <td>${homestay.avatar}</td>
        <td>

        </td>
        <td>
<%--            <button class="btn btn-danger" type="submit">Booking</button>--%>
    <button class="btn btn-danger" onclick="booking(${homestay.id})">Booking</button>
        </td>
        <%--        <td>--%>
        <%--          <a class="btn btn-warning" href="/Home_StayServlet?action=booking&&id=${homestay.id}">Booking</a>--%>
        <%--        </td>--%>
    </tr>
    <%--    </c:forEach>--%>
    </tbody>
</table>
</form>
</div>

</body>
<script>
    function booking(id) {
        if (confirm("Are you sure?")) {
            alert("Booking success!")
            window.location.href = `http://localhost:8080/BookingServlet?action=booking2&&id=` + id
        }
    }
</script>
</html>
