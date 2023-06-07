<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 07/06/2023
  Time: 9:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="path/to/bootstrap.min.css">
    <link rel="stylesheet" href="path/to/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="homecss.css">
</head>
<body>

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="Home_StayServlet" >Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
<c:if test="${sessionScope.username !=null}">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="btn btn-outline-success login-btn" href="/Login/login.jsp">Booking</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-success login-btn" href="/Login/login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-success login-btn" href="/Login/login.jsp">Login</a>
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
        </div>
    </nav>

    <ul class="dropdown-menu dropdown-menu-start"
        aria-labelledby="navbarDropdownMenuAvatar">
        <li>
            <a class="dropdown-item" href="#">My profile</a>
        </li>
        <li>
            <a class="dropdown-item" href="#">Settings</a>
        </li>
        <li>
            <a class="dropdown-item" href="#">Logout</a>
        </li>
    </ul>
    <div id="main_content">

        <div id="content">

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

<%--                <div class="card" style="width: 20rem; margin-right: 10px">--%>
<%--                    <img src="https://images.foody.vn/images/25152087_1007781622706987_3773708146294154795_n(2).jpg"--%>
<%--                         class="card-img-top" alt="...">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">Card title</h5>--%>
<%--                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of--%>
<%--                            the card's content.</p>--%>
<%--                        <a href="#" class="btn btn-primary">Book</a>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="card" style="width: 20rem;margin-right: 10px">--%>
<%--                    <img src="https://agotourist.com/wp-content/uploads/2020/04/pine-hill-homestay-da-lat.jpg"--%>
<%--                         class="card-img-top" alt="...">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">Card title</h5>--%>
<%--                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of--%>
<%--                            the card's content.</p>--%>
<%--                        <a href="#" class="btn btn-primary">Book</a>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="card" style="width: 20rem;margin-right: 10px">--%>
<%--                    <img src="https://zhomestay.vn/wp-content/uploads/2022/10/GTD_9713-copy.jpg" class="card-img-top"--%>
<%--                         alt="...">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">a</h5>--%>
<%--                        <p class="card-text">a</p>--%>
<%--                        <a href="#" class="btn btn-primary">Book</a>--%>
<%--                    </div>--%>
<%--                </div>--%>


            </div>
        </div>
        <div style="clear: both"></div>
    </div>
</div>

<footer class="text-center text-white" style="background-color: #f1f1f1;">
    <div class="container pt-4">
        <section class="mb-4">
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-facebook-f"></i
            ></a>

            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-twitter"></i
            ></a>

            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-google"></i
            ></a>

            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-instagram"></i
            ></a>

            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-linkedin"></i
            ></a>
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-github"></i
            ></a>
        </section>
    </div>

    <div class="text-center text-dark p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2020 Copyright:
        <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>

</footer>
</div>
</div>

<script>
    $(document).ready(function () {
        $('.dropdown-toggle').click(function (e) {
            e.preventDefault();
            $(this).parent().toggleClass('show');
        });

        $(document).click(function (e) {
            var target = e.target;
            if (!$(target).is('.dropdown-toggle') && !$(target).parents().is('.dropdown-toggle')) {
                $('.dropdown').removeClass('show');
            }
        });
    });
</script>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous">
</script>

<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous">
</script>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous">
</script>
</body>
</html>
