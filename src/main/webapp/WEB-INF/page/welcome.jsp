<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <title>主页</title>
</head>
<body>
<ul class="layui-nav layui-bg-cyan">
    <li class="layui-nav-item layui-this"><a href="index.jsp">主页</a></li>
    <li class="layui-nav-item"><a href="userManage.jsp">用户管理</a></li>
    <li class="layui-nav-item"><a href="roleManage.jsp">角色管理</a></li>
    <li class="layui-nav-item"><a href="powerManage.jsp">权限管理</a></li>
    <li class="layui-nav-item"><a href="privateIndex.jsp">个人中心</a></li>
</ul>
<p>这是主页 <br>请登陆123</p>
<button class="layui-btn layui-btn-normal" onclick="window.location.href='login.jsp'">登陆</button>


</body>


<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function() {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
</html>