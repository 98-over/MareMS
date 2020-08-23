<%@page import="com.Model.hwstock"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.dbMangement"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="com.MareMS.servlet.*"%>
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
		var ck_num = t.rows[index].cells[0].innerHTML;
		var hw_num = t.rows[index].cells[1].innerHTML;
		var hw_type = t.rows[index].cells[2].innerHTML;
		var hw_name = t.rows[index].cells[3].innerHTML;
		var gy_name = t.rows[index].cells[4].innerHTML;
		var hw_cap = t.rows[index].cells[5].innerHTML;
		document.getElementById("ck_num").value = ck_num;
		document.getElementById('hw_num').value = hw_num;
		document.getElementById('hw_type').value = hw_type;
		document.getElementById('hw_name').value = hw_name;
		document.getElementById('gy_name').value = gy_name;
		document.getElementById('hw_cap').value = hw_cap;

	}
	function btn_delete(index) {
		var t = document.getElementById("table");
		var ck_num = t.rows[index].cells[0].innerHTML;
		var hw_num = t.rows[index].cells[1].innerHTML;
		document.getElementById("dck_num").value = ck_num;
		document.getElementById('dhw_num').value = hw_num;
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
							<th style="width: 15%;">仓库编号</th>
							<th style="width: 15%;">货物编号</th>
							<th style="width: 15%;">货物类型</th>
							<th style="width: 15%;">货物名</th>
							<th style="width: 15%;">供应商名</th>
							<th style="width: 15%;">库存数量</th>
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
							String ckNum = (String)request.getQueryString();
							ArrayList<hwstock> hwstocks = dbMangement.getAllHwStock(ckNum);
							int index = 1;
							for (hwstock hw : hwstocks) {
						%>
						<tr>
							<td style="width: 15%;"><%=hw.getCknum()%></td>
							<td style="width: 15%;"><%=hw.getGoodsnum()%></td>
							<td style="width: 15%;"><%=hw.getGoodsstyle()%></td>
							<td style="width: 15%;"><%=hw.getGoodsname()%></td>
							<td style="width: 15%;"><%=hw.getSupname()%></td>
							<td style="width: 15%;"><%=hw.getCkcount()%></td>
							<!-- out.print("<td><div>"
											+ "<a onclick=\"btn_update("+index+")\" id=\"i-update\" href=\"#item-update\" role=\"button\""
											+ "data-toggle=\"modal\" style=\"margin-right: 15px;\">修改</a>"
											+ "<a id=\"i-delete\" href=\"#item-delete\" role=\"button\"" 
											+ "data-toggle=\"modal\">刪除 </a></div></td>"); -->
							<td>
								<div>
									<a onclick="btn_update(<%=index%>)" id="i-update"
										href="#item-update" role="button" data-toggle="modal"
										style="margin-right: 15px;">修改</a> <a onclick="btn_delete(<%=index%>)" id="i-delete"
										href="#item-delete" role="button" data-toggle="modal">刪除 </a>
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
					<h4 class="modal-title" id="myModalLabel">货物信息修改</h4>
					<p style="color: red"><sapn class="glyphicon glyphicon-warning-sign"></sapn>红色框中内容不可修改</p>
				</div>
				<form method="post" action="updateGoods_servlet?type=hw">
					<div class="modal-body" style="font-size: 20px">
						<span style="width: 100px; display: inline-block;">仓库编号:</span> <input
							id="ck_num" type="text" readonly="readonly" name="ck_num"
							class="btn btn-danger disabled" value="仓库编号"
							style="text-align: left;" />
					</div>
					<div id="info-admin" class="modal-body" style="font-size: 20px;">
						<span style="width: 100px; display: inline-block;">货物编号:</span> <input
							id="hw_num" type="text" readonly="readonly" name="hw_num"
							class="btn btn-danger disabled" value="货物编号"
							style="text-align: left;" />
					</div>
					<div id="info-user" class="modal-body" style="font-size: 20px;">
						<span style="width: 100px; display: inline-block;">货物类型:</span> <input
							id="hw_type" type="text" name="hw_type" class="btn btn-info"
							value="货物类型" style="text-align: left;" />
					</div>
					<div class="modal-body" style="font-size: 20px">
						<span style="width: 100px; display: inline-block;">货物名:</span> <input
							id="hw_name" type="text" name="hw_name" class="btn btn-info"
							value="货物名" style="text-align: left;" />
					</div>
					<div class="modal-body" style="font-size: 20px">
						<span style="width: 100px; display: inline-block;">供应商名:</span> <input
							id="gy_name" type="text" readonly="readonly" name="gy_name"
							class="btn btn-danger disabled" value="供应商名"
							style="text-align: left;" />
					</div>
					<div class="modal-body" style="font-size: 20px">
						<span style="width: 100px; display: inline-block;">库存数量:</span> <input
							id="hw_cap" type="text" readonly="readonly" name="hw_cap"
							class="btn btn-danger disabled" value="库存数量"
							style="text-align: left;" />
					</div>
					<div class="modal-footer" style="font-size: 20px">
						<input type="submit" class="btn btn-primary"
							value="保存" />
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</form>

			</div>

		</div>

	</div>
	<div class="modal fade" id="item-delete" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">确认删除</h4>
				</div>
				<form method="post" action="delete_servlet?type=hw">
					<div class="modal-footer" style="font-size: 20px">
						<input type="hidden" name="hw_num" id="dhw_num"/>
						<input type="hidden" name="ck_num" id="dck_num"/>
						<input type="submit" class="btn btn-primary" value="删除" />
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</form>

			</div>

		</div>

	</div>
</body>
</html>