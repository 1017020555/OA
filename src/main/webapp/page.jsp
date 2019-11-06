<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>附件管理</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function go() {
            var num=$("#in").val();
            var reg = /^[1-9]\d*$/;
            if(!reg.test(num)){
                alert("请输入一个正整数")
                return;
            }else {
                window.location.href="${uri}?rowNum="+num+"${queryStr}";
            }
        }
    </script>
</head>

<body>
<tr align="right" bgcolor="#EEF4EA">
    <td height="36" colspan="12" align="center">
        <div>
            <a href="${uri}?rowNum=1${queryStr}">首页</a>
            <a href="${uri}?rowNum=${page.pageNum-1}${queryStr}">上一页</a>
            <c:forEach items="${page.navigatepageNums}" var="num">
                <c:if test="${num==page.pageNum}">
                    <span style="color: black;font-weight: bold;background-color: white">${num}</span>
                </c:if>
                <c:if test="${num!=page.pageNum}">
                    <a href="${uri}?rowNum=${num}${queryStr}">${num}</a>
                </c:if>
            </c:forEach>页
            <a href="${uri}?rowNum=${page.pageNum+1}${queryStr}">下一页</a>
            <a href="${uri}?rowNum=${page.pages}${queryStr}">末页</a>
            <input id="in" placeholder="输入要查的页码" onblur="go()">
        </div>
    </td>
</tr>
</body>