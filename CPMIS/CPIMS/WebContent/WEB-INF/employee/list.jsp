<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户列表</title>
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
				<th>员工编号</th>
				<th>身份证号码</th>
				<th>姓名</th>
				<th>密码</th>
				<th>年龄</th>
				<th>性别</th>
				<th>民族</th>
				<th>籍贯</th>
				<th>所属部门</th>
				<th>所属岗位</th>
				<th>教育程度</th>
				<th>是否在职</th>
				<th>签订合同日期</th>
				<th>合同时间长度</th>
				<th>是否为专家</th>
				<th>职称等级</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${employeeList }" var="employee" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${employee.employeeNum }</td>
					<td>${employee.employeeIdcard }</td>
					<td>${employee.employeeName }</td>
					<td>${employee.employeePwd }</td>
					<td>${employee.employeeAge }</td>
					<td>${employee.employeeSex?"男":"女"}</td>
					<td>${employee.employeeNation }</td>
					<td>${employee.employeeAddress }</td>
					<td>${employee.departmentName }</td>
					<td>${employee.postName }</td>
					<td>${employee.employeeEdu }</td>
					<td>${employee.employeeState }</td>
					<td>${employee.employeeContractTime }</td>
					<td>${employee.employeeContractLength }</td>
					<td>${employee.isSpecialist?"是":"否" }</td>
					<td>${employee.employeeTechPost}</td>
					<td><a href="/CPIMS/employee/toEdit?id=${employee.employeeId }">修改</a> <a
						href="/CPIMS/employee/delete?id=${employee.employeeId }">删除</a></td>
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
			    <a href="/CPIMS/employee/list?showPage=1">首页</a>
			    <a href="/CPIMS/employee/list?showPage=${showPage-1}">上一页</a>
			    <a href="/CPIMS/employee/list?showPage=${showPage+1}">下一页</a>
			    <a href="/CPIMS/employee/list?showPage=${pageCount}">末页</a>
			</div>
		</div>
	</div>
</body>
</html>
