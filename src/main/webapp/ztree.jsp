<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/30
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>

    <SCRIPT type="text/javascript">
        <!--
        var setting = {
            async: {
                enable: true,
                url: "http://host/getNode.php",
                autoParam: ["id"]
            }
        };

        var zNodes =[
            { name:"pNode 01", open:true,
                children: [
                    { name:"pNode 11",
                        children: [
                            { name:"leaf node 111"},
                            { name:"leaf node 112"},
                            { name:"leaf node 113"},
                            { name:"leaf node 114"}
                        ]},
                    { name:"pNode 12",
                        children: [
                            { name:"leaf node 121"},
                            { name:"leaf node 122"},
                            { name:"leaf node 123"},
                            { name:"leaf node 124"}
                        ]},
                    { name:"pNode 13 - no child", isParent:true}
                ]},
            { name:"pNode 02",
                children: [
                    { name:"pNode 21", open:true,
                        children: [
                            { name:"leaf node 211"},
                            { name:"leaf node 212"},
                            { name:"leaf node 213"},
                            { name:"leaf node 214"}
                        ]},
                    { name:"pNode 22",
                        children: [
                            { name:"leaf node 221"},
                            { name:"leaf node 222"},
                            { name:"leaf node 223"},
                            { name:"leaf node 224"}
                        ]},
                    { name:"pNode 23",
                        children: [
                            { name:"leaf node 231"},
                            { name:"leaf node 232"},
                            { name:"leaf node 233"},
                            { name:"leaf node 234"}
                        ]}
                ]},
            { name:"pNode 3 - no child", isParent:true}

        ];

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
        //-->
    </SCRIPT>
</head>
<body>

<div class="zTreeDemoBackground left">
    <ul id="treeDemo" class="ztree"></ul>
</div>

</body>
</html>
