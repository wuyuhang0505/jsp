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
<script language="JavaScript">
function check(){
	var reg = new RegExp("^[0-9]*$");
	var listNum=document.getElementById("listNum").value;
	var name=document.getElementById("name").value;
	var num=document.getElementById("num").value;
	var list = listNum.split(' ');
	for(var i=0;i<list.length-1;i++){
		if(num == list[i]){
			alert("部门编号重复，添加失败！");
			return false;
		}
	}
	if(!name){
		alert("部门名不能为空！");
		return false;
	}else if(!num){
		alert("部门编号不能为空！");
		return false;
	}else if(!reg.test(num)){
		alert("部门编号只能为数字！");
		return false;
	}else{
		return true;
	}
}
</script>
	<div class="maincontainer">
		<div class="columnconn">
			<span class="columntitle">部门信息</span>
		</div>
		<div class="fmcontainer">
			<form action="/CPIMS/department/save" method="post"  onsubmit = "return check();">
				<input type="hidden" value="${deNumList }" id = "listNum" />
				<input type="hidden" name="departmentId"
					value="${department.departmentId }"></input>
				<table class="inputtable" width="98%">
					<tr>
						<td class="leftlabel">部门名：</td>
						<td><input name="departmentName" type="text" id="name"
							value="${department.departmentName }" /></td>
						<td class="leftlabel">部门编号：</td>
						<td><input name="departmentNum" type="text" id="num"
							value="${department.departmentNum }" /></td>
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
