package com.example.order_food_online;

import Dao.FoodCRUD;
import entity.Food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author 啦啦啦
 */
@WebServlet(name = "FoodListServlet", value = "/FoodListServlet")
public class FoodListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据库数据
        List<Food> foods = new FoodCRUD().query_foods();
        request.setAttribute("foodlist",foods);

        request.getRequestDispatcher("buyfood.jsp").forward(request,response);
    }
}
