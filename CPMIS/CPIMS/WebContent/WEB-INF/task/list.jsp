<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>任务列表</title>
<link href="/CPIMS/static/css/global.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/CPIMS/static/js/common/jquery.js"></script>
<script type="text/javascript" src="/CPIMS/static/js/common/common.js"></script>
<script type="text/javascript">
	function checkshowPage() {
		var page = document.getElementById("sp").value;
		if (isNaN(page)) {
			document.getElementById("sp").value = null;
		} else {
			if (parseInt(page) != page) {
				document.getElementById("sp").value = null;
			}
		}
	}
</script>
</head>

<body class="nested">
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">任务列表</span>
		</div>
		<table class="list_table" width="98%">
			<tr>
				<th width="50px">序号</th>
				<th>任务编号</th>
				<th>任务名</th>
				<th>任务发布者部门</th>
				<th>任务发布者岗位</th>
				<th>任务发布者员工编号</th>
				<th>任务发布者名字</th>
				<th>任务执行者部门</th>
				<th>任务执行者岗位</th>
				<th>任务执行者员工编号</th>
				<th>任务执行者名字</th>
				<th>任务发布日期</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${taskList }" var="task" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${task.taskNum }</td>
					<td>${task.taskName }</td>
					<td>${task.sourcedepartmentName }</td>
					<td>${task.sourcepostName }</td>
					<td>${task.sourceemployeeNum }</td>
					<td>${task.sourceemployeeName }</td>
					<td>${task.destdepartmentName }</td>
					<td>${task.destpostName }</td>
					<td>${task.destemployeeNum }</td>
					<td>${task.destemployeeName }</td>
					<td>${task.taskStarTime }</td>
					<td><a href="/CPIMS/task/toSave?taskId=${task.taskId }">修改</a>
						<a href="/CPIMS/task/delete?taskId=${task.taskId }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="toolbg">

			<div class="pagination">
				<form method="post" action='<c:url value="/task/list" />'>
					跳转到第<input type="text" id="sp" name="showPage" value="1" size="4"
						onblur="checkshowPage()" />页 <input type="submit" name="submit"
						value="跳转" />
				</form>
			</div>
			<div class="pagination">
				第${showPage}页（共${pageCount}页${recordCount}条记录） <a
					href='<c:url value="/task/list?showPage=1"/>'>首页</a> <a
					href='<c:url value="/task/list?showPage=${showPage-1}"/>'>上一页</a> <a
					href='<c:url value="/task/list?showPage=${showPage+1}"/>'>下一页</a> <a
					href='<c:url value="/task/list?showPage=${pageCount}"/>'>末页</a>
			</div>
		</div>
	</div>
</body>
</html>
