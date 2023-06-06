package controller;

import model.Home_Stay;
import model.Role;
import model.Status;
import model.User;
import service.Home_StayService;
import service.RoleService;
import service.StatusService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Home_StayServlet", value = "/Home_StayServlet")
public class Home_StayServlet extends HttpServlet {
        private final Home_StayService home_stayService = Home_StayService.getInstance();
        private final UserService userService = UserService.getInstance();
        private final StatusService statusService = StatusService.getInstance();

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
            request.setAttribute("home_stay", home_stayService.getList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/home.jsp");
            requestDispatcher.forward(request, response);
        }

        private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("user", userService.getList());
            request.setAttribute("status", statusService.getList());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home_Stay/create.jsp");
            requestDispatcher.forward(request, response);
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
            Status status = statusService.getById(status_id);
            if (user != null) {
                Home_Stay homeStay = new Home_Stay(home_name,address,depict,price,avatar,user,status);
                home_stayService.create(homeStay);
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
                request.setAttribute("status", statusService.getList());
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect("/404.jsp");
            }
        }

        private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String home_name = request.getParameter("home_name");
            String address = request.getParameter("address");
            String depict = request.getParameter("depict");
            double price = Double.parseDouble(request.getParameter("price"));
            String  avatar = request.getParameter("avatar");
            int admin_id = Integer.parseInt(request.getParameter("admin_id"));
            int status_id = Integer.parseInt(request.getParameter("status_id"));
            User user = userService.getUserByID(admin_id) ;
            Status status = statusService.getById(status_id);
            Home_Stay homeStay = new Home_Stay(id,home_name,address,depict,price,avatar,user,status);
            if (user != null){
                home_stayService.update(homeStay);
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
}
