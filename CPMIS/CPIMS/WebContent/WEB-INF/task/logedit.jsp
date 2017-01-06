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
			<span class="columntitle">发布信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/logBook/edit" method="post">
				<input type="hidden" name="logBookId" value="${logbook.logBookId }"></input>
				<input type="hidden" name="taskId" value="${logbook.taskId }"></input>
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">记录时间：</td>
						<td><script language="javascript" type="text/javascript" src="../static/js/common/datepicker/WdatePicker.js"></script>
						<input id="d12" value="${logbook.logDate }" name="logDate" type="text"  readonly="readonly" />
						<img onclick="WdatePicker({el:'d12'})" src="../static/js/common/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
					</tr>
					<tr>
						<td class="leftlabel">工作日志：</td>
						<td colspan="3"><textarea name="logContent" cols="60" rows="8">${logbook.logContent }</textarea></td>
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
