<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 啦啦啦
  Date: 2022/5/27
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="./bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="./js/jquery-2.2.4.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px;">
    <div class="row clearfix">
        <div class="col-md-10 column col-md-offset-1">

            <div class="panel panel-primary">
                <div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> 已点商品</div>

                <div class="panel-body">
                    <table class="table table-bordered table-striped table-hover text-center">
                        <tr>
                            <th class="text-center">编号</th>
                            <th class="text-center">商品图片</th>
                            <th class="text-center" style="vertical-align: center">商品名称</th>
                            <th class="text-center">单价</th>
                            <th class="text-center">数量</th>
                            <th class="text-center">金额</th>
                        </tr>
                        <c:set var="sum" value="${0}" scope="session"></c:set>

                        <c:forEach var="e" items="${sessionScope.cart.values()}">
                            <tr>
                                <td>${e.food.foodId}</td>
                                <td><img width="80" height="80" src="./images/${e.food.foodImage}" alt=""></td>
                                <td>${e.food.foodName}</td>
                                <td>${e.food.foodPrice}</td>
                                <td>${e.count}</td>
                                <td>${e.food.foodPrice * e.count}</td>
                            </tr>

                            <c:set var="sum" value="${sum+e.food.foodPrice * e.count}" scope="session"/>
                        </c:forEach>
                        <tr>
                            <th colspan="5" class="text-center">总计:${sum}￥</th>
                        </tr>
                    </table>
                </div>

                <div class="panel-footer" >
                    <div style="margin-right: 50px">
                        <button class="btn btn-primary" type="button">清空购物车</button>
                        <a href="./FoodListServlet"><button class="btn btn-primary" type="button">继续购物</button></a>
                        <a href="order.jsp"><button class="btn btn-primary" type="button">下单</button></a>
                    </div>

                </div>
            </div>
        </div>
    </div>

</div>
<div class="col-md-1 column"></div>
</div>
</div>
</body>
</html>
