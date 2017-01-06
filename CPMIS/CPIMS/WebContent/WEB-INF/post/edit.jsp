<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		function change() {
			var sel = document.getElementsByName("departmentId")[0];
			var selvalue = sel.options[sel.options.selectedIndex].text;
			document.getElementById("deName").value = selvalue;
		}
	</script>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">岗位信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/post/edit" method="post"
				onsubmit="return check();">
				<input type="hidden" name="postId" value="${post.postId}"></input> <input
					type="hidden" name="departmentName" value="${post.departmentName}"
					id="deName"></input>
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">所属部门：</td>
						<td><select name="departmentId" id="deID" onchange="change()">
								<c:forEach items="${deList}" var="lut">
									<c:choose>
										<c:when test="${lut.departmentId ==post.departmentId }">
											<option value="${lut.departmentId }" selected="selected">${lut.departmentName }</option>
										</c:when>
										<c:otherwise>
											<option value="${lut.departmentId }">${lut.departmentName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td class="leftlabel">岗位编号：</td>
						<td><input name="postNum" type="text" id="num" readonly="readonly"
							value="${post.postNum }" /></td>
					</tr>
					<tr>
						<td class="leftlabel">岗位名称：</td>
						<td><input value="${post.postName }" name="postName"
							id="name" type="text" /></td>
					</tr>
				</table>
				<div class="fmsubmitbtn">
					<input type="submit" class="btn" value="提 交" /> <input
						type="reset" name="cancle" class="btn" value="重置" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
