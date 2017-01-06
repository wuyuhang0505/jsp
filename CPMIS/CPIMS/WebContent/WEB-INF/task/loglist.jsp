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
function checkshowPage()
{
	var page=document.getElementById("sp").value;
	if(isNaN(page)){
    	 document.getElementById("sp").value=null;
		}
	else{
		if(parseInt(page)!=page){
	     document.getElementById("sp").value=null;
		}	
	}
}
</script>
</head>

<body class="nested">
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">工作日志列表</span>
		</div>
		<table class="list_table" width="98%">
			<tr>
				<th width="50px">序号</th>
				<th>任务Id</th>
				<th>记录日期</th>
				<th>日志内容</th>
				<th>操作 </th>
			</tr>
			<c:forEach items="${logList }" var="logbook" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${logbook.taskId }</td>
					<td>${logbook.logDate }</td>
					<td>${logbook.logContent }</td>
					<td><a href="/CPIMS/logBook/toEdit?logBookId=${logbook.logBookId }&id=${currentEmployee.employeeId }">修改</a>
					<a href="/CPIMS/logBook/delete?logBookId=${logbook.logBookId }&id=${currentEmployee.employeeId }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="toolbg">

		    <div class="pagination">
		      <form method="post" action='<c:url value="/logBook/list"/>'>
                                              跳转到第<input type="text" id="sp" name="showPage" value="1" size="4" onblur="checkshowPage()" />页
                         <input type="submit" name="submit" value="跳转" />
                         <input type="hidden" name="id" value=${currentEmployee.employeeId } />
              </form>
		    </div>
			<div class="pagination">
			        第${showPage}页（共${pageCount}页${recordCount}条记录）
			    <a href='<c:url value="/logBook/list?id=${currentEmployee.employeeId }&showPage=1"/>'>首页</a>
			    <a href='<c:url value="/logBook/list?id=${currentEmployee.employeeId }&showPage=${showPage-1}"/>'>上一页</a>
			    <a href='<c:url value="/logBook/list?id=${currentEmployee.employeeId }&showPage=${showPage+1}"/>'>下一页</a>
			    <a href='<c:url value="/logBook/list?id=${currentEmployee.employeeId }&showPage=${pageCount}"/>'>末页</a>
			</div>
		</div>
	</div>
</body>
</html>
