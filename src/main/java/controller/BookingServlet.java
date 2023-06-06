//package controller;
//
//import model.Home_Stay;
//import model.Role;
//import model.Status;
//import model.User;
////import service.BookingService;
//import service.Home_StayService;
//import service.StatusService;
//import service.UserService;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.util.Date;
//
//@WebServlet(name = "BookingServlet", value = "/BookingServlet")
//public class BookingServlet extends HttpServlet {
//    private final UserService userService = UserService.getInstance();
//    private final Home_StayService home_stayService = Home_StayService.getInstance();
//    private final StatusService statusService = StatusService.getInstance();
////    private final BookingService bookingService = BookingService.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//
//                break;
//            case "update":
//
//                break;
//            case "change":
//
//                break;
//            case "delete":
//
//                break;
//
//            default:
//
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//
//                break;
//            case "update":
//
//                break;
//            case "change":
//
//                break;
//            case "login":
//
//                break;
//        }
//    }
//
//    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("booking", bookingService.getList());
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("booking", bookingService.getList());
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/create.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
////    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////        int userId = Integer.parseInt(request.getParameter("user_id"));
////        int homeStayId = Integer.parseInt(request.getParameter("homeStay_id"));
////        int statusId = Integer.parseInt(request.getParameter("status_id"));
////        String start_date = request.getParameter("start_date");
////        String end_date = request.getParameter("end_date");
////        boolean action = Boolean.getBoolean("action");
////        User user = userService.getUserByID(userId);
////
////        Status status = statusService.getById(statusId);
////
////        if (user != null && status != null) {
////            bookingService.create(request);
////            response.sendRedirect("/");
////        } else {
////            response.sendRedirect("/404.jsp");
////        }
////    }
//
//}
