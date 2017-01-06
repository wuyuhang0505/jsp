<%@page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/CPIMS/static/css/global.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="/CPIMS/static/js/common/datepicker/WdatePicker.js"></script>

<script language="javascript">
	
</script>

</head>

<body>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">消息详情</span>
		</div>
		<div class="fmcontainer">
			<table class="inputtable" width="98%">
				<tr>
					<td class="leftlabel">消息标题：</td>
					<td><input type="text" name="informTitle" readonly="readonly" value="${informtion.informTitle}"></input></td>
					<td class="leftlabel">发布时间：</td>
					<td><input type="text" name="informTime" readonly="readonly" value="${informtion.informTime}"></input></td>
				</tr>
				<tr>
					<td class="leftlabel">消息内容：</td>
					<td colspan="3"><textarea name="context" cols="60" rows="8" readonly="readonly">${informtion.informBody}</textarea></td>
				</tr>
				<tr>
					<td class="leftlabel">发布人：</td>
					<td><input type="text" name="informTime" readonly="readonly" value="${informtion.employeeName}"></input></td>
				</tr>
			</table>
			<div class="fmsubmitbtn">
				<a href="/CPIMS/InforMation/list">返回消息列表</a>
			</div>
		</div>
	</div>
</body>
</html>
