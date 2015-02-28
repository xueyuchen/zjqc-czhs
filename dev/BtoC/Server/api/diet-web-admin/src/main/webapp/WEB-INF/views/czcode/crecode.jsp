<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="new.do">
		<table>
			<tr>
				<td>生成编码数量</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td>编码归属区域</td>
				<td><select name="loca">
						<option value="sth">东部</option>
						<option value="est">南部</option>
						<option value="nth">西部</option>
						<option value="wst">北部</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="生成编码"></td>
			</tr>
		</table>

	</form>
</body>
</html>