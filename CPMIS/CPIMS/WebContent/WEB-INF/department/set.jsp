<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/CPIMS/static/css/global.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="/CPIMS/static/js/common/datepicker/WdatePicker.js"></script>
</head>

<body>
<script language="JavaScript">
function change(){
	var sel=document.getElementsByName("departmentChief")[0];
	var selvalue= sel.options[sel.options.selectedIndex].text;
	document.getElementById("deChiName").value=selvalue;
}
</script>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">部门信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/department/edit" method="post" onsubmit="return change();" >
				<input type="hidden" name="departmentChiefNa" id="deChiName" value="${department.departmentChiefNa}" id="deChiName"></input>
				<input type="hidden" name="departmentId"
					value="${department.departmentId }"></input>
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">部门名：</td>
						<td><input name="departmentName" type="text" id="name" readonly="readonly" 
							value="${department.departmentName }" /></td>
						<td class="leftlabel">部门编号：</td>
						<td><input name="departmentNum" type="text" id="num" readonly="readonly"
							value="${department.departmentNum }" /></td>
					</tr>
					<tr>
						<td class="leftlabel">部门主管：</td>
						<td><select name="departmentChief" id="deChi" onchange="change()">
								<c:forEach items="${empList}" var="lut">
									<c:choose>
										<c:when test="${lut.employeeId ==department.departmentChief }">
											<option value="${lut.employeeId }" selected="selected">${lut.employeeName }</option>
										</c:when>
										<c:otherwise>
											<option value="${lut.employeeId }">${lut.employeeName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="leftlabel">部门介绍：</td>
						<td colspan="3"><textarea name="remark" cols="60" rows="8">${department.remark }</textarea></td>
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
