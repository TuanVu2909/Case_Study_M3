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
    <title>HOME</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="cssHome.css">
    <link rel="stylesheet" href="path/to/bootstrap.min.css">
    <link rel="stylesheet" href="path/to/bootstrap-icons.css">

</head>
<body>
<%--<div>--%>
<%--    <div id="header" class="header">--%>
<%--        <div>--%>
<%--            <a href="#Logo">Logo</a>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <a class="active" href="#home">Home</a>--%>
<%--        </div>--%>
<%--<div>--%>
<%--    <input type="text" placeholder="Search..."/>--%>
<%--    <button class="btn btn-primary" type="button">--%>
<%--        <i class="bi bi-search"></i>--%>
<%--    </button>--%>
<%--</div>--%>
<%--        <div id="menuTop" class="aLogin">--%>
<%--            <a href="#login">Login</a>--%>
<%--            <a href="/UserServlet?action=create">register</a>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div id="menu" class="menu">--%>
<%--        <div>--%>
<%--            <a class="active" href="#menu1">menu1</a>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <a class="active" href="#menu2">menu2</a>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <a class="active" href="#menu3">menu3</a>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <a class="active" href="#menu4">menu4</a>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <a class="active" href="#menu5">menu5</a>--%>
<%--        </div>--%>

<%--    </div>--%>

<%--    <div id="main_content">--%>
<%--        <div id="left_sidebar">--%>
<%--            Left sidebar--%>
<%--        </div>--%>

<%--        <div id="content">--%>

<%--            <form action="">--%>
<%--                <img src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/283257417.jpg?k=e710ddf183c9d1f6d2752f9c4b19ed4eafb94b59b0b76d19ed4a2358a4f37db5&o=&hp=1" alt="My image" style="width: 300px; height: auto;"><br>--%>
<%--                <p>Name</p>--%>
<%--                <p>Address</p>--%>
<%--                <p>Price</p>--%>
<%--                <button type="submit">Book</button>--%>
<%--            </form>--%>

<%--            <form action="">--%>
<%--                <img src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/283257417.jpg?k=e710ddf183c9d1f6d2752f9c4b19ed4eafb94b59b0b76d19ed4a2358a4f37db5&o=&hp=1" alt="My image" style="width: 300px; height: auto;"><br>--%>
<%--                <p>Name</p>--%>
<%--                <p>Address</p>--%>
<%--                <p>Price</p>--%>
<%--                <button type="submit">Book</button>--%>
<%--            </form>--%>

<%--            <form action="">--%>
<%--                <p>Name</p>--%>
<%--                <p>Address</p>--%>
<%--                <p>Price</p>--%>
<%--                <button type="submit">Book</button>--%>
<%--            </form>--%>

<%--        </div>--%>
<%--        <div style="clear: both"></div>--%>
<%--    </div>--%>
<%--    </div>--%>

<%--    <div id="footer">--%>
<%--        Về chúng tôi--%>
<%--        Liên hệ--%>
<%--    </div>--%>
<%--</div>--%>


<div class="container">

    <div class="menu">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Logo</a>
            </div>
            <div>
                <form class="d-flex">
                    <a class="btn btn-outline-success login-btn">Login</a>
                    <a class="btn btn-outline-success register-btn">Register</a>
                </form>
            </div>
        </nav>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Home</a>
<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">menu 1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Menu 2</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Menu 3</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Menu 4</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            </form>
        </div>
    </nav>

    <div id="main_content">
        <div id="left_sidebar">
            <a href="#">sidebar1</a><br>
            <a href="#">sidebar2</a><br>
            <a href="#">sidebar3</a><br>
            <a href="#">sidebar4</a><br>
            <a href="#">sidebar5</a><br>
            <a href="#">sidebar6</a><br>
        </div>

        <div id="content">
            <div class= "row">

                <div class ="col-12 col-sm-6 col-md-4" image-container>
                    <img src="https://noithatkendesign.vn/storage/app/media/1%20b%C3%ACa/khong-gian-sinh-hoat-chung-ccasa-hostel-nha-trang.jpg" alt="image">
                    <form action="">
                        <p>Name</p>
                        <p>Address</p>
                        <p>Price</p>
                        <button type="submit">Book</button>
                    </form>
                </div>

                <div class ="col-12 col-sm-6 col-md-4" image-container>
                    <img src="https://images.foody.vn/images/25152087_1007781622706987_3773708146294154795_n(2).jpg" alt="image">
                    <form action="">
                        <p>Name</p>
                        <p>Address</p>
                        <p>Price</p>
                        <button type="submit">Book</button>
                    </form>
                </div>

                <div class ="col-12 col-sm-6 col-md-4" image-container>
                    <img src="https://agotourist.com/wp-content/uploads/2020/04/pine-hill-homestay-da-lat.jpg" alt="image">
                    <form action="">
                        <p>Name</p>
                        <p>Address</p>
                        <p>Price</p>
                        <button type="submit">Book</button>
                    </form>
                </div>

                <div class ="col-12 col-sm-6 col-md-4" image-container>
                    <img src="https://agotourist.com/wp-content/uploads/2020/04/pine-hill-homestay-da-lat.jpg" alt="image">
                    <form action="">
                        <p>Name</p>
                        <p>Address</p>
                        <p>Price</p>
                        <button type="submit">Book</button>
                    </form>
                </div>

            </div>
        </div>
        <div style="clear: both"></div>
    </div>

    <footer class="text-center text-white" style="background-color: #caced1;">

        <div class="container p-4">

            <section class="">
                <div class="row">
                    <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                        <div
                                class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                data-ripple-color="light"
                        >
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/new/fluid/city/113.webp"
                                    class="w-100"
                            />
                            <a href="#!">
                                <div
                                        class="mask"
                                        style="background-color: rgba(251, 251, 251, 0.2);"
                                ></div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                        <div
                                class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                data-ripple-color="light"
                        >
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/new/fluid/city/111.webp"
                                    class="w-100"
                            />
                            <a href="#!">
                                <div
                                        class="mask"
                                        style="background-color: rgba(251, 251, 251, 0.2);"
                                ></div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                        <div
                                class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                data-ripple-color="light"
                        >
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/new/fluid/city/112.webp"
                                    class="w-100"
                            />
                            <a href="#!">
                                <div
                                        class="mask"
                                        style="background-color: rgba(251, 251, 251, 0.2);"
                                ></div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                        <div
                                class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                data-ripple-color="light"
                        >
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/new/fluid/city/114.webp"
                                    class="w-100"
                            />
                            <a href="#!">
                                <div
                                        class="mask"
                                        style="background-color: rgba(251, 251, 251, 0.2);"
                                ></div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                        <div
                                class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                data-ripple-color="light"
                        >
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/new/fluid/city/115.webp"
                                    class="w-100"
                            />
                            <a href="#!">
                                <div
                                        class="mask"
                                        style="background-color: rgba(251, 251, 251, 0.2);"
                                ></div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                        <div
                                class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                data-ripple-color="light"
                        >
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/new/fluid/city/116.webp"
                                    class="w-100"
                            />
                            <a href="#!">
                                <div
                                        class="mask"
                                        style="background-color: rgba(251, 251, 251, 0.2);"
                                ></div>
                            </a>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2020 Copyright:
            <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>

    </footer>
</div>
</div>

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
