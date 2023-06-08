package controller;

import model.*;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {
    private final BookingService bookingService = BookingService.getInstance();
    private final UserService userService = UserService.getInstance();
    private final Home_StayService home_stayService = Home_StayService.getInstance();
    private final ActionService actionService = ActionService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "booking":
                bookingGet(request, response);
                break;
            case "booking2":
                try {
                    bookingBill(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "pay":
                payGet(request,response);
                break;
            case "cancel":
                cancel(request,response);
                break;
            case "cancelUser":
                cancelUser(request,response);
                break;
            case "bookingAdmin":
                bookingAdmin(request,response);
                break;
            case "bookingUser":
                bookingUser(request,response);
                break;
            default:
                findAdd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "search2":
                search2(request, response);
                break;
            case "bookingForm":
                try {
                    bookingBill(request,response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search4":
                search4(request, response);
                break;
        }
    }
    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("booking", bookingService.getList(bookingService));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void bookingAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("booking", bookingService.getList(bookingService));
        request.setAttribute("bookingId", id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void bookingUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
       User user = userService.getUserByID(id);
        List<Booking> bookingList = bookingService.getList(bookingService);
        List<Booking> bookingListUser = new ArrayList<>();
        for (Booking b : bookingList) {
            if(b.getUser().getId() == user.getId()){
                bookingListUser.add(b);
            }
        }
        request.setAttribute("booking", bookingListUser);
        request.setAttribute("bookingId", 2);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String home_name = request.getParameter("home_name");
        String address = request.getParameter("address");
        String depict = request.getParameter("depict");
        double price = Double.parseDouble(request.getParameter("price"));
        String  avatar = request.getParameter("avatar");
        int admin_id = Integer.parseInt(request.getParameter("admin_id"));
        int status_id = Integer.parseInt(request.getParameter("status_id"));
        User user = userService.getUserByID(admin_id) ;
        if (user != null) {
            response.sendRedirect("/Home_StayServlet");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Home_Stay homeStay = home_stayService.getHomeById(id);
        if (homeStay != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/update.jsp");
            request.setAttribute("home_stay", homeStay);
            request.setAttribute("user", userService.getList(bookingService));
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Home_Stay> home_stayList = home_stayService.searchName(search);
        request.setAttribute("home_stay", home_stayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Home_Stay> home_stayList = home_stayService.searchByStatus2();
        request.setAttribute("home_stay", home_stayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/getStatus.jsp");
        requestDispatcher.forward(request, response);
    }
    private void bookingGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Home_Stay home_stay = home_stayService.getHomeById(id);
        request.setAttribute("home_stay",home_stay);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void bookingBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        Home_Stay home_stay = home_stayService.getHomeById(id);
        int user_id = home_stay.getUser().getId();
        User user = userService.getUserByID(user_id);
        Date start_date= java.sql.Date.valueOf(request.getParameter("startDate"));
        Date end_date= java.sql.Date.valueOf(request.getParameter("endDate"));
        Action action = actionService.getById(1);
        int isBill = 1;
        Booking booking =new Booking(user,home_stay,start_date,end_date,action,isBill);
        bookingService.create(booking);
        request.setAttribute("booking", bookingService.getList(bookingService));
        request.setAttribute("home_stay", home_stayService.getList(bookingService));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home/HomeStay.jsp");
        requestDispatcher.forward(request, response);
    }
    private void search4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookingList = bookingService.getList(bookingService);
        List<Integer> dateList = new ArrayList<>();
        for (Booking b:bookingList) {
            int date = bookingService.dateDiff(b);
            dateList.add(date);
        }
        request.setAttribute("date", dateList);
        request.setAttribute("booking", bookingService.getList(bookingService));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void payGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Booking booking = bookingService.getBookingById(id);
        booking.setIsBill(0);
        bookingService.update(booking);
        Home_Stay homeStay = home_stayService.getHomeById(booking.getHomeStay().getId());
        Status newStatus = homeStay.getStatus();
        newStatus.setId(1);
        homeStay.setStatus(newStatus);
        home_stayService.update(homeStay);
        request.setAttribute("booking", bookingService.getList(bookingService));
        request.setAttribute("bookingId", 2);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);

    }

    private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookingService.deleteById(id);
        request.setAttribute("booking", bookingService.getList(bookingService));
        request.setAttribute("bookingId", 1);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void cancelUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookingService.deleteById(id);
        request.setAttribute("booking", bookingService.getList(bookingService));
        request.setAttribute("bookingId", 2);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
