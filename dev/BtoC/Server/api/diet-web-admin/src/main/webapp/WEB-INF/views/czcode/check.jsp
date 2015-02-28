<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="checkcode">
		<fieldset>
			<legend>残值编码查询</legend>
			<table>
				<tr>
					<td>残值编码：</td>
					<td><input type="text" name="codeNum"></td>
				</tr>
				<tr>
					<td><select name="local">
							<option value="sth">东部</option>
							<option value="est">南部</option>
							<option value="nth">西部</option>
							<option value="wst">北部</option>
					</select></td>
				</tr>
				<tr>
					<input type="submit" value="扫描">
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>