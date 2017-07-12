<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>衡阳智慧物流系统</title>
<base href="/graduate/">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 

<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />

<!-- chart -->
<script src="js/Chart.js"></script>

<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">

 <!-- Meters graphs -->
<link href="css/bootstrap-table.css" rel="stylesheet" />
</head> 
   
 <body class="sticky-header left-side-collapsed">
    <section>
    <!-- left side start-->
		<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<!-- <h1><a href="index.html">Easy <span>Admin</span></a></h1> -->
			</div>
			<div class="logo-icon text-center">
				<!-- <a href="index.html"><i class="lnr lnr-home"></i> </a> -->
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
						<li><a href="page/user.jsp"><i class="fa fa-user"></i><span>用户管理</span></a></li>
						<li><a href="page/card.jsp"><i class="fa fa-credit-card"></i><span>一卡通管理</span></a></li>
						<li class="menu-list act"><a href="#"><i class="fa fa-truck"></i><span>车辆管理</span></a>  
							<ul class="sub-menu-list">
								<li><a href="page/cartrade.jsp">车辆调度</a> </li>
								<li><a href="page/carlog.jsp">车辆登记</a> </li>
							</ul>
						</li>
						<li><a href="page/storage.jsp"><i class="fa fa-suitcase"></i><span>仓储管理</span></a></li>
						<!-- <li><a href="forms.html"><i class="lnr lnr-spell-check"></i> <span>Forms</span></a></li>
						<li><a href="tables.html"><i class="lnr lnr-menu"></i> <span>Tables</span></a></li>              
						<li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>MailBox</span></a>
							<ul class="sub-menu-list">
								<li><a href="inbox.html">Inbox</a> </li>
								<li><a href="compose-mail.html">Compose Mail</a></li>
							</ul>
						</li>      
						<li class="menu-list"><a href="#"><i class="lnr lnr-indent-increase"></i> <span>Menu Levels</span></a>  
							<ul class="sub-menu-list">
								<li><a href="charts.html">Basic Charts</a> </li>
							</ul>
						</li>
						<li><a href="codes.html"><i class="lnr lnr-pencil"></i> <span>Typography</span></a></li>
						<li><a href="media.html"><i class="lnr lnr-select"></i> <span>Media Css</span></a></li>
						<li class="menu-list"><a href="#"><i class="lnr lnr-book"></i>  <span>Pages</span></a> 
							<ul class="sub-menu-list">
								<li><a href="sign-in.html">Sign In</a> </li>
								<li><a href="sign-up.html">Sign Up</a></li>
								<li><a href="blank_page.html">Blank Page</a></li>
							</ul>
						</li> -->
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
		<!-- left side end-->
    
		<!-- main content start-->
		<div class="main-content" style="position: absolute; z-index: 1; width: 95%">
			<!-- header-starts -->
			<div class="header-section">
			<!--notification menu start -->
			<div class="menu-right">
				<div class="user-panel-top">  	
					<div class="profile_details_left">
						<ul class="nofitications-dropdown">
							<li class="dropdown">
							</li>
							<li class="login_box" id="loginContainer">
							</li>
							<li class="dropdown">
							</li>	
							<li class="dropdown">
							</li>
							<div class="clearfix"></div>		   							   		
						</ul>
					</div>
					<div class="profile_details" style="height:50px;">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										<span style="background:url(images/1.jpg) no-repeat center"> </span> 
										 <div class="user-name">
											<p>
											<c:if test="${user.uname != null }">
												${user.uname }
											</c:if>
											<span>
											<c:if test="${user.utype != null }">
												${user.utype }
											</c:if></span></p>
										 </div>
										<!--  <i class="lnr lnr-chevron-down"></i>
										<i class="lnr lnr-chevron-up"></i> -->
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="login.jsp"><i class="fa fa-sign-out"></i> 退出登录</a> </li>
								</ul>
							</li>
							<div class="clearfix"> </div>
						</ul>
					</div>
				</div>
			</div>
			</div>
			
			<div class="panel-body" style="padding-bottom:0px;">
			<div class="panel panel-default">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body">
			<form id="formSearch" class="form-horizontal">
			<div class="form-group" style="margin-top:15px">
			<label class="control-label col-sm-1" for="txt_search_carNum">车牌号</label>
			<div class="col-sm-3">
			<input type="text" class="form-control" id="txt_search_carNum" name="carNum">
			</div>
			<label class="control-label col-sm-1" for="txt_search_carType">车辆类型</label>
			<div class="col-sm-3">
			<input type="text" class="form-control" id="txt_search_carType" name="carType">
			</div>
			<label class="control-label col-sm-1" for="txt_search_companyName">企业名称</label>
			<div class="col-sm-3">
			<input type="text" class="form-control" id="txt_search_companyName" name="companyName">
			</div>
			<div class="col-sm-4" style="text-align:left; float:right; margin-top: 10px;">
			<button type="button" style="float:right;" id="btn_query" class="btn btn-primary">查询</button>
			</div>
			</div>
			</form>
			</div>
			</div>

			<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			</div>
			
			<div class="panel-heading">已登记的车辆</div>
			<table id="tb_departments" style="width=900px;"></table>
			</div>
			
		</div>
		
		<div id="back" style="display:none; background-color: gray; position: absolute; z-index: 5; width: 100%; height: 151%; opacity: 0.5;"></div>
        
        <div id="add" style="display: none; margin: 0 auto;width:300px; height:250px; position: absolute;z-index: 10; left: 40%;top:40%; border: 1px solid gray;background-color: white;">
				
				<div  style="margin-top: 20px;" >
				<label style="margin-left: 20px;">车牌号:</label>
				<input type="text" id="add-carNum" name="carNum">
				</div>
				
				<div style="margin-top: 20px;">
				<label style="margin-left: 20px;">车辆类型:</label>
				<select id="add-carType">
					<option>厢式货车</option>
					<option>高栏货车</option>
				</select>
				</div>
				
				<div style="margin-top: 20px;" >
				<label style="margin-left: 20px;">企业名称:</label>
				<input type="text" id="add-companyName"  name="companyName">
				</div>
				
				<div style="margin-top: 10px;">
					<button type="button" class="btn btn-default" style="margin-left: 90px;" onclick="add()">确定</button>
					<button type="button" class="btn btn-default" style="margin-left: 20px;" onclick="cancel()">取消</button>
				</div>
		</div>
		
		<div id="edit" style="display: none; margin: 0 auto;width:300px; height:250px; position: absolute;z-index: 10; left: 40%;top:40%; border: 1px solid gray;background-color: white;">
				<div  style="margin-top: 20px;" >
				<label style="margin-left: 20px;">车牌号:</label>
				<input type="text" id="edit-carNum" name="carNum">
				</div>
				
				<div style="margin-top: 20px;">
				<label style="margin-left: 20px;">车辆类型:</label>
				<select id="edit-carType">
					<option>厢式货车</option>
					<option>高栏货车</option>
				</select>
				</div>
				
				<div style="margin-top: 20px;" >
				<label style="margin-left: 20px;">企业名称:</label>
				<input type="text" id="edit-companyName"  name="companyName">
				</div>
				
				<div style="margin-top: 10px;">
					<button type="button" class="btn btn-default" style="margin-left: 90px;" onclick="edit()">修改</button>
					<button type="button" class="btn btn-default" style="margin-left: 20px;" onclick="cancel()">取消</button>
				</div>
		</div>
        <!--footer section start-->
			<footer>
			  
			</footer>
        <!--footer section end-->

      <!-- main content end-->
   </section>
   
<script src="js/jquery-1.10.2.min.js"></script>  
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table-mas.js"></script>
<script src="js/bootstrap-table-zh-CN.js"></script>
<script src="js/carlog.js"></script>

</body>
</html>