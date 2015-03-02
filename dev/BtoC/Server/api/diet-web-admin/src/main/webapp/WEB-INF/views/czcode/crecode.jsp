<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="../resources/app/js/js_lib/jquery.js" /></script>
<script type="text/javascript">
	function crecode() {
		var local = $("#local");
		var num = $("#num");
		if (!num) {
			alert("请输入需要创建的残值编码数量！");
			return false;
		}
		alert(local+num);
		$.ajax({
			type : "post",
			url : "createcode.do",
			async : false,
			dataType : "json",
			data : {
				local : local,
				num : num
			},
			success : function(data) {
				for (var i = 0; i < data.codes.length; i++) {
					$("#table").append(
							"<tr><td>" + i + "</td><td>"
									+ data.codes[i].codeNum + "</td<></tr>");
				}
			},
			error : function(data) {
				alert(data.message);
			}
		});
	}
</script>
<title>残值编码创建</title>
</head>
<body>
	<form action="new.do">
		<fieldset>
			<legend>残值编码创建</legend>
			<table>
				<tr>
					<td>编码归属区域</td>
					<td><select name="local">
							<option value="south">东部</option>
							<option value="east">南部</option>
							<option value="noth">西部</option>
							<option value="west">北部</option>
					</select></td>
					<td>生成编码数量</td>
					<td><input type="text" name="num"></td>
					<td><input type="button" value="生成编码" onclick="crecode();"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>残值编码</legend>
			<table>
				<tr>
					<td>序号：</td>
					<td>新的残值编码：</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>