package controller;

import model.Role;
import model.User;
import model.Validate;
import service.BookingService;
import service.RoleService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final RoleService roleService = RoleService.getInstance();

    private final BookingService bookingService = BookingService.getInstance();
    private final Validate validate = Validate.getInstance();


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
            case "change":
                changeGet(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "logout":
                logout(request, response);
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
            case "change":
                changePot(request, response);
                break;
            case "login":
                loginPot(request, response);
                break;
        }
    }

    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", userService.getList(bookingService));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("role", roleService.getList(bookingService));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roleId = Integer.parseInt(request.getParameter("role"));

        if (roleService.checkById(roleId)) {
            userService.save(request);
            response.sendRedirect("/UserServlet");

        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (userService.checkId(id)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/update.jsp");
            request.setAttribute("user", userService.getUserByID(id));
            request.setAttribute("role", roleService.getList(bookingService));
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int roleId = Integer.parseInt(request.getParameter("role"));

        if (userService.checkId(id) && roleService.checkById(roleId)) {
            userService.save(request);
            response.sendRedirect("/Home_StayServlet");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteById(id);
        response.sendRedirect("/UserServlet");
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/Home_StayServlet");
    }

    private void changeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserByID(id);
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/change.jsp");
            request.setAttribute("user", user);
            request.setAttribute("role", roleService.getList(bookingService));
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }

    }

    private void changePot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        String avatar = request.getParameter("avatar");
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int roleId = Integer.parseInt(request.getParameter("role"));
        Role role = roleService.getById(roleId);
        User user = new User(id, username, newPassword, avatar, full_name, address, phone, role);
        if (user != null) {
            userService.update(user);
            response.sendRedirect("/Home_StayServlet");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void loginPot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> userList = userService.getList(bookingService);
        boolean flag = false;
        for (User u : userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                if (u.getRole().getId() == 1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    response.sendRedirect("/Home_StayServlet");
                    flag = true;
                    break;
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    response.sendRedirect("/Home_StayServlet");
                    flag = true;
                    break;
                }
            }

        }
        if (!flag) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/404.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
