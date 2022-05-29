package com.example.order_food_online;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author 啦啦啦
 */
@WebServlet(name = "getorderServlet", value = "/getorderServlet")
public class getorderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        String zipCode = request.getParameter("zipCode");
        String telephone = request.getParameter("telephone");
        String mobile = request.getParameter("mobile");
        String eamil = request.getParameter("eamil");
        String addmsg = request.getParameter("addmsg");

    }
}
