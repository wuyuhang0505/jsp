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
	function depcharg() {
		$("#empform").attr("action", "/CPIMS/employee/toSave");
		$("#empform").submit();
	}
</script>
</head>

<body>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">发布信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/employee/${empty employee?"
				save":"edit" }" method="post" id="empform">
				<input type="hidden" name="employeeId"
					value="${employee.employeeId }"></input> <input type="hidden"
					name="id" value="${employee.employeeId }"></input>
				<table class="inputtable" width="98%">
				<tr>
						<td class="leftlabel">所属部门：</td>
						<td><select name="departmentId"
							onchange="javascript:depcharg()">
								<c:forEach items="${departmentList}" var="lut">
									<c:choose>
										<c:when
											test="${(lut.departmentId ==post.departmentId)||(lut.departmentId ==selcID)}">
											<option value="${lut.departmentId }" selected="selected">${lut.departmentName }</option>
										</c:when>
										<c:otherwise>
											<option value="${lut.departmentId }">${lut.departmentName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td class="leftlabel">所属岗位：</td>
						<td><select name="postId">
								<c:forEach items="${postList}" var="lpo">
									<c:choose>
										<c:when test="${lpo.postId ==post.postId }">
											<option value="${lpo.postId }" selected="selected">${lpo.postName }</option>
										</c:when>
										<c:otherwise>
											<option value="${lpo.postId }">${lpo.postName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
				<tr>
						<td class="leftlabel">员工编号：</td>
						<td><input name="employeeNum" type="text"
							value="${employee.employeeNum }" /></td>
						<td class="leftlabel">身份证号码：</td>
						<td><input name="employeeIdcard" type="text"
							value="${employee.employeeIdcard}" /></td>
					</tr>
					<tr>
						<td class="leftlabel">姓名：</td>
						<td><input name="employeeName" type="text"
							value="${employee.employeeName }" /></td>
						<td class="leftlabel">密码：</td>
						<td><input name="employeePwd" type="text"
							value="${employee.employeePwd}" /></td>
					</tr>
					<tr>
						<td class="leftlabel">年龄：</td>
						<td><input name="employeeAge" type="text"
							value="${employee.employeeAge }" /></td>
						<td class="leftlabel">性别：</td>
						<td>
                    	<input type="radio"	name="employeeSex" ${empty employee || employee.employeeSex eq 1? "checked='checked'":"" } value="1" /><label>男</label>
                        <input type="radio"	name="employeeSex" ${employee.employeeSex eq 0? "checked='checked'":"" }value="0" /><label>女</label>
                    </td>
					</tr>
					<tr>
						<td class="leftlabel">民族：</td>
						<td><input name="employeeNation" type="text"
							value="${employee.employeeNation }" /></td>
						<td class="leftlabel">籍贯：</td>
						<td><input name="employeeAddress" type="text"
							value="${employee.employeeAddress}" /></td>
					</tr>
					
					<tr>
						<td class="leftlabel">教育程度：</td>
						<td><input name="employeeEdu" type="text"
							value="${employee.employeeEdu }" /></td>
						<td class="leftlabel">签订合同日期：</td>
						<td>
						<script language="javascript" type="text/javascript" src="../static/js/common/datepicker/WdatePicker.js"></script>
						<input id="time" type="text" name="employeeContractTime"  value="${employee.employeeContractTime }" readonly="readonly"/>
 						<img onclick="WdatePicker({el:'time'})" src="../static/js/common/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" />
						</td>	
					</tr>
					<tr>
						
						<td class="leftlabel">合同时间长度：</td>
						<td><input name="employeeContractLength" type="text"
							value="${employee.employeeContractLength}" /></td>
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
