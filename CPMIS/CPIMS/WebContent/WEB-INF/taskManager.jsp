<%@page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人事管理系统</title>
<link href="/CPIMS/static/css/global.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/CPIMS/static/js/common/jquery.js"></script>
<script type="text/javascript" src="/CPIMS/static/js/common/common.js"></script>
</head>

<body>
	<div id="FrameTop" class="frame-top">
		<div class="topdata">
			<div id="SysIcon"></div>
			<h2 class="systitle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国民航飞行学院</h2>
			<div class="siteinfo">
				<p>欢迎您，${currentEmployee.employeeName}</p>
				<div class="toprightmenu">
					<a>公开信息</a><span class="split">|</span> <a>留言板</a><span
						class="split">|</span> <a>退出系统</a>
				</div>
			</div>
		</div>
	</div>

	<!-- 左侧菜单-->
	<div class="frame-left">
		<ul class="leftmenu">
			<li><a class="dropmenu">任务系统</a>
				<ul class="submenu">
					<li><a target="mainFrame" href="/CPIMS/task/toSave">任务发布</a></li>
					<li><a target="mainFrame" href="/CPIMS/task/list">任务列表</a></li>
					<li><a target="mainFrame"
						href="/CPIMS/task/currentlist?id=${currentEmployee.employeeId }">个人任务列表</a></li>
					<li><a target="mainFrame"
						href="/CPIMS/logBook/list?id=${currentEmployee.employeeId }">工作日志列表</a></li>
				</ul></li>
			<li><a class="dropmenu">专家系统</a>
				<ul class="submenu">
					<li><a target="mainFrame" href="/CPIMS/specialistapply/toSave">专家申请</a></li>
					<li><a target="mainFrame"
						href="/CPIMS/specialistapply/allowedlist">已审批</a></li>

				</ul></li>
			<li><a class="dropmenu">职称系统</a>
				<ul class="submenu">
					<li><a target="mainFrame" href="/CPIMS/rankapply/toSave">提升职称申请</a></li>
					<li><a target="mainFrame" href="/CPIMS/rankapply/allowedlist">已审批</a></li>
				</ul></li>
			<li><a class="dropmenu">信息系统</a>
				<ul class="submenu">
					<li><a target="mainFrame" href="/CPIMS/InforMation/toSave">发布信息</a></li>
					<li><a target="mainFrame" href="/CPIMS/InforMation/list">信息列表</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- 内容区域-->
	<div class="frame-main">
		<iframe id="MainFrame" scrolling="auto" frameborder="no"
			name="mainFrame" src="/CPIMS/InforMation/list"> </iframe>
	</div>
</body>
</html>
