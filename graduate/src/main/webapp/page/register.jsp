<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="/graduate/">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">

<!--//end-animate-->
<!----webfonts--->
<!---//webfonts---> 
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->

</head> 
   
 <body class="sign-in-up">
    <section>
			<div id="page-wrapper" class="sign-in-wrapper">
				<form action="user/register" method="post">
					<div class="graphs">
						<div class="sign-up">
							<h3>用户注册</h3>
							<h5>用户信息</h5>
							<div class="sign-u">
								<div class="sign-up1">
									<h4>用户名</h4>
								</div>
								<div class="sign-up2">
									<input type="text" placeholder="请输入用户名" required="required" name="uname"/>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="sign-u">
								<div class="sign-up1">
									<h4>密码</h4>
								</div>
								<div class="sign-up2">
									<input type="password" placeholder="请输入密码" required="required" name="upwd"/>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="sign-u">
								<div class="sign-up1">
									<h4>联系方式</h4>
								</div>
								<div class="sign-up2">
									<input type="text" placeholder="请输入手机号" required="required" name="utel"/>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="sign-u">
								<div class="sign-up1">
									<h4>公司名称</h4>
								</div>
								<div class="sign-up2">
									<form>
										<input type="text" placeholder="请输入公司名称" required="required" name="companyName"/>
									</form>
								</div>
								<div class="clearfix"> </div>
							</div>
							
							<div class="sub_home">
								<div class="sub_home_left">
									<input type="submit" value="注册">
								</div>
								<div class="sub_home_right">
									<p>返回<a href="page/login.jsp">登录</a></p>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
				</form>
			</div>
		<!--footer section start-->
			<footer>
			   
			</footer>
        <!--footer section end-->
	</section>
	
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>