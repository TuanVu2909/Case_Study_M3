<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 03/06/2023
  Time: 9:24 SA
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
    <h1 style="text-align: center">Form update user</h1>
    <form style="width: 600px; margin: auto"
          action="/UserServlet?action=update&&id=${user.id}&&role=${user.role.id}&&password=${user.password}" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username"
                   placeholder="Enter name" value="${user.username}">
        </div>  <div class="mb-3">
        <label for="avatar" class="form-label">Avatar</label>
        <input type="text" class="form-control" id="avatar" name="avatar"
               placeholder="Enter name" value="${user.avatar}">
    </div>  <div class="mb-3">
        <label for="full_name" class="form-label">Full_Name</label>
        <input type="text" class="form-control" id="full_name" name="full_name"
               placeholder="Enter name" value="${user.fullName}">
    </div>  <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" class="form-control" id="address" name="address"
               placeholder="Enter name" value="${user.address}">
    </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone"
                   placeholder="Enter age" value="${user.phone}">
        </div>
        <div class="mb-3">
            <button class="btn btn-primary" type="submit">Update</button>
            <a class="btn btn-secondary" href="/UserServlet">Back to home</a>
            <a class="btn btn-primary" href="/UserServlet?action=change&&id=${user.id}">Change to Password</a>
        </div>
    </form>

</div>
</body>
</html>
