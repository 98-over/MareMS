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
				<form action="pickGoods_servlet">
					<table class="table table-bordered table-hover">
						<thead>
							<tr style="visibility: collapse;">
								<th>编号</th>
								<th>产品</th>
								<th>交付时间</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<%
								String userName = (String) session.getAttribute("username");
								String passWard = (String) session.getAttribute("password");
								String cknum = (String) request.getQueryString();
								dbMangement.setUsername(userName);
								dbMangement.setPassward(passWard);
								ArrayList<pick_up_goods> pick = dbMangement.searchStore(cknum);
								for (pick_up_goods pk : pick) {
							%>
							<tr>
								<td style="display: none;"><input name="hwnum"
									value=<%=pk.getHwnum()%>></td>
								<td style="display: none;"><input name="gynum"
									value=<%=pk.getGynum()%>></td>
								<td style="width: 15%; vertical-align: middle;">
									<input readonly="readonly" name="cknum" class="btn btn-default" value=<%=pk.getCknum()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="hwname" class="btn btn-default" value=<%=pk.getGoodsname()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="hwtype" class="btn btn-default " value=<%=pk.getGoodsstyle()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
									<input readonly="readonly" type="text" name="gyname" class="btn btn-default" value=<%=pk.getSupname()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;">
								 	<input readonly="readonly" type="text" class="btn btn-default" value=<%=pk.getCkcount()%>>
								</td>
								<td style="width: 17%; vertical-align: middle;"><input
									name="ckacc" class="btn btn-link" placeholder="输入提货数量"
									style="text-align: left;" /></td>
							</tr>
							<%
								}
							%>
							<tr align="center">
								<td colspan="6"><input class="btn btn-info" type="submit"
									value="提交" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>