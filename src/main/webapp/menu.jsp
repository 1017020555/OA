<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script language='javascript' type="text/javascript">
	var curopenItem = '1';

	$(function () {
		$.ajax({
			url:"${pageContext.request.contextPath}/sources/getSourcesByEid",
			type:"get"
		});
    });
</script>
<script language="javascript" type="text/javascript"
	src="skin/js/frame/menu.js"></script>

<base target="main" />
</head>
<body target="main">
	<table  width='99%' height="100%" border='0' cellspacing='0' cellpadding='0' >
        <tr>
			<td style='padding-left:3px;padding-top:8px' valign='top' id="menuss">
<c:forEach items="${sessionScope.lists}" var="list" varStatus="i">
	<dl class='bitem'>
			<dt onclick=showHide("items${i.count}_1")><b>${list.name}</b></dt>
			<dd style='display:block' class='sitem' id=items${i.count}_1>
				<ul class='sitemu' id=${i.index}>
					<c:forEach items="#{list.children}" var="sources">
						<li><a href='${sources.url}' target='main'>${sources.name}</a> </li>
					</c:forEach>
				</ul>
			</dd>
	</dl>
</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>