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
    <h1 style="text-align: center">Form create HomeStay</h1>
    <form style="width: 600px; margin: auto" action="/Home_StayServlet?action=update&&id=${home_stay.id}" method="post">
    <div class="mb-3">
        <label for="home_name" class="form-label">HomeName</label>
        <input type="text" class="form-control" name="home_name"
               id="home_name" placeholder="Enter home_stay" value="${home_stay.home_name}">
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">address</label>
        <input type="text" class="form-control" name="address"
               id="address" placeholder="Enter address" value="${home_stay.address}">
    </div>
    <div class="mb-3">
        <label for="depict" class="form-label">depict</label>
        <input type="text" class="form-control" name="depict"
               id="depict" placeholder="Enter depict" value=" ${home_stay.depict}">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">price</label>
        <input type="text" class="form-control" name="price"
               id="price" placeholder="Enter price" value=" ${home_stay.price}" >
    </div>
    <div class="mb-3">
        <label for="avatar" class="form-label">avatar</label>
        <input type="text" class="form-control" name="avatar"
               id="avatar" placeholder="Enter avatar" value=" ${home_stay.avatar}">
    </div>
    <div class="mb-3">
        <label for="admin_id" class="form-label">admin_id</label>
        <select class="form-select" id="admin_id" name="admin_id"
                aria-label="Default select example">
            <option selected>--- Choice admin_id ---</option>
            <c:forEach items="${user}" var="u">
                <option value="${u.id}">${u.username}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <button class="btn btn-primary" type="submit">Update</button>
        <a class="btn btn-secondary" href="/Home_StayServlet">Back to HomeStay</a>
    </div>
    </form>
</div>
</body>
</html>
