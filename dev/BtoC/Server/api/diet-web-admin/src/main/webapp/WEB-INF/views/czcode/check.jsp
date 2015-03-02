<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="../resources/app/js/js_lib/jquery.js" /></script>
<script type="text/javascript">
	function sendForm() {
		$.ajax({
			type : "post",
			url : "checkcode.do",
			async : false,
			dataType : "json",
			data : {
				codeNum : $("#codeNum").val()
			},
			success : function(data) {
				var length = $("#table").find("tr").length;
				$("#table").append(
						"<tr><td>" + length + "</td><td>" + data.codeNum
								+ "</td><td>" + data.message + "</td<></tr>");
			},
			error : function(data) {
				alert(data.message);
			}
		});
		return false;
	}
</script>
<title>残值编码确认</title>
</head>
<body>
	<form>
		<fieldset>
			<legend>残值编码查询</legend>
			<table>
				<tr>
					<td>残值编码：</td>
					<td><input type="text" name="codeNum" id="codeNum"></td>
					<td>报案号：</td>
					<td><input type="text" name="reportCode" id="reportCode"></td>
					<td><input type="button" value="扫描" onclick="sendForm();">
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>残值编码查询</legend>
			<table id="table">
				<tr>
					<td>序号：</td>
					<td>已扫描的编码：</td>
					<td>编码状态：</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>