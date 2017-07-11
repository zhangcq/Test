<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
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

 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->

</head> 
   
 <body class="sign-in-up">
    <section>
			<div id="page-wrapper" class="sign-in-wrapper">
				<div class="graphs">
					<div class="sign-in-form">
						<div class="sign-in-form-top">
							<p><span>欢迎使用</span> <a href="index.html">衡阳智慧物流系统</a></p>
						</div>
						<div class="signin">
							<span style="color: red;">
							<c:if test="${loginError!= null }">
								${loginError}
							</c:if>
							</span>
							<form action="user/login" method="post">
							<div class="log-input">
								<div class="log-input-left">
								   <input type="text" class="user" placeholder="Yourname" name="uname"/>
								</div>
							</div>
							<div class="log-input">
								<div class="log-input-left">
								   <input type="password" class="lock" placeholder="password" name="upwd"/>
								</div>
							</div>
							<input type="submit" value="登录">
						</form>	 
						</div>
						<div class="new_people">
							<h4>新用户</h4>
							<p>欢迎注册</p>
							<a href="page/register.jsp">立即注册</a>
						</div>
					</div>
				</div>
			</div>
		
	</section>
	
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
   
<script type="text/javascript">
$(function(){
	test()
});
function test(){
	$.get("http://116.62.112.18:4190/dlc_lr/clientInfos",{"iphone":"13807498888","brandName":"奔驰","signature":"gILJS7y3GcatP+bx3sgZY9qgjpzLsT4eUBgUT4yUdVs="},function(data){
		console.log(data);
	},"json");
}
	
</script>
</body>
</html>