<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>级别提升申请列表</title>
<link href="/CPIMS/static/css/global.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/CPIMS/static/js/common/jquery.js"></script>
<script type="text/javascript" src="/CPIMS/static/js/common/common.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body class="nested">
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">发布信息列表</span>
		</div>

		<table class="list_table" width="98%">
			<tr>
				<th width="50px">序号</th>
				<th>职工编号</th>
				<th>申请时间</th>
				<th>申请原因</th>
				<th>是否通过</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${RankApplyList }" var="rankapply"
				varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${rankapply.employeeId }</td>
					<td>${rankapply.applyTime }</td>
					<td>${rankapply.applyReason }</td>
					<td>${rankapply.applyPass?"是":"否" }</td>
					<td><a
						href="/CPIMS/rankapply/allowrank?id=${rankapply.employeeId }&rId=${rankapply.rankApplyId }">允许</a>
						<a
						href="/CPIMS/rankapply/delete?id=${rankapply.rankApplyId }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="toolbg">
			<div class="pagination">
		      <form method="get">
                                              跳转到第<input type="text" name="showPage" value="1" size="4">页
                         <input type="submit" name="submit" value="跳转">
              </form>
		    </div>
			<div class="pagination">
			        第${showPage}页（共${pageCount}页${recordCount}条记录）
			    <a href="/CPIMS/rankapply/list?showPage=1">首页</a>
			    <a href="/CPIMS/rankapply/list?showPage=${showPage-1}">上一页</a>
			    <a href="/CPIMS/rankapply/list?showPage=${showPage+1}">下一页</a>
			    <a href="/CPIMS/rankapply/list?showPage=${pageCount}">末页</a>
			</div>
		</div>
	</div>
</body>
</html>
