<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>人事管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/demo.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/style.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/animate-custom.css' />" />
</head>
<body>
	<script language="javaScript">
		if (window != top) {
			top.location.href = location.href;
		}
	</script>
	<div class="container">
		<!-- Codrops top bar -->
		<div class="codrops-top">
			<span class="right"> </span>
			<div class="clr"></div>
		</div>
		<!--/ Codrops top bar -->
		<header>
			<h1>欢迎来到人事管理系统</h1>
		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<%
							String employeeNum = "";
							String employeePwd = "";

							Cookie[] cookies = request.getCookies();
							if (cookies != null) {
								for (Cookie cookie : cookies) {
									if (cookie.getName().equals("employeeNum"))
										employeeNum = cookie.getValue();
									if (cookie.getName().equals("employeePwd"))
										employeePwd = cookie.getValue();
								}
							}
						%>
						<form action="/CPIMS/employee/login" method="post">
							<h1>Log in</h1>
							<p>
								<label for="employeeNum" class="employeeNum" data-icon="u">员工编号</label>
								<input id="employeeNum" name="employeeNum" required="required"
									type="text" value="<%=employeeNum%>" placeholder="eg.010234" />
							</p>
							<p>
								<label for="employeePwd" class="employeePwd" data-icon="p">密码</label>
								<input id="employeePwd" name="employeePwd" required="required"
									type="password" value="<%=employeePwd%>"
									placeholder="eg. X8df!90EO" />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">Keep
									me logged in</label>
							</p>
							<p class="login button">
								<input type="submit" value="Login" />
							</p>
							<p class="change_link">
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>