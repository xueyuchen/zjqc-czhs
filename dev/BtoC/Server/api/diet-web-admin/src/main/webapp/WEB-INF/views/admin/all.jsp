<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../resources/app/js/js_lib/jquery.js"></script>
<script type="text/javascript"
    src="../resources/app/plupload/plupload.full.min.js"></script>
<script type="text/javascript"
    src="../resources/app/plupload/jquery.ui.plupload/jquery.ui.plupload.js"></script>
<script type="text/javascript"
    src="../resources/app/plupload/i18n/zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
    href="../resources/app/admin/style.css" />
<link rel="stylesheet" href="../resources/app/adminjs/bootstrap.min.css">
<link rel="stylesheet"
    href="../resources/app/adminjs/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/app/adminjs/dashboard.css">
<script type="text/javascript" src="../resources/app/constants.js"></script>
<script type="text/javascript" src="../resources/app/adminjs/listAcc.js"></script>
<script type="text/javascript"
    src="../resources/app/adminjs/bootstrap.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">配件销售系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-left">
                <input id="searchPar" class="form-control"
                    style="width: 500px; margin-left: 30%;" type="text"
                    placeholder="奥迪 A6L 2014 左大灯(查询条件请以空格分开)"
                    oninput="searchByLuceneAll();" />
            </form>
            <div class="btn-group"
                style="margin-top: 8px; float: right; margin-right: 10%;">
                <button type="button" class="btn btn-danger">批量修改</button>
                <button type="button" class="btn btn-danger dropdown-toggle"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="caret"></span> <span class="sr-only">Toggle
                        Dropdown</span>
                </button>
                <!-- <ul class="dropdown-menu">
                    <li><a href="javascript:void(0);">已选配件</a></li>
                    <li role="separator" class="divider"></li>
                </ul> -->
            </div>
        </div>
    </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li><a href="../admin/admin">成库照片上传</a></li>
                    <li><a href="../admin/changes">成库库存查询</a></li>
                    <li><a href="../admin/totalA">成库库存统计</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="../admin/uploadtoB">都库照片上传</a></li>
                    <li><a href="../admin/changesB">都库库存查询</a></li>
                    <li><a href="../admin/totalB">都库库存统计</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li class="active"><a href="../admin/findAll">总库存查询</a></li>
                    <li><a href="#">库存分类查询</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                	<li><a href="../admin/toSaled">已售配件修改</a></li>
                    <li><a href="../admin/statist">销售记录查询</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-sm-offset-3 col-md-12 col-md-offset-1 main">
                <div class="img-list" id="accessory-list"></div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    $('.dropdown-toggle').dropdown();
    $('#accessory-list').on('click', 'img', function(e) {
        var accessoryNum = $(e.target).parent().children('span').html();
        var accessoryName = $(e.target).parent().children('a').html();
        $('.dropdown-menu').append('<li><a href="javascript:void(0);">'+accessoryNum+'</a></li>');
    });
    $('.dropdown-menu').on('click', 'li', function(e){
        $(e.target).remove();
    });
</script>
</html>