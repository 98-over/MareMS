<%@page import="com.Model.hwchuku"%>
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
				<table class="table table-bordered table-hover">
					<thead>
						<tr style="visibility: collapse;">
							<th style="width: 14%;">货物名</th>
							<th style="width: 19%;">商户名</th>
							<th style="width: 19%;">仓库名</th>
							<th style="width: 19%;">时间</th>
							<th style="width: 19%;">出库数量</th>
							<th style="width: 10%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<%
							String itemId="";
							String userName = (String) session.getAttribute("username");
							String passWard = (String) session.getAttribute("password");
							dbMangement.setUsername(userName);
							dbMangement.setPassward(passWard);
							ArrayList<hwchuku> hwchukus = dbMangement.getAllChuKuMssage();
							int index=1;
							for (hwchuku ck : hwchukus) {
						%>
						<tr>
							<td style="width: 14%;"><%=ck.getGoodsname()%>
							</td>
							<td style="width: 19%;"><%=ck.getSellername()%>
							</td>
							<td style="width: 19%;"><%=ck.getCkname()%>
							</td>
							<td style="width: 19%;"><%=ck.getChukutime()%>
							</td>
							<td style="width: 19%;"><%=ck.getChukucount()%>
							</td>
							<td>
								<div>
									 <a>仅查看 </a>
								</div>
							</td>
						</tr>
						<%
							index=index+1;
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>