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
		function check() {
			var numList = document.getElementById("postNumList").value;
			var reg = new RegExp("^[0-9]*$");
			var num = document.getElementById("num").value;
			var name = document.getElementById("name").value;
			var list = numList.split(' ');
			for (var i = 0; i < list.length - 1; i++) {
				if (num == list[i]) {
					alert("岗位编号重复，添加失败！");
					return false;
				}
			}
			if (!name) {
				alert("岗位名不能为空！");
				return false;
			} else if (!num) {
				alert("岗位编号不能为空！");
				return false;
			} else if (!reg.test(num)) {
				alert("岗位编号只能为数字！");
				return false;
			} else {
				var sel = document.getElementsByName("departmentId")[0];
				var selvalue = sel.options[sel.options.selectedIndex].text;
				document.getElementById("deName").value = selvalue;
				return true;
			}
		}
	</script>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">岗位信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/post/save" method="post"
				onsubmit="return check();">
				<input type="hidden" name="postId" value="${post.postId}"></input> <input
					type="hidden" name="departmentName" value="${post.departmentName}"
					id="deName"></input> <input type="hidden" value="${postNumList}"
					id="postNumList" />
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">所属部门：</td>
						<td><select name="departmentId" id="deID">
								<c:forEach items="${deList}" var="lut">
										<option value="${lut.departmentId }" selected="selected">${lut.departmentName }</option>
								</c:forEach>
						</select></td>
						<td class="leftlabel">岗位编号：</td>
						<td><input name="postNum" type="text" id="num"
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
