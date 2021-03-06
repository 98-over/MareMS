<%@page import="com.Model.supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.dbMangement"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	function btn_update(index) {
		var t = document.getElementById("table");
		var cknum = t.rows[index].cells[0].innerHTML;
		var ckname = t.rows[index].cells[1].innerHTML;
		var ckaddr = t.rows[index].cells[2].innerHTML;
		var cksize = t.rows[index].cells[3].innerHTML;
		document.getElementById("gy-num").value = cknum;
		document.getElementById('gy-name').value = ckname;
		document.getElementById('gy-addr').value = ckaddr;
		document.getElementById('gy-phone').value = cksize;

	}
</script>
</head>
<body>
	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px">
		<div class="row clearfix" style="margin: 0px">
			<div class="col-md-12 column" style="padding: 0px">
				<table id="table" class="table table-bordered table-hover">
					<thead>
						<tr style="visibility: collapse;">
							<th style="width: 15%;">编号</th>
							<th style="width: 25%;">商店名</th>
							<th style="width: 25%;">地址</th>
							<th style="width: 25%;">联系电话</th>
							<th style="width: 10%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<%
							String itemId = "";
							String userName = (String) session.getAttribute("username");
							String passWard = (String) session.getAttribute("password");
							dbMangement.setUsername(userName);
							dbMangement.setPassward(passWard);
							ArrayList<supplier> suppliers = dbMangement.getAllSupplier();
							int index = 1;
							for (supplier sup : suppliers) {
						%>
						<tr>
							<td style="width: 15%;"><%=sup.getSupnum()%></td>
							<td style="width: 25%;"><%=sup.getSupname()%></td>
							<td style="width: 25%;"><%=sup.getSupaddress()%></td>
							<td style="width: 25%;"><%=sup.getTelephone()%></td>
							<td>
								<div>
									<a onclick="btn_update(<%=index%>)" id="i-update"
										href="#item-update" role="button" data-toggle="modal"
										style="margin-right: 15px;">修改</a>
								</div>
							</td>
						</tr>
						<%
							index = index + 1;
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="item-update" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">供应商信息修改</h4>
					<p style="color: red"><sapn class="glyphicon glyphicon-warning-sign"></sapn>红色框中内容不可修改</p>
				</div>
				<form method="post" action="updateGoods_servlet?type=gy">
					<div class="modal-body" style="font-size: 20px">
						<span style="width: 100px; display: inline-block;">编号:</span> <input
							id="gy-num" type="text" readonly="readonly" name="gy_num"
							class="btn btn-danger disabled" value="编号"
							style="text-align: left;" />
					</div>
					<div id="info-admin" class="modal-body" style="font-size: 20px;">
						<span style="width: 100px; display: inline-block;">供应商名:</span> <input
							id="gy-name" type="text" name="gy_name" class="btn btn-info"
							value="供应商名" style="text-align: left;" />
					</div>
					<div id="info-user" class="modal-body" style="font-size: 20px;">
						<span style="width: 100px; display: inline-block;">地址:</span> <input
							id="gy-addr" type="text" name="gy_addr" class="btn btn-info"
							value="地址" style="text-align: left;" />
					</div>
					<div class="modal-body" style="font-size: 20px">
						<span style="width: 100px; display: inline-block;">联系电话:</span> <input
							id="gy-phone" type="text" name="gy_phone" class="btn btn-info"
							value="联系电话" style="text-align: left;" />
					</div>
					<div class="modal-footer" style="font-size: 20px">
						<input type="submit" class="btn btn-primary" value="保存" />
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</form>

			</div>

		</div>

	</div>
</body>
</html>