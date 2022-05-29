<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">

    <title>在线点餐登录</title>
    <link rel="stylesheet" href="./html_css_demo/css/81.css">
</head>
<body>
<div class="container">
    <div class="form-box">
        <!-- 注册 -->
        <div class="register-box hidden">
            <h1>register</h1>
            <form method="post" action="/buyfoods/registServlet" class="register-box">
                <h5 style="color: orangered">${pass_msg}</h5>
                <h5 style="color: orangered">${wrong_msg}</h5>
                <h5 style="color: orangered">${right_msg}</h5>
                <input type="text" name="username" placeholder="用户名" required>
                <input type="password" name="password1" placeholder="密码" required>
                <input type="password" name="password2" placeholder="确认密码" required>
                <button type="submit" id="regist" >注册</button>
            </form>

        </div>
        <!-- 登录 -->
        <div class="login-box">
            <h1>login</h1>
            <form action="/buyfoods/login_servlet" method="post" class="login-box">
                <input type="text" name="username" placeholder="用户名" required>
                <input type="password"  name="password" placeholder="密码" required>
                <button id="load_in" type="submit">登录</button>
            </form>

        </div>
    </div>
    <div class="con-box left">
        <h2>欢迎来到<span>蓝桥</span>在线餐厅</h2>
        <p>快来选择你的<span>美食</span>吧</p>
        <img src="./html_css_demo/img/login.jpg" alt="">
        <p>已有账号</p>
        <button id="login">去登录</button>
    </div>
    <div class="con-box right">
        <h2>欢迎来到<span>蓝桥</span>在线餐厅</h2>
        <p>快来看看有哪些你喜欢的<span>美食</span>吧</p>
        <img src="./html_css_demo/img/regist.webp">
        <p>没有账号？</p>
        <button id="register">去注册</button>
    </div>
</div>
<script>
    // 要操作到的元素
    let login=document.getElementById('login');
    let register=document.getElementById('register');
    let form_box=document.getElementsByClassName('form-box')[0];
    let register_box=document.getElementsByClassName('register-box')[0];
    let login_box=document.getElementsByClassName('login-box')[0];
    // 去注册按钮点击事件
    register.addEventListener('click',()=>{
        form_box.style.transform='translateX(80%)';
        login_box.classList.add('hidden');
        register_box.classList.remove('hidden');
    })
    // 去登录按钮点击事件
    login.addEventListener('click',()=>{
        form_box.style.transform='translateX(0%)';
        register_box.classList.add('hidden');
        login_box.classList.remove('hidden');
    })

</script>

<script>
    console.log(${wrong_msg})
    console.log(${pass_msg})
    console.log(${right_msg})
</script>
</body>

</html>