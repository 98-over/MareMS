<%@page import="com.Model.supply_goods"%>
<%@page import="com.Model.pick_up_goods"%>
<%@page import="com.Model.hwruku"%>
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
</head>
<body>
	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px">
		<div class="row clearfix" style="margin: 0px">
			<div class="col-md-12 column" style="padding: 0px">
				<form action="provider_servlet">
					<table class="table table-bordered table-hover">
						<thead>
							<tr style="visibility: collapse;">
								<th style="width: 15%;"><span>仓库编号</span> <select>
										<option>ck-001</option>
										<option>ck-002</option>
										<option>ck-003</option>
										<option>ck-004</option>
										<option>ck-005</option>
								</select></th>
								<th style="width: 17%;">货物编号</th>
								<th style="width: 17%;">类别</th>
								<th style="width: 17%;">物品名</th>
								<th style="width: 17%;">库存数量</th>
								<th style="width: 17%;">提货数量</th>
							</tr>
						</thead>
						<tbody>
							<%
								String userName = (String) session.getAttribute("username");
								String passWord = (String) session.getAttribute("password");
								String ck_num = (String) request.getQueryString();
								dbMangement.setUsername(userName);
								dbMangement.setPassward(passWord);
								ArrayList<supply_goods> supplys = dbMangement.getSupplyInformation(userName,ck_num);
								for (supply_goods supply : supplys) {
							%>
							<tr>
								<td style="width: 15%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="cknum" class="btn btn-default" value=<%=supply.getCkum()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="hwnum" class="btn btn-default" value=<%=supply.getGoodsNum()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="hwname" class="btn btn-default" value=<%=supply.getGoodsname()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="hwtype" class="btn btn-default" value=<%=supply.getStyle()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" class="btn btn-default" value=<%=supply.getSupplycount()%>>
								</td>
								<td><input name="rkacc" class="btn btn-link" placeholder="输入供货数量"
									style="text-align: left;"/>
								</td>
							</tr>
							<%
								}
							%>
							<tr align="center">
								<td colspan="6">
									<input class="btn btn-info" type="submit" value="提交"/>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>