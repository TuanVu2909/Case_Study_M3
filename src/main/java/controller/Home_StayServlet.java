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

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        }

}
