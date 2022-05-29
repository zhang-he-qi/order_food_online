<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>

    .menu1 {
        border: 1px solid #037ac4;
        width: 350px;
        height: 205px;
        float: left;
    }

    .img {
        margin-left: 10px;
        margin-top: 55px;
        width: 80px;
        height: 80px;
        float: left;
    }

    .details {
        margin-top: 25px;
        float: left;
        width: 250px;
        height: 150px;
    }

    .foodname {
        width: 120px;
        line-height: 20px;
        height: 20px;
        margin-left: 10px;
        text-align: center;
        color: #575656;
    }

    .desciption {
        margin-top: 10px;
        width: 150px;
        text-align: center;
        height: 60px;
        color: #4b4b4b;
    }

    .price {margin-left: 10px;
        color: #fd6601;
    }

    .buy {
        float: left;
        width: 100px;
        text-align: center;
    }
</style>
<script>
    function addTocart(id) {
        $.get("./shoppingcartServlet?foodId="+id,function (resp) {
        },'json');
    }
</script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column" >

        </div>
        <div class="col-md-8 column">
            <br>
            <a href="/buyfoods/ShoppingCart.jsp"><button class="btn btn-primary">购物车</button></a>
            <br>
            <br>
            <c:forEach var="e" items="${requestScope.foodlist}">
                <div class="menu1">
                    <img class="img" src="./images/${e.foodImage}">

                    <div class="details">
                        <div class="foodname">${e.foodName}</div>
                        <div class="desciption">${e.remark}</div>
                        <div class="price" style="float: left">价格:${e.foodPrice}￥</div>
                        <div class="price" style="margin-left: 20px">编号:${e.foodId}</div>
                        <div class="buy">
                            <a href="javascript:addTocart(`${e.foodId}`)"><button class="btn btn-primary glyphicon glyphicon-shopping-cart">订购</button></a>
                        </div>
                        <div class="buy">
                            <a href="#?${e.foodId}" name="desc"><button class="btn btn-primary">详情</button></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
</html>
