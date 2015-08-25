<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../resources/app/jsuser/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/app/admin/style.css"/>
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript" src="../resources/app/constants.js"></script>
</head>
<body>
<div class="container">
    <!--<div class="before-header">-->

    <!--</div>-->
    <header>
        <div class="title-box">
            <span>子杰汽车配件专卖</span>
        </div>
        <div class="search-box">
            <div class="search">
                <img src="image/search.png">
                <input id="searchPar" type="text" placeholder="奥迪 A6L 2014 左大灯(查询条件请以空格分开)"/>
                <button id="searchAccessory">搜索</button>
            </div>

        </div>
        <div class="login-box">
        </div>
    </header>
    <div class="advertising">
        <div class="advertising-left">
            <div><a href="#">入库查询</a></div>
            <div><a href="#">配件信息修改</a></div>
            <div><a href="#">入库查询</a></div>
            <div><a href="#">入库查询</a></div>
        </div>
        <div class="advertising-right"></div>
    </div>
    <div class="page-body">

        <div class="search-result">
            <div class="result-title">
                <input type="date" id="key" onchange="changeDate();"/>
            </div>
            <div class="img-list" id="accessory-list">
            </div>
        </div>
    </div>
</div>
</body>
</html>