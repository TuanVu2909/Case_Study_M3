<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 07/06/2023
  Time: 5:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="bookingcss.css">
</head>
<body>
<div id="booking" class="section">
  <form action="/BookingServlet?action=search3&&id=${homestay.id}" method="post">
  <div class="section-center">
    <div class="container">
      <div class="row">
        <div class="col-md-7 col-md-push-5">
          <div class="booking-cta">
            <h1>Make your reservation</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi facere, soluta magnam consectetur molestias itaque
              ad sint fugit architecto incidunt iste culpa perspiciatis possimus voluptates aliquid consequuntur cumque quasi.
              Perspiciatis.
            </p>
          </div>
        </div>
        <div class="col-md-4 col-md-pull-7">
          <div class="booking-form">
            <form>
              <div class="form-group">
                <span class="form-label">${homestay.home_name}</span>
              </div>
              <div class="form-group">
                <span class="form-label">${homestay.address}</span>
              </div>
              <div class="row">
                <div class="col-sm-6">
                  <div class="form-group">
                    <span class="form-label">Check In</span>
                    <input class="form-control" type="date" required name="startDate">
                  </div>
                </div>
              </div>
                <div class="col-sm-6">
                  <div class="form-group">
                    <span class="form-label">Check out</span>
                    <input class="form-control" type="date" required name="endDate">
                  </div>
                </div>

                <div class="form-btn">
                  <button class="btn btn-danger" onclick="booking(${homestay.id})">Booking</button>
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
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
