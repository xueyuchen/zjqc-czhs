<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>残值单、残值编码查询系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="./resources/app/picc/index.css" rel="stylesheet">
<link href="./resources/app/picc/index_base.css" rel="stylesheet">
<link href="./resources/app/picc/bug_default2.css" rel="stylesheet">
<link href="./resources/app/css/avgrund.css" rel="stylesheet">
<script type="text/javascript" src="./resources/app/js/index.js"></script>
<script type="text/javascript" src="./resources/app/lib/popup.js"></script>
</head>
<body>
	<div id="header">
		<h1 class="logo">
			<a href="http://www.epicc.com.cn" title="PICC中国人民财险"> <img
				src="./resources/app/images/logo.png">
			</a>
		</h1>
		<div class="tel"></div>
		<div class="link">
			<h1>
				<a href="http://www.piccamc.com/" title="人保资产">人保资产</a> | <a
					href="http://www.picchealth.com/" title="人保健康">人保健康</a> | <a
					href="http://www.picclife.cn/" title="人保寿险">人保寿险</a> | <a
					href="http://www.picc.com/" title="人保集团">人保集团</a> | <a
					href="http://www.epicc.com.cn" title="PICC中国人民财险">中保官网 </a> | <a
					href="users/login">管理登陆</a>
			</h1>
		</div>
	</div>
	<div class="main">
		<div id="slider">
			<ol class="player">
				<li><a><img src="./resources/app/images/banner.jpg" alt="1" /></a></li>
			</ol>
			<ol class="btns">
				<li>1</li>
			</ol>
		</div>
		<div class="query">
			<div style="margin: 0 auto; width: 80%;">
				<form action="users/downjpg" method="post"
					style="padding-top: 100px;">
					<span
						style="margin-top: 10px; font-size: 24px; color: white; padding-bottom: 20%;">选择查询条件进行查询</span>
					<div style="padding-top: 10px;">
						<select id="option" style="border: none; padding: 10px"
							onchange="empty();">
							<option value="czdh">残值单号</option>
							<option value="czbm">残值编码</option>
							<option value="cph">车牌号</option>
						</select> <input type="text" id="code" name="code" />
					</div>
					<div style="padding-top: 10px;">
						<input type="button" value="查询" onclick="querycode();"
							style="width: 113px; height: 44px; float: left;" /> <input
							id="submit" type="submit" value="下载"
							style="width: 113px; height: 44px; float: left;" /><input
							type="text" id="carLicensePlate" name="carLicensePlate"
							style="font-size: 15px; display: none" readonly="readonly" />
					</div>
				</form>
			</div>
		</div>
		<div class="result avgrund-popup" id="result1">
			<table style="margin: 0 auto;">
				<tr>
					<td style="font-size: 20px;">残值单号：</td>
					<td><input type="text" id="paperCode" name="paperCode"
						style="font-size: 15px;" readonly="readonly" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">报案号：</td>
					<td><input type="text" id="reportCode" name="reportCode"
						style="font-size: 15px;" readonly="readonly" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">车牌号：</td>
					<td><input type="text" id="carLicensePlate2"
						name="carLicensePlate" style="font-size: 15px;"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">定损员：</td>
					<td><input type="text" id="workers" name="workers"
						style="font-size: 15px;" readonly="readonly" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">上缴数量：</td>
					<td><input type="text" id="countNum" name="countNum"
						style="font-size: 15px;" readonly="readonly" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">录入日期：</td>
					<td><input type="text" id="entryDt" name="entryDt"
						style="font-size: 15px;" readonly="readonly" /></td>
				</tr>
				<input type="button" class="closePopup" value="关闭" onclick="closePopup();"/>
			</table>
		</div>
		<div class="result avgrund-popup" id="result2">
			<table style="margin: 0 auto;">
				<tr>
					<td style="font-size: 20px;">定损员：</td>
					<td><input type="text" style="font-size: 15px;"
						id="workerName" name="workerName" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">归属地：</td>
					<td><input type="text" style="font-size: 15px;" id="local"
						name="local" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">生成日期：</td>
					<td><input type="text" style="font-size: 15px;" id="creDt"
						name="creDt" /></td>
				</tr>
				<tr>
					<td style="font-size: 20px;">录入日期：</td>
					<td><input type="text" style="font-size: 15px;" id="entryDt1"
						name="entryDt1" /></td>
				</tr>
				<input type="button" class="closePopup" value="关闭" onclick="closePopup();"/>
			</table>
		</div>
	</div>
	<div class="form" style="display: none">
		<span style="font-size: 24px;"><dt></dt>公司简介</span><br>
		<div class="form-title">
			<span>全国率先采用二维码技术，定位、跟踪残值配件，一物一码的策略保证每件残值配件都有一个唯一的专属二维码，确保每一件残值配件均能得到有效地回收.</span>
		</div>
	</div>
	<div class="form" style="margin-top: 10px;">
		<span style="font-size: 24px;"><dt></dt>公司特色</span>
		<div class="form-one">
			<img alt="" src="./resources/app/images/czbm.png">
			<div>全国率先采用二维码技术，定位、跟踪残值配件，一物一码的策略保证每件残值配件都有一个唯一的专属二维码，确保每一件残值配件均能得到有效地回收。</div>
		</div>
		<div class="form-one" style="margin-left: 32%;">
			<img alt="" src="./resources/app/images/wechat.png">
			<div>全国率先基于微信平台查询回收结果，客户可以通过本公司微信公众号查询回收结果，使用户更方便的了解回收进度。</div>
		</div>
		<div class="form-one" style="margin-left: 58%;">
			<img src="./resources/app/images/czhdb.jpg">
			<div>回收检查完毕提供确认单据下载。</div>
		</div>
	</div>
	<div style="margin-top: 10%;"></div>
	<div class="footerM">
		<div class="foot-link">
			<h1>公司地址：成都市黄荆路东沿线</h1>
			<br>
			<h1>联系电话：4009-95518-4</h1>
		</div>
	</div>
	<script src="./resources/app/jsuser/jquery.min.js"></script>
	<script>
		//<![CDATA[
		function gebi(id) {
			return document.getElementById(id);
		};
		function getByClass(className, context) {
			/*
			 * 功能说明：
			 * 传入类名、节点名（默认document），获取context下类名为classNa的节点
			 */
			context = context || document;
			if (context.getElementsByClassName) {
				return context.getElementsByClassName(className);
			} else {
				var nodes = [];
				var tags = context.getElementsByTagName('*');
				for (var i = 0, len = tags.length; i < len; i++) {
					if (hasClass(tags[i], className)) {
						nodes.push(tags[i]);
					}
				}
				return nodes;
			}
		}
		function hasClass(node, className) {
			/*
			 * 功能说明：
			 * 传入节点及一个类名，检查该节点是否含有传入的类名
			 */
			var names = node.className.split(/\s+/);
			for (var i = 0, len = names.length; i < len; i++) {
				if (names[i] == className) {
					return true;
				}
			}
			return false;
		}
		function animate(o, start, alter, dur, fx) {
			/*
			 * 功能说明：
			 * 设置动画
			 * o:要设置动画的对象
			 * start:开始的对象
			 * alter:总的对象
			 * dur:动画持续多长时间
			 * fx:动画类型
			 */
			var curTime = 0;
			var t = setInterval(function() {
				if (curTime >= dur)
					clearInterval(t);
				for ( var i in start) {
					o.style[i] = fx(start[i], alter[i], curTime, dur) + "px";
				}
				curTime += 40;
			}, 40);
			return function() {
				clearInterval(t);
			};
		}
		var Tween = {
			/*
			 * 功能说明：
			 * 加速运动
			 * curTime:当前时间,即动画已经进行了多长时间,开始时间为0
			 * start:开始值
			 * alter:总的变化量
			 * dur:动画持续多长时间
			 */
			Linear : function(start, alter, curTime, dur) {
				return start + curTime / dur * alter;
			},//最简单的线性变化,即匀速运动
			Quad : {//二次方缓动
				easeIn : function(start, alter, curTime, dur) {
					return start + Math.pow(curTime / dur, 2) * alter;
				},
				easeOut : function(start, alter, curTime, dur) {
					var progress = curTime / dur;
					return start - (Math.pow(progress, 2) - 2 * progress)
							* alter;
				},
				easeInOut : function(start, alter, curTime, dur) {
					var progress = curTime / dur * 2;
					return (progress < 1 ? Math.pow(progress, 2)
							: -((--progress) * (progress - 2) - 1))
							* alter / 2 + start;
				}
			},
		};
		function Player(btns, scrollContent, imgHeight, timeout, hoverClass) {
			/*
			 * btns:按钮，类型是数组
			 * scrollContent:摇滚动的块，一个DOM对象，这里是ol
			 * imgHeight:每一张图片的高度，当然，如果想改成左右滚动，这里传入每一张图片的宽，唯一需要注意的是每一张图片宽高必须相同，图片数量可调整
			 * timeout:切换速度快慢，默认为1.5ms
			 * hoverClass:每一个按钮激活时的类名
			 */
			hoverClass = hoverClass || 'active';
			timeout = timeout || 1500;
			this.btns = btns;
			this.scrollContent = scrollContent;
			this.hoverClass = hoverClass;
			this.timeout = timeout;
			this.imgHeight = imgHeight;
			var _this = this;
			for (var i = 0; i < btns.length; i++) {
				this.btns[i].index = i;
				btns[i].onmouseover = function() {
					_this.stop();
					_this.invoke(this.index);
				}
				btns[i].onmouseout = function() {
					_this.start();
				}
			}
			this.invoke(0);
		}
		Player.prototype = {
			constructor : Player,
			start : function() {
				var _this = this;
				this.stop();
				this.intervalId = setInterval(function() {
					_this.next();
				}, this.timeout);
			},
			stop : function() {
				clearInterval(this.intervalId);
			},
			invoke : function(n) {
				this.pointer = n;
				if (this.pointer >= this.btns.length) {
					this.pointer = 0;
				}
				this.clearHover();
				this.btns[this.pointer].className = this.hoverClass;
				//this.scrollContent.style.top = parseInt(-this.imgHeight * this.pointer) + 'px';
				var startVal = parseInt(this.scrollContent.style.top) || 0;
				var alterVal = (parseInt(-startVal - this.imgHeight
						* this.pointer));
				this.animateIterval && this.animateIterval();//修正快速切换时闪动
				this.animateIterval = animate(this.scrollContent, {
					top : startVal
				}, {
					top : alterVal
				}, 1000, Tween.Quad.easeOut);
				//这里默认设置每张图滚动的总时间是1s
			},
			next : function() {
				this.invoke(this.pointer + 1);
			},
			clearHover : function() {
				for (var i = 0; i < this.btns.length; i++) {
					this.btns[i].className = '';
				}
				;
			}
		};
		window.onload = function() {
			var btns = getByClass('btns', gebi('slider'))[0]
					.getElementsByTagName('li');
			var player = getByClass('player', gebi('slider'))[0];
			var player = new Player(btns, player, 368, 3000, undefined);
			player.start();
			//player.invoke(2);
		};
		//]]>
		console.log($(window).height());
		console.log($(window).width());
		$("li img").css({
			width : ($(window).width()) / 2
		});
	</script>
</body>
</html>