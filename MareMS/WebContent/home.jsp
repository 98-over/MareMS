<%@page import="com.db.dbMangement"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("hw-cknum", "ck-001");
	String identify = (String) session.getAttribute("identify");
	String username = (String) session.getAttribute("username");
	String sname = (String) session.getAttribute("supplyName");
	String addr = (String) session.getAttribute("address");
	String phone = (String) session.getAttribute("phone");
	String name = "";
	if (identify == null) {
		identify = "";
	}
	if (sname == null) {
		sname = "";
	}
	if (addr == null) {
		addr = "";
	}
	if (phone == null) {
		phone = "";
	}
	if (identify.equals("admin"))
		name = "Admin";
	else if (identify.equals("saler"))
		name = "销售商";
	else if (identify.equals("provider"))
		name = "供应商";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<!--定时刷新 -->
<!-- <meta http-equiv="refresh" content="60">-->


<title>Insert title here</title>
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	function checkId(id) {
		if (confirm("点击确定重新登陆至" + id + "账户")) {
			window.open("about:blank", "_self");
			window.location.href = "loginout_servlet";
		}
	}

	function logout() {
		if (confirm("你确定要退出登陆吗？")) {
			window.open("about:blank", "_self");
			window.location.href = "loginout_servlet";
		}
	}
	function checkFrame(id) {
		var oLis = document.getElementsByClassName("op");
		var i, j;
		var length = oLis.length;
		for (j = 0; j < length; j++) {
			oLis[j].className = "btn btn-defalt op";
		}
		document.getElementById(id).className = "btn btn-defalt op active"
		var mainContent = document.getElementById('mainContent');
		document.getElementById('frame').style.position = "absolute";
		document.getElementById('frame').style.left = "0px";
		document.getElementById('frame').style.top = "125px";
		if (id == "ck") {
			document.getElementById("head-ck").style.visibility = "visible";
			document.getElementById("head-xs-gy").style.visibility = "collapse";
			document.getElementById("head-hw").style.visibility = "collapse";
			document.getElementById("head-rc-cc").style.visibility = "collapse";
			var mainContent = document.getElementById('mainContent');
			mainContent.src = "getMare.jsp";//获取仓库信息
		} else if (id == "xs") {
			document.getElementById("head-ck").style.visibility = "collapse";
			document.getElementById("head-xs-gy").style.visibility = "visible";
			document.getElementById("head-hw").style.visibility = "collapse";
			document.getElementById("head-rc-cc").style.visibility = "collapse";
			mainContent.src = "getSaler.jsp";//获取销售商信息
		} else if (id == "gy") {
			document.getElementById("head-ck").style.visibility = "collapse";
			document.getElementById("head-xs-gy").style.visibility = "visible";
			document.getElementById("head-hw").style.visibility = "collapse";
			document.getElementById("head-rc-cc").style.visibility = "collapse";
			mainContent.src = "getProvider.jsp";//获取供应商信息
		} else if (id == "hw") {
			document.getElementById("head-ck").style.visibility = "collapse";
			document.getElementById("head-xs-gy").style.visibility = "collapse";
			document.getElementById("head-hw").style.visibility = "visible";
			document.getElementById("head-rc-cc").style.visibility = "collapse";
			mainContent.src = "getHwStoce.jsp?ck-001";//获取对应仓库的货物
		} else if (id == "rc") {
			document.getElementById("head-ck").style.visibility = "collapse";
			document.getElementById("head-xs-gy").style.visibility = "collapse";
			document.getElementById("head-hw").style.visibility = "collapse";
			document.getElementById("head-rc-cc").style.visibility = "visible";
			mainContent.src = "getRRecords.jsp";//出库
		} else if (id == "cc") {
			document.getElementById("head-ck").style.visibility = "collapse";
			document.getElementById("head-xs-gy").style.visibility = "collapse";
			document.getElementById("head-hw").style.visibility = "collapse";
			document.getElementById("head-rc-cc").style.visibility = "visible";
			mainContent.src = "getCRecords.jsp";//入库
		}
	}

	function showHead(id) {
		var oLis = document.getElementsByClassName("hop");
		var i, j;
		var length = oLis.length;
		for (j = 0; j < length; j++) {
			oLis[j].className = "btn hop";
		}
		document.getElementById(id).className = "btn active hop"
		var mainContent = document.getElementById('mainContent');

		if (id == "out") {
			var obj=document.getElementById("xs_cknum");
			var index = obj.selectedIndex; 
			var value = obj.options[index].value; // 选中值
			document.getElementById('frame').style.position = "absolute";
			document.getElementById('frame').style.left = "0px";
			document.getElementById('frame').style.top = "90px";
			mainContent.src = "getGoods.jsp?"+value; //销售商查看的对应仓库的货物
			document.getElementById("head-user1").style.visibility = "visible";
		}
		if (id == "in") {
			var obj=document.getElementById("gy_cknum");
			var index = obj.selectedIndex; 
			var value = obj.options[index].value; // 选中值
			document.getElementById('frame').style.position = "absolute";
			document.getElementById('frame').style.left = "0px";
			document.getElementById('frame').style.top = "90px";
			mainContent.src = "setGoods.jsp?"+value; //供应商所提供的货物信息
			document.getElementById("head-user").style.visibility = "visible";
		}
		if (id == "manager") {
			document.getElementById('frame').style.position = "absolute";
			document.getElementById('frame').style.left = "0px";
			document.getElementById('frame').style.top = "125px";
			document.getElementById("head-ck").style.visibility = "visible";
			document.getElementById("head-manager").style.display = "block";
			mainContent.src = "getMare.jsp"; //获取仓库信息
		}
	}

	function getHome() {
		var oLis = document.getElementsByClassName("hop");
		var i, j;
		var length = oLis.length;
		for (j = 0; j < length; j++) {
			oLis[j].className = "btn hop";
		}
		document.getElementById("home").className = "btn active hop"
		document.getElementById("head-manager").style.display = "none";
		document.getElementById("head-user").style.visibility = "collapse";
		document.getElementById("head-user1").style.visibility = "collapse";
		document.getElementById("head-ck").style.visibility = "collapse";
		document.getElementById("head-xs-gy").style.visibility = "collapse";
		document.getElementById("head-hw").style.visibility = "collapse";
		document.getElementById("head-rc-cc").style.visibility = "collapse";
		var mainContent = document.getElementById('mainContent');
		mainContent.src = "main.jsp"; //主页面
		document.getElementById('frame').style.position = "absolute";
		document.getElementById('frame').style.left = "0px";
		document.getElementById('frame').style.top = "55px";
	}

	function getCknum(value) {
		var mainContent = document.getElementById('mainContent');
		mainContent.src = "getHwStoce.jsp?" + value;
	}
	function getCknumOfGoods(value){
		var mainContent = document.getElementById('mainContent');
		mainContent.src = "setGoods.jsp?" + value;
	}
	function getCknumOfGoods1(value){
		var mainContent = document.getElementById('mainContent');
		mainContent.src = "getGoods.jsp?" + value;
	}
	
</script>

</head>
<body>
	<div class="container-fluid" style="padding: 0px">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-fixed-top"
					role="navigation"
					style="background-image: url('./image/4.png'); background-size: cover;">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a id="home" class="navbar-brand btn active hop"
							onclick="getHome()" style="font-size: 25px">首页</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a onclick="showHead('out')" class="btn hop"
								style="font-size: 25px; display: none;" id="out">提货</a></li>
							<li><a onclick="showHead('in')" class="btn hop"
								style="font-size: 25px; display: none;" id="in">供货</a></li>
							<li><a onclick="showHead('manager')" class="btn hop"
								style="font-size: 25px; display: none;" id="manager">管理</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								id="identify" data-toggle="dropdown" style="font-size: 25px">
									<%=name%> <strong class="caret"></strong>
							</a>
								<ul class="dropdown-menu">
									<li><a onclick='checkId("Admin")' style="font-size: 25px"
										id="admin">Admin</a></li>
									<li class="divider"></li>
									<li><a onclick='checkId("销售商")' style="font-size: 25px"
										id="sales">销售商</a></li>
									<li class="divider"></li>
									<li><a onclick='checkId("供应商")' style="font-size: 25px"
										id="provider">供应商</a></li>
								</ul></li>
							<li id="insert" style="visibility: collapse;"><a
								id="hw_user" href="#insert_user" role="button"
								data-toggle="modal" style="font-size: 20px">插入新货物</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								style="font-size: 25px" data-toggle="dropdown"><span
									class="glyphicon glyphicon-user"></span> <%=sname%> <strong
									class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a id="user-info" href="#check-info" role="button"
										data-toggle="modal" style="font-size: 20px">信息维护</a></li>
									<li><a id="check_psw" href="#check-psw" role="button"
										data-toggle="modal" style="font-size: 20px">修改密码</a></li>

									<li class="divider"></li>

									<li><a onclick='logout()' style="font-size: 20px"
										id="loginout">退出登陆</a></li>
								</ul></li>
						</ul>
					</div>
					<div style="background-color: white; display: none"
						id="head-manager">
						<a onclick="checkFrame('ck')" class="btn btn-defalt active op"
							id="ck">仓库管理</a> <a onclick="checkFrame('xs')"
							class="btn btn-defalt op" id="xs">销售商管理</a> <a
							onclick="checkFrame('gy')" class="btn btn-defalt op" id="gy">供应商管理</a>
						<a onclick="checkFrame('hw')" class="btn btn-defalt op" id="hw">货物管理</a>
						<a onclick="checkFrame('rc')" class="btn btn-defalt op" id="rc">入库记录</a>
						<a onclick="checkFrame('cc')" class="btn btn-defalt op" id="cc">出库记录</a>
					</div>
					<table class="table table-bordered table-hover" id="head-user"
						style="position: absolute; left: 0px; top: px; visibility: collapse;">
						<thead>
							<tr class="warning">
								<th style="width: 15%;"><span>仓库编号</span>
									<select id="gy_cknum" onchange="getCknumOfGoods(this[selectedIndex].value)">
										<option>ck-001</option>
										<option>ck-002</option>
										<option>ck-003</option>
										<option>ck-004</option>
										<option>ck-005</option>
									</select>
								</th>
								<th style="width: 17%;">货物编号</th>
								<th style="width: 17%;">物品名</th>
								<th style="width: 17%;">类别</th>
								<th style="width: 17%;">库存数量</th>
								<th style="width: 17%;">供货数量</th>
							</tr>
						</thead>
					</table>
					<table class="table table-bordered table-hover" id="head-user1"
						style="position: absolute; left: 0px; top: px; visibility: collapse;">
						<thead>
							<tr class="warning">
								<th style="width: 15%;"><span>仓库编号</span>
									<select id="xs_cknum" onchange="getCknumOfGoods1(this[selectedIndex].value)">
										<option>ck-001</option>
										<option>ck-002</option>
										<option>ck-003</option>
										<option>ck-004</option>
										<option>ck-005</option>
									</select>
								</th>
								<th style="width: 17%;">货物名</th>
								<th style="width: 17%;">类别</th>
								<th style="width: 17%;">供应商名</th>
								<th style="width: 17%;">库存数量</th>
								<th style="width: 17%;">提货数量</th>
							</tr>
						</thead>
					</table>
					<table class="table table-bordered table-hover" id="head-ck"
						style="position: absolute; left: 0px; top: px; visibility: collapse;">
						<thead>
							<tr class="warning">
								<th style="width: 15%;">仓库编号</th>
								<th style="width: 25%;">仓库名</th>
								<th style="width: 25%;">地址</th>
								<th style="width: 25%;">容量</th>
								<th style="width: 10%;">操作</th>
							</tr>
						</thead>
					</table>
					<table class="table table-bordered table-hover" id="head-xs-gy"
						style="position: absolute; left: 0px; top: px; visibility: collapse;">
						<thead>
							<tr class="warning">
								<th style="width: 15%;">编号</th>
								<th style="width: 25%;">商店名</th>
								<th style="width: 25%;">地址</th>
								<th style="width: 25%;">联系电话</th>
								<th style="width: 10%;">操作</th>
							</tr>
						</thead>
					</table>
					<table class="table table-bordered table-hover" id="head-hw"
						style="position: absolute; left: 0px; top: px; visibility: collapse;">
						<thead>
							<tr class="warning">
								<th style="width: 15%;"><span>仓库编号</span> <select
									onchange="getCknum(this[selectedIndex].value)" id="hw-ck">
										<option value="ck-001">ck-001</option>
										<option value="ck-002">ck-002</option>
										<option value="ck-003">ck-003</option>
										<option value="ck-004">ck-004</option>
										<option value="ck-005">ck-005</option>
								</select></th>

								<th style="width: 15%;">货物编号</th>
								<th style="width: 15%;">货物类型</th>
								<th style="width: 15%;">货物名</th>
								<th style="width: 15%;">供应商名</th>
								<th style="width: 15%;">库存数量</th>
								<th style="width: 10%;">操作</th>
							</tr>
						</thead>
					</table>
					<table class="table table-bordered table-hover" id="head-rc-cc"
						style="position: absolute; left: 0px; top: px; visibility: collapse;">
						<thead>
							<tr class="warning">
								<th style="width: 14%;">货物名</th>
								<th style="width: 19%;">商户名</th>
								<th style="width: 19%;">仓库名</th>
								<th style="width: 19%;">时间</th>
								<th style="width: 19%;">出库数量</th>
								<th style="width: 10%;">操作</th>
							</tr>
						</thead>
					</table>
				</nav>
				<div class="modal fade" id="insert_user" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">插入新货物</h4>
							</div>
							<form action="supplyGoods_servlet">
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">仓库编号:</span>
									<input type="text" name="insert_cknum" class="btn btn-info"
										placeholder="请输入仓库编号" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">货物类型:</span>
									<input type="text" name="insert_hwtype" class="btn btn-info"
										placeholder="请输入货物类型" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">货物名:</span>
									<input type="text" name="insert_hwname" class="btn btn-info"
										placeholder="请输入货物名" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">货物数量:</span>
									<input type="text" name="insert_hwaccount" class="btn btn-info"
										placeholder="请输入数量" style="text-align: left;" />
								</div>
								<div class="modal-footer" style="font-size: 20px">
									<input type="submit" class="btn btn-primary" value="提交" />
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
								</div>
							</form>

						</div>

					</div>

				</div>
				<div class="modal fade" id="check-psw" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">修改密码</h4>
							</div>
							<form action="checkPsw_servlet">
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">原密码:</span>
									<input type="text" name="check_o_psw" class="btn btn-info"
										placeholder="请输入新密码" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">新密码:</span>
									<input type="text" name="check_psw1" class="btn btn-info"
										placeholder="请输入新密码" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">确认密码:</span>
									<input type="text" name="check_psw2" class="btn btn-info"
										placeholder="请确认密码" style="text-align: left;" />
								</div>
								<div class="modal-footer" style="font-size: 20px">
									<input type="submit" class="btn btn-primary" value="保存" />
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								</div>
							</form>

						</div>

					</div>

				</div>
				<div class="modal fade" id="check-info" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="margin-top: 100px;">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">信息维护</h4>
							</div>
							<form action="updateUser_servlet">
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">用户名:</span>
									<input type="text" value=<%=username%> name="user-name"
										class="btn btn-info" value="用户名" style="text-align: left;" />
								</div>
								<div id="info-admin" class="modal-body"
									style="font-size: 20px; display: none;">
									<span style="width: 100px; display: inline-block;">姓名:</span> <input
										type="text" value=<%=sname%> name="name1" class="btn btn-info"
										style="text-align: left;" />
								</div>
								<div id="info-user" class="modal-body"
									style="font-size: 20px; display: none;">
									<span style="width: 100px; display: inline-block;">商店名:</span>
									<input type="text" value=<%=sname%> name="name"
										class="btn btn-info" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">地址:</span> <input
										type="text" value=<%=addr%> name="address"
										class="btn btn-info" style="text-align: left;" />
								</div>
								<div class="modal-body" style="font-size: 20px">
									<span style="width: 100px; display: inline-block;">联系电话:</span>
									<input type="text" name="phone" class="btn btn-info"
										value=<%=phone%> style="text-align: left;" />
								</div>
								<div class="modal-footer" style="font-size: 20px">
									<input type="submit" class="btn btn-primary" value="保存" />
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								</div>
							</form>

						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="frame"
		style="position: absolute; left: 0px; top: 55px; width: 100%">
		<iframe id="mainContent" width="100%" height="1000px" frameborder="0"></iframe>
	</div>

	<%
		if (identify.equals("admin")) {
	%>
	<script>
		document.getElementById("info-admin").style.display = "block";
		document.getElementById("manager").style.display = "block";
	</script>
	<%
		} else if (identify.equals("saler")) {
	%>
	<script>
		document.getElementById("info-user").style.display = "block";
		document.getElementById("out").style.display = "block";
	</script>
	<%
		} else if (identify.equals("provider")) {
	%>
	<script>
		document.getElementById("insert").style.visibility = "visible";
		document.getElementById("info-user").style.display = "block";
		document.getElementById("in").style.display = "block";
	</script>
	<%
		}
	%>
	<script>
		var mainContent = document.getElementById('mainContent');
		mainContent.src = "main.jsp";
	</script>
</body>
</html>