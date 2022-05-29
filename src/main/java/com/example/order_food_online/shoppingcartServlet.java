package com.example.order_food_online;

import Dao.FoodCRUD;
import entity.Food;
import entity.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "shoppingcartServlet", value = "/shoppingcartServlet")
public class shoppingcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("foodId"));
        Food food = new FoodCRUD().querybyid(Id);
        System.out.println(food.toString());

        HttpSession session = request.getSession();
        Map<Integer, cart> cart = (Map<Integer, cart>) session.getAttribute("cart");
        //判断购物车是否存在
        if (cart == null) {
            //不存在！创建购物车
            cart = new LinkedHashMap<>();
            //将第一个商品加入到购物车中
            cart.put(Id, new cart(food, 1));
        } else {
            //购物车存在
            if (cart.containsKey(Id)) {
                //包含该商品，将商品加一
                entity.cart item = cart.get(Id);
                item.setCount(item.getCount() + 1);
            } else {
//                不存在则新建
                cart.put(Id, new cart(food, 1));
            }
        }
        session.setAttribute("cart", cart);
    }
}
