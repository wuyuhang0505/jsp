<%@page contentType="text/html; charset=UTF-8" language="java"%>
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
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">专家信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/rankapply/${empty rankapply?"
				save":"edit"}" method="post">
				<input type="hidden" name="rankApplyId"
					value="${rankapply.rankApplyId }"></input>
					<input type="hidden" name="employeeName"
					value="${currentEmployee.employeeName }"></input>
					<input type="hidden" name="employeeId"
					value="${currentEmployee.employeeId }"></input>
				<table class="inputtable" width="98%">
					<!--<tr>
						<td class="leftlabel">职工名称：</td>
						<td><input name="employeeName" type="text"
							value="${rankapply.employeeName }" /></td>
						<td class="leftlabel">职工编号：</td>
						<td><input name="employeeId" type="text"
							value="${rankapply.employeeId }" /></td>

					</tr>-->
					<tr>
						
						<td class="leftlabel">申请时间：</td>
						<td><script language="javascript" type="text/javascript"
								src="../static/js/common/datepicker/WdatePicker.js"></script> <input
							id="d12" name="applyTime" type="text" readonly="readonly"
							value="${rankapply.applyTime}" /> <img
							onclick="WdatePicker({el:'d12'})"
							src="../static/js/common/datepicker/skin/datePicker.gif"
							width="16" height="22" /></td>
					</tr>
					<tr>
						<td class="leftlabel">申请原因：</td>
						<td colspan="3"><textarea name="applyReason" cols="60"
								rows="8">${rankapply.applyReason}</textarea></td>
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
