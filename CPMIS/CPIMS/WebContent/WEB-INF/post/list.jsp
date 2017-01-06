<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>岗位列表</title>
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
				<th width="40px"><input type="checkbox" name="checkedAll"
					alt="全选/取消" onclick="doCheckedAll(this);" /></th>
				<th width="50px">序号</th>
				<th>所属部门</th>
				<th>岗位编号</th>
				<th>岗位名称</th>
				<th>岗位人数</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${postList }" var="post" varStatus="status">
				<tr>
					<td class="checkbox_first"><input type="checkbox"
						name="check1" class="rowchecker" /></td>
					<td>${status.index+1 }</td>
					<td>${post.departmentName }</td>
					<td>${post.postNum }</td>
					<td>${post.postName }</td>
					<td>${post.postEmployeeCount }</td>
					<td><a href="/CPIMS/post/toEdit?id=${post.postId }">修改</a>
						<a href="/CPIMS/post/delete?id=${post.postId }">撤销岗位</a></td>
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
			    <a href="/CPIMS/post/list?showPage=1">首页</a>
			    <a href="/CPIMS/post/list?showPage=${showPage-1}">上一页</a>
			    <a href="/CPIMS/post/list?showPage=${showPage+1}">下一页</a>
			    <a href="/CPIMS/post/list?showPage=${pageCount}">末页</a>
			</div>
		</div>
	</div>
</body>
</html>
