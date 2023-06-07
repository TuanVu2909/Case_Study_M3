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
        <div class="col-lg-6">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/Home_StayServlet">Back Home
                Booking</a>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Avatar</th>
            <th>Home Name</th>
            <th>Day</th>
            <th>Price</th>
            <th>Total price</th>
            <th colspan="2" style="text-align: center">Action</th>
        </tr>
        </thead>

        <jsp:useBean id="booking" scope="request" type="java.util.List"/>
            <c:forEach items="${booking}" var="b">

                <c:if test="${b.isBill == 1}">
                    <tr>
                        <td>${b.id}</td>
                        <td>${b.homeStay.avatar} </td>
                        <td>${b.homeStay.home_name}</td>
                        <td>${b.totalDay}</td>
                        <td>${b.homeStay.price}</td>
                        <td>${b.totalPrice}</td>
                        <td>
                            <button class="btn btn-danger" onclick="pay(${b.id})">Pay</button>
                            <button class="btn btn-danger" onclick="cancel(${b.id})">Cancel</button>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
<%--            <c:forEach items="${booking}" var="b">--%>
<%--                <c:if test="${b.isBill ==0}">--%>
<%--                    <tr>--%>
<%--                        <td>${b.id}</td>--%>
<%--                        <td>${b.homeStay.avatar} </td>--%>
<%--                        <td>${b.homeStay.home_name}</td>--%>
<%--                        <td>${b.totalDay}</td>--%>
<%--                        <td>${b.homeStay.price}</td>--%>
<%--                        <td>${b.totalPrice}</td>--%>
<%--                    </tr>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>
        </tbody>
    </table>
</div>
</body>
<script>
    function pay(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/BookingServlet?action=pay&&id=` + id
        }
    }

    function cancel(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/BookingServlet?action=cancel&&id=` + id
        }
    }
</script>
</html>
