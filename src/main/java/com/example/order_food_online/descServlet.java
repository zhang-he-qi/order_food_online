package com.example.order_food_online;

import Dao.FoodCRUD;
import entity.Food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author 啦啦啦
 */
@WebServlet(name = "descServlet", value = "/descServlet")
public class descServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("desc"));

        Food desc_food = new FoodCRUD().querybyid(id);
        if (desc_food != null) {
            request.setAttribute("desc_food", desc_food);
        } else {
            request.setAttribute("desc_msg", "未查找到此商品！");
        }
        request.getRequestDispatcher("#").forward(request, response);
    }
}
