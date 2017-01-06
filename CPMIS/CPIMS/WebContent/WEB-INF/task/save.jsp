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
		$("#emp").attr("action", "/CPIMS/task/toSave?optype="+optype);
		$("#emp").submit();

	}
</script>
</head>

<body>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">发布信息</span>
		</div>
		<div class="fmcontainer">
			<form id="emp" action="/CPIMS/task/${empty task?"
				save":"edit" }" method="post">
				<input type="hidden" name="taskId" value="${task.taskId }"></input>
				<table class="inputtable" width="98%">
				<tr>
						<td class="leftlabel">任务发布者部门：</td>
						<td><select name="sourcedepartmentId"
							onchange="javascript:depcharg(1)">
								<c:forEach items="${departmentList}" var="firstlut">
									<c:choose>
										<c:when	test="${(firstlut.departmentId ==task.sourcedepartmentId)||(firstlut.departmentId ==firstselcID)}">
											<option value="${firstlut.departmentId }" selected="selected">${firstlut.departmentName }</option>
										</c:when>
										<c:otherwise>
											<option value="${firstlut.departmentId }">${firstlut.departmentName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
							<td class="leftlabel">任务执行者部门：</td>
						<td><select name="destdepartmentId"
							onchange="javascript:depcharg(2)">
								<c:forEach items="${departmentList}" var="secondlut">
									<c:choose>
										<c:when
											test="${(secondlut.departmentId ==task.destdepartmentId)||(secondlut.departmentId ==secondselcID)}">
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
						<td class="leftlabel">任务发布者岗位：</td>
						<td><select name="sourcepostId" 
						onchange="javascript:depcharg(11)">
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
						<td class="leftlabel">任务执行者岗位：</td>
						<td><select name="destpostId" 
						onchange="javascript:depcharg(21)">
								<c:forEach items="${secondpostList}" var="secondlpo">
									<c:choose>
										<c:when test="${secondlpo.postId ==secondpostID }">
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
						<td class="leftlabel">任务发布者：</td>
						<td><select name="employeeId">
								<c:forEach items="${firstempList}" var="firstemp">
									<c:choose>
										<c:when test="${firstemp.employeeId ==employee.employeeId || firstemp.employeeId == sourceempID}">
											<option value="${firstemp.employeeId }" selected="selected">${firstemp.employeeName }</option>
										</c:when>
										<c:otherwise>
											<option value="${firstemp.employeeId }">${firstemp.employeeName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td class="leftlabel">任务执行者：</td>
						<td><select name="tasktakerId">
								<c:forEach items="${secondempList}" var="secondemp">
									<c:choose>
										<c:when test="${secondemp.employeeId ==employee.employeeId }">
											<option value="${secondemp.employeeId }" selected="selected">${secondemp.employeeName }</option>
										</c:when>
										<c:otherwise>
											<option value="${secondemp.employeeId }">${secondemp.employeeName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						</tr>
					<tr>
						<td class="leftlabel">任务名：</td>
						<td><input name="taskName" type="text" value="${task.taskName }" /></td>
						<td class="leftlabel">任务编号：</td>
						<td><input name="taskNum" type="text" value="${task.taskNum }" /></td>
					</tr>
					<tr>
						<td class="leftlabel">任务发布时间：</td>
						<td><script language="javascript" type="text/javascript" src="../static/js/common/datepicker/WdatePicker.js"></script>
						<input id="d12" value="${task.taskStarTime }" name="taskStarTime" type="text"  readonly="readonly"/>
						<img onclick="WdatePicker({el:'d12'})" src="../static/js/common/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">

						</td>
						<td class="leftlabel">任务周期（天）：</td>
						<td><input value="${task.taskLimit }" name="taskLimit" type="text" /></td>
					</tr>
					<tr>
					    <td class="leftlabel">任务状态：</td>
						<td><input type="radio" name="taskCompleted"
							${empty task || task.taskCompleted eq true? "checked='checked'":"" } value="true" /><label>已完成</label>
							<input type="radio" name="taskCompleted"
							${task.taskCompleted eq false? "checked='checked'":"" } value="false" /><label>未完成</label>
						</td>
					</tr>
					<tr>
						<td class="leftlabel">任务内容：</td>
						<td colspan="3"><textarea name="context" cols="60" rows="8">${task.context }</textarea></td>
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
