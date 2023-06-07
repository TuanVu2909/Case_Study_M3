package controller;

import model.*;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Home_StayServlet", value = "/Home_StayServlet")
public class Home_StayServlet extends HttpServlet {
        private final Home_StayService home_stayService = Home_StayService.getInstance();
        private final UserService userService = UserService.getInstance();
        private final StatusService statusService = StatusService.getInstance();
        private final BookingService bookingService = BookingService.getInstance();

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
                case "bookingservice":
                    bookingservice(request, response);
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


            }
        }
        private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("home_stay", home_stayService.getList(bookingService));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home/HomeStay.jsp");
            requestDispatcher.forward(request, response);
        }
    private void bookingservice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("home_stay", home_stayService.getList(bookingService));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/home.jsp");
        requestDispatcher.forward(request, response);
    }
        private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("user", userService.getList(bookingService));
            request.setAttribute("status", statusService.getList(bookingService));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/create.jsp");
            requestDispatcher.forward(request, response);
        }
        private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int admin_id = Integer.parseInt(request.getParameter("admin_id"));
            int status_id = Integer.parseInt(request.getParameter("status_id"));
            if (userService.checkId(admin_id)&&statusService.checkID(status_id)) {
               home_stayService.save(request);
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
                request.setAttribute("status", statusService.getList(bookingService));
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect("/404.jsp");
            }
        }

        private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            int admin_id = Integer.parseInt(request.getParameter("admin_id"));
            int status_id = Integer.parseInt(request.getParameter("status_id"));

            if (userService.checkId(admin_id)&&home_stayService.checkID(id)&& statusService.checkID(status_id)){
              home_stayService.save(request);
                response.sendRedirect("/Home_StayServlet");
            } else {
                response.sendRedirect("/404.jsp");
            }
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
        List<Home_Stay> home_stayList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Home_Stay home_stay = home_stayService.getHomeById(id);
            home_stayList.add(home_stay);
            request.setAttribute("homestay",home_stay);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking/bookingDemo.jsp");
        requestDispatcher.forward(request, response);
    }
}
