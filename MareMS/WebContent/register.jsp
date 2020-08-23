<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String message = (String) session.getAttribute("status");
	if (message == null) {
		message = "";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	function isChecked(name) {
		if (name == "admin") {
			document.getElementById(name).style.visibility = "visible";
			document.getElementById("user").style.visibility = "collapse";
			document.getElementById("addr").style.visibility = "visible";
			document.getElementById("num").style.visibility = "visible";
		} else {
			document.getElementById("admin").style.visibility = "collapse";
			document.getElementById("user").style.visibility = "visible";
			document.getElementById("addr").style.visibility = "visible";
			document.getElementById("num").style.visibility = "visible";
		}
	}

	function quit() {
		window.location.href = "index.jsp"
	}
</script>
</head>
<body>
	<div id="Layer1"
		style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%">
		<img src="./image/3.png" width="100%" height="100%">
		<p class="title"
			style="position: absolute; left: 15%; top: 5%; font-size: 60px;">欢迎您的加入</p>
		<form action="regist_servlet"
			style="position: absolute; left: 35%; top: 30%;">
			<table>
				<tr style="padding-bottom: 5px">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-user"></span>用户名:</td>
					<td><input class="btn btn-default btn-lg" type="text"
						name="username" placeholder="请输入用户名" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr style="padding-bottom: 5px;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>密码:</td>
					<td><input class="btn btn-default btn-lg" type="password"
						name="password1" placeholder="请输入密码" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr style="padding-bottom: 5px;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>确认密码:</td>
					<td><input class="btn btn-default btn-lg" type="password"
						name="password2" placeholder="请确认密码" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr style="padding-bottom: 5px;">
					<td colspan="2"><label onclick="isChecked('admin')"
						style="margin-right: 45px;"> <input name="radio1"
							type="radio" value="Admin" />Admin
					</label> <label onclick="isChecked('user')" style="margin-right: 45px;">
							<input name="radio1" type="radio" value="销售商" />销售商
					</label> <label onclick="isChecked('user')"> <input name="radio1"
							type="radio" value="供应商" />供应商
					</label></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr id="user" style="padding-bottom: 5px; visibility: collapse;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>商店名:</td>
					<td><input class="btn btn-default btn-lg" type="text"
						name="name-market" placeholder="请输入店名" style="text-align: left;" /></td>
				</tr>

				<tr id="admin" style="padding-bottom: 5px; visibility: collapse;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>姓名:</td>
					<td><input class="btn btn-default btn-lg" type="text"
						name="name" placeholder="请输入姓名" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr id="addr" style="padding-bottom: 5px; visibility: collapse;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>地址:</td>
					<td><input class="btn btn-default btn-lg" type="text"
						name="addr" placeholder="请输入地址" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr id="num" style="padding-bottom: 5px; visibility: collapse;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>联系电话:</td>
					<td><input class="btn btn-default btn-lg" type="text"
						name="phone" placeholder="请输入电话" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

			</table>

			<div style="padding-bottom: 15px;">
				<input class="login btn btn-success" type="submit" value="注册"
					style="margin-right: 30px;" /> <a href="index.jsp"><input
					onclick="quit()" class="login btn btn-info" type="button"
					value="取消" style="float: right" /></a>
			</div>
		</form>
	</div>
	<div id="user" class="alert alert-warning"
		style="position: absolute; left: 65%; top: 35%; display: none;">用户名已存在!!!
	</div>
	<div id="psw" class="alert alert-warning"
		style="position: absolute; left: 65%; top: 35%; display: none;">两次密码不一致!!!
	</div>

	<%
		if (message.equals("user")) {
			session.removeAttribute("status");
	%>
	<script>
		alert("用户名已存在！！！");
	</script>
	<%
		}
	%>

	<%
		if (message.equals("password")) {
			session.removeAttribute("status");
	%>
	<script>
		alert("两次密码不一致！！！");
	</script>
	<%
		}
	%>

</body>
</html>