<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>档案信息管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			$.ajax({
				url:"${pageContext.request.contextPath}/archive/getAll",
				method:"get"

			});
        });
	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>档案信息管理
 </td>

 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->

<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;员工档案信息列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">姓名</td>
	<td width="10%">年龄</td>
	<td width="10%">毕业院校</td>
	<td width="8%">入职时间</td>
	<td width="5%">联系方式</td>
	<td width="8%">学历</td>
	<td width="6%">邮箱</td>
	<td width="8%">政治面貌</td>
	<td width="8%">民族</td>	
	<td width="10%">操作</td>
</tr>

<c:forEach items="${lists}" var="archive" varStatus="i">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
		<td>${i.index+1}</td>
		<td align="left"><a href=''><u>${archive.employee.ename}</u></a></td>
		<td>${archive.employee.eage}</td>
		<td>${archive.school}</td>
		<td>${archive.hirdate}</td>
		<td>${archive.employee.telephone}</td>
		<td>${archive.xueli}</td>
		<td>${archive.email}</td>
		<td>${archive.zzmm}</td>
		<td>${archive.minzu}</td>
		<td><a href="project-base-edit.jsp">编辑</a> | <a href="myarchives.jsp">查看详情</a></td>
	</tr>
</c:forEach>



<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
	<a href="archives-add.jsp" class="coolbg">&nbsp;添加档案信息&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>