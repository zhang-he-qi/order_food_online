package com.example.order_food_online;

import Dao.UserCRUD;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registServlet", value = "/registServlet")
public class registServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2)){
            boolean b = new UserCRUD().addUser(new User(username, password1));
            if (b){
                request.setAttribute("right_msg","注册成功！请登录！");
                request.getRequestDispatcher("index.jsp").forward(request,response);

            }else {
                request.setAttribute("wrong_msg","您注册的用户已存在！");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("pass_msg","输入的密码不一致！请重新输入！");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }
}
