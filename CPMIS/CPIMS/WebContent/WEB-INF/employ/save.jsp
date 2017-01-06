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
</head>

<body>
<script language="JavaScript">
function check(){
	var reg = new RegExp("^[0-9]*$");
	var postId=document.getElementById("postId").value;
	var employGrade=document.getElementById("employGrade").value;
	var applicant=document.getElementById("applicant").value;
	var employTime=document.getElementById("employTime").value;
	var applicantPwd=document.getElementById("applicantPwd").value;
	var interviewGrade=document.getElementById("interviewGrade").value;
	if(!postId){
		alert("部门名不能为空！");
		return false;
	}else if(!employGrade){
		alert("笔试成绩不能为空！");
		return false;
	}else if(!applicant){
		alert("应聘者名字不能为空！");
		return false;
	}else if(!employTime){
		alert("应聘时间不能为空！");
		return false;
	}else if(!applicantPwd){
		alert("应聘者密码");
		return false;
	}else if(!interviewGrade){
			alert("面试成绩不能为空！");
			return false;
	}else{
		return true;
	}
}
</script>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">招聘信息</span>
		</div>
		<div class="fmcontainer">
			<form id="empform" action="/CPIMS/employ/${empty employ?"
				save":"edit"}" method="post"  onsubmit = "return check();">
				<input type="hidden" name="employId"
					value="${employ.employId }"></input>
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">应聘岗位名称：</td>
						<td><select name="postId">
								<c:forEach items="${postList}" var="lut">
									<c:choose>
										<c:when
											test="${(lut.postId ==employ.postId)}">
											<option value="${lut.postId }" selected="selected">${lut.postName }</option>
										</c:when>
										<c:otherwise>
											<option value="${lut.postId }">${lut.postName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td class="leftlabel">笔试成绩：</td>
						<td><input name="employGrade" type="text" id="employGrade"
							value="${employ.employGrade }" /></td>
					</tr>
					<tr>
					<td class="leftlabel">应聘者名字：</td>
						<td><input name="applicant" type="text" id="applicant"
							value="${employ.applicant }" /></td>						
						<td class="leftlabel">应聘时间：</td>
						<td>
						<script language="javascript" type="text/javascript" src="../static/js/common/datepicker/WdatePicker.js"></script>
						<input id="time" type="text" name="employTime"  value="${employ.employTime }" />
 						<img onclick="WdatePicker({el:'time'})" src="../static/js/common/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" />
							</td> 
					</tr>
					<tr>
						<td class="leftlabel">应聘者密码：</td>
						<td><input name="applicantPwd" type="text" id="applicantPwd"
							value="${employ.applicantPwd }" /></td>					
						<td class="leftlabel">面试成绩：</td>
						<td><input name="interviewGrade" type="text" id="interviewGrade"
							value="${employ.interviewGrade }" /></td>
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
