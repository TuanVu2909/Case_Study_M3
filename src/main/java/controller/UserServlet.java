package controller;

import model.Role;
import model.User;
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
//            case "search":
//                search(request, response);
//                break;
        }
    }
    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", userService.getList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("role", roleService.getList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int roleId = Integer.parseInt(request.getParameter("role"));
        Role role = roleService.getById(roleId);
        if (role != null) {
            User user = new User( username, password, avatar, full_name, address,phone,role);
            userService.create(user);
            response.sendRedirect("/UserServlet");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserByID(id);
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/update.jsp");
            request.setAttribute("user", user);
            request.setAttribute("role", roleService.getList());
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int roleId = Integer.parseInt(request.getParameter("role"));
        Role role = roleService.getById(roleId);
        User user = new User(id,username,password,avatar,full_name,address,phone,role);
        if (user != null) {
            userService.update(new User(id,username,password,avatar,full_name,address,phone,role));
            response.sendRedirect("/UserServlet");
        }else  {
            response.sendRedirect("/404.jsp");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteById(id);
        response.sendRedirect("/UserServlet");
    }
//
//    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String search = request.getParameter("search");
//        List<Student> students = studentService.searchByName(search);
//        request.setAttribute("students", students);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/home.jsp");
//        requestDispatcher.forward(request, response);
//    }
    private void changeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserByID(id);
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/User/change.jsp");
            request.setAttribute("user", user);
            request.setAttribute("role", roleService.getList());
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }

    }
    private void changePot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        String avatar = request.getParameter("avatar");
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int roleId = Integer.parseInt(request.getParameter("role"));
        Role role = roleService.getById(roleId);
        User user = new User(id,username,newPassword,avatar,full_name,address,phone,role);
        if (user != null) {
            userService.update(user);
            response.sendRedirect("/UserServlet");
        }else  {
            response.sendRedirect("/404.jsp");
        }
    }
}
