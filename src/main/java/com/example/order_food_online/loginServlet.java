package com.example.order_food_online;

import Dao.UserCRUD;
import entity.User;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author 啦啦啦
 */
@WebServlet(name = "helloServlet", value = "/login_servlet")
public class loginServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new UserCRUD().queryUser(new User(username, password));

        if (user!=null){
            resp.sendRedirect(req.getContextPath()+"/FoodListServlet");
        }else {
            resp.sendRedirect(req.getContextPath());
        }
    }

//    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
//    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
    @Override
    public void destroy() {
    }
}