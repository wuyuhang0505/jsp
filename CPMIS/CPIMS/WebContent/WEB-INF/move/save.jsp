<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/CPIMS/static/css/global.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/CPIMS/static/js/common/jquery.js"></script>
<script type="text/javascript"
	src="/CPIMS/static/js/common/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
	function depcharg(optype) {
		$("#empform").attr("action", "/CPIMS/move/toSave?optype="+optype);
		$("#empform").submit();

	}
</script>
</head>

<body>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">调动信息</span>
		</div>
		<div class="fmcontainer">
			<form id="empform" action="/CPIMS/move/${empty move?"save":"edit"}" method="post">
				<input type="hidden" name="moveId"
					value="${move.moveId }"></input>
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">调动前部门：</td>
						<td><select name="sourcedepartmentId"
							onchange="javascript:depcharg(1)">
								<c:forEach items="${departmentList}" var="firstlut">
									<c:choose>
										<c:when
											test="${(firstlut.departmentId ==move.sourcedepartmentId)||(firstlut.departmentId ==firstselcID)}">
											<option value="${firstlut.departmentId }" selected="selected">${firstlut.departmentName }</option>
										</c:when>
										<c:otherwise>
											<option value="${firstlut.departmentId }">${firstlut.departmentName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
							<td class="leftlabel">调动后部门：</td>
						<td><select name="destdepartmentId"
							onchange="javascript:depcharg(2)">
								<c:forEach items="${departmentList}" var="secondlut">
									<c:choose>
										<c:when
											test="${(secondlut.departmentId ==move.destdepartmentId)||(secondlut.departmentId ==secondselcID)}">
											<option value="${secondlut.departmentId }" selected="selected">${secondlut.departmentName }</option>
										</c:when>
										<c:otherwise>
											<option value="${secondlut.departmentId }">${secondlut.departmentName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						
					</tr>
					<tr>
						<td class="leftlabel">调动前岗位：</td>
						<td><select name="sourcepostId" onchange="javascript:depcharg(11)">
								<c:forEach items="${firstpostList}" var="firstlpo">
									<c:choose>
										<c:when test="${firstlpo.postId ==firspostID }">
											<option value="${firstlpo.postId }" selected="selected">${firstlpo.postName }</option>
										</c:when>
										<c:otherwise>
											<option value="${firstlpo.postId }">${firstlpo.postName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td class="leftlabel">调动后岗位：</td>
						<td><select name="destpostId" >
								<c:forEach items="${secondpostList}" var="secondlpo">
									<c:choose>
										<c:when test="${secondlpo.postId ==post.postId }">
											<option value="${secondlpo.postId }" selected="selected">${secondlpo.postName }</option>
										</c:when>
										<c:otherwise>
											<option value="${secondlpo.postId }">${secondlpo.postName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="leftlabel">选择员工：</td>
						<td><select name="employeeId">
								<c:forEach items="${empList}" var="emp">
									<c:choose>
										<c:when test="${emp.employeeId ==employee.employeeId }">
											<option value="${emp.employeeId }" selected="selected">${emp.employeeName }</option>
										</c:when>
										<c:otherwise>
											<option value="${emp.employeeId }">${emp.employeeName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td class="leftlabel">调动时间：</td>
						<td>
						<script language="javascript" type="text/javascript" src="../static/js/common/datepicker/WdatePicker.js"></script>
						<input id="time" type="text" name="moveTime"  value="${move.moveTime }" />
 						<img onclick="WdatePicker({el:'time'})" src="../static/js/common/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" />
							</td> 
					</tr>
					<tr>
						<td class="leftlabel">调动原因：</td>
						<td colspan="3"><textarea name="moveReason" cols="60" rows="8">${move.moveReason }</textarea></td>
					</tr>
					
				</table>
				<div class="fmsubmitbtn">
					<input type="submit" class="btn" value="提 交" /> <input
						type="reset" name="cancle" class="btn" value="取 消" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
