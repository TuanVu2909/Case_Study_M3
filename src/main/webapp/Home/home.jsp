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
</div>
<form style="width: 600px; margin: auto"
      action="/UserServlet?action=login">
    <div class="row">
    <div class="col-lg-5">
    <a class="btn btn-secondary" href="/Login/login.jsp">Login</a>
    </div>
    <div class="col-lg-5">
        <a class="btn btn-secondary" href="/UserServlet">Back to Menu</a>
    </div>
    </div>
</div>
</form>
</body>
</html>
