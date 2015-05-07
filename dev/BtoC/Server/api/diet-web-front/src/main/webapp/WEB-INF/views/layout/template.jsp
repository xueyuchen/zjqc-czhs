<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
    href="../resources/app/lib/bootstrap/css/bootstrap.css">
<link href="../resources/app/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="../resources/app/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--web-fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--js-->
<script src="../resources/app/js/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="../resources/app/js/move-top.js"></script>
<script type="text/javascript" src="../resources/app/js/easing.js"></script>
    <script type="text/javascript">
            jQuery(document).ready(function($) {
                $(".scroll").click(function(event){     
                    event.preventDefault();
                    $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
                });
            });
    </script>
<!-- //end-smoth-scrolling -->
</head>
<body> 
<!--header start here-->
 <div class="header">
      <div class="container">
           <div class="header-bottom">
                 <h1>娈嬪�鍗曟煡璇�/h1>
                 <form>
                    <input type="text" value="Enter a Job Description" onfocus="this.value = '';" onblur="if (this.value = 'Enter a Job Description') {this.value = 'Enter a Job Description';}">
                    <input type="submit"  class="ser" value="鏌ヨ"><br>
                  <select name="cars">
                    <option value="select your location">娈嬪�鍗曞彿</option>
                    <option value="saab">娈嬪�缂栫爜</option>
                </select>
                 </form>                
           </div>
      </div>
 </div>
 <div class="intro-strip"> </div>
<!--about start here-->
 <div class="intro">
      <div class="container">
        <div class="intro-main">
                <h2>We're leaders in</h2>
                <h3>Creative Digital Recruitmemt</h3>
                <span class="b"> </span>
                <p>Based in Surry Hills, the creative hub of Sydney we are surrounded by creativity<br>and that reflects on the type of jobs we recruit for. </p>
                <h4><a href="#"> FIND OUT MORE ABOUT US!</a></h4>
        </div> 
        <div class="clearfix"> </div>    
     </div>
 </div>
</body>
<!--contant start here-->
<div class="strip"> </div>
<div class="contant">
      <div class="container">
           <div class="contant-main">
                <h3>Subscribe to our Job Seeker Mailing List</h3>
                <span class="search"> <input type="text" value="Enter Your Email Address"onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Your Email Address';}"/>

                <input type="submit" value=""></span>
           </div>
      </div>
</div>
<!--footer start here-->
<div class="strip"> </div>
<div class="footer-h">
      <div class="container">
            <div class="footer-main">
                <div class="col-md-6 footer-left">
                     <p class="data"> <a href="mailto:example@mail.com"> Hello@ twobytes.com.au </a> <span class="d"> </span></p>
                     <p> 2014 &copy Template by <a href="http://w3layouts.com/"> W3layouts </a></p>
                </div>
                <div class="col-md-6 footer-right">
                     <ul>
                        <li><a href="#"> <span class="x"> </span> </a></li>
                        <li class="m">692</li>
                        <li><a href="#"> <span class="y"> </span> </a></li>
                        <li class="r"> 117</li>
                     </ul>
                </div>
            <div class="clearfix"> </div>
            </div>
      </div>
</div></html>