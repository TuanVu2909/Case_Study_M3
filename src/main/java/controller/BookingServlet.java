package controller;

import model.*;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            case "delete":
                delete(request, response);
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
            case "search3":
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
        request.setAttribute("booking", bookingService.getList());
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
            request.setAttribute("user", userService.getList());
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        home_stayService.deleteById(id);
        response.sendRedirect("/Home_StayServlet");
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
        List<Booking> bookingList = bookingService.getList();
        List<Integer> dateList = new ArrayList<>();
        for (Booking b:bookingList) {
            int date = bookingService.dateDiff(b);
            dateList.add(date);
        }
        request.setAttribute("date", dateList);
        request.setAttribute("booking", bookingService.getList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void search4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookingList = bookingService.getList();
        List<Integer> dateList = new ArrayList<>();
        for (Booking b:bookingList) {
            int date = bookingService.dateDiff(b);
            dateList.add(date);
        }
        request.setAttribute("date", dateList);
        request.setAttribute("booking", bookingService.getList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/home.jsp");
        requestDispatcher.forward(request, response);
    }


}
