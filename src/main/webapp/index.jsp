<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: red;
            font-size: 14px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: #5BC0DE;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h3>
    <a href="${path }/user/userInfo">进入用户管理页</a><br/>
    <a href="${path}/page/test.html">path点击进入测试页面</a><br/>
    <a href="page/test.html">绝对path  点击进入测试页面</a><br/>
    <a href="test1.html">测试页面1</a><br/>
    <a href="www.baidu.com">百度</a><br/>
    <p>${path}123456</p>

</h3>
</body>
</html>