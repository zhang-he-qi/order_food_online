<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/27
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生成订单信息</title>
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
    .size{
        width: 100%;
        height: 30px;
       /* border: 1px solid black;*/
        margin-top: 10px
    }
</style>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <br>
            <br>
            <form role="form" action="./getorderServlet" method="post">
                <div >
                    订餐人：<input type="text" class="form-control" id="customerName" value="" name="customerName"/>
                </div>
                <div >
                    送货地址：<input type="text" class="form-control" id="address" value="" name="address"/>
                </div>
                <div >
                    邮政编码：<input type="text" class="form-control" id="zipCode" value="" name="zipCode"/>
                </div>
                <div >
                    联系电话：<input type="text" class="form-control" id="telephone" value="" name="telephone"/>
                </div>
                <div >
                    移动电话<input type="text" class="form-control" id="mobile" value="" name="mobile"/>
                </div>
                <div >
                    电子邮件:<input type="email" class="form-control" id="eamil" value="" name="eamil"/>
                </div>
                <div class="checkbox size" >
                    配送方式：<label><input type="checkbox" />送餐上门</label>
                    10元起送
                </div>
                <div class="checkbox size" >
                    支付方式：<label><input type="checkbox" />餐到付款</label>
                    限北京三环内
                </div>
                <div>
                    订单附言：<input type="text" class="form-control" name="addmsg">
                </div>
                <div style="margin-top: 10px">
                    <button type="submit" >确认以上信息无误，提交！</button>
                </div>
            </form>

        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
</html>
