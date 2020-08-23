<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String message = (String) session.getAttribute("message");
	if (message == null)
		message = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Insert title here</title>
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.title {
	font-size: 60px;
}

input {
	width: 230px
}

.login {
	width: 120px
}
</style>
</head>
<body>
	<div id="Layer1"
		style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%">
		<img src="./image/3.png" width="100%" height="100%">
		<p class="title" style="position: absolute; left: 15%; top: 5%;">智能仓库管理系统</p>
		<form action="login_servlet"
			style="position: absolute; left: 35%; top: 30%;">
			<table>
				<tr style="padding-bottom: 5px">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-user"></span>用户名：</td>
					<td><input class="btn btn-default btn-lg" type="text"
						name="username" placeholder="请输入用户名" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 3px"></tr>

				<tr style="padding-bottom: 5px;">
					<td style="font-size: 20px"><span
						class="glyphicon glyphicon-lock"></span>密码：</td>
					<td><input class="btn btn-default btn-lg" type="password"
						name="password" placeholder="请输入密码" style="text-align: left;" /></td>
				</tr>

				<tr style="height: 18px"></tr>

			</table>

			<div style="padding-bottom: 15px;">
				<input class="login btn btn-success" type="submit" value="登陆"
					style="margin-right: 30px;" /> <input class="login btn btn-info"
					type="reset" value="重置" style="float: right" />
			</div>
			<div>
				<a href="register.jsp"><input type="button"
					class="btn btn-warning" value="还没有用户名？点击注册" /></a>
			</div>
			<div>
				<a id="user-info" class="btn-link" href="#forget-psw" role="button"
					data-toggle="modal"
					style="float: right; width: 85px; font-size: 15px;">忘记密码? </a>
			</div>
		</form>
		<div id="fail" class="alert alert-warning"
			style="position: absolute; left: 65%; top: 35%; display: none;">用户名或密码错误!!!
		</div>
		<div class="modal fade" id="forget-psw" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">找回密码</h4>
					</div>
					<form action="forgetPsw_servlet">
						<div class="modal-body" style="font-size: 20px">
							<h5>请输入您的联系电话</h5>
						</div>
						<div class="modal-body" style="font-size: 20px">
							<span style="width: 100px; display: inline-block;">用户名:</span> <input
								type="text" name="check_psw1" class="btn btn-success"
								placeholder="请输入用户名" style="text-align: left;" />
						</div>
						<div class="modal-body" style="font-size: 20px">
							<span style="width: 100px; display: inline-block;">联系电话:</span> <input
								type="text" name="check_psw2" class="btn btn-success"
								placeholder="请输入联系电话" style="text-align: left;" />
						</div>
						<div class="modal-footer" style="font-size: 20px">
							<input type="submit" class="btn btn-primary" value="提交" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%
		if (message.equals("fail")) {
			session.removeAttribute("message");
	%>
	<script>
		document.getElementById("fail").style.display = "block";
		var t = setTimeout(function() {
			document.getElementById("fail").style.display = "none";
		}, 1500);
	</script>
	<%
		}
	%>
</body>
</html>