<%--
  Created by IntelliJ IDEA.
  User: Sholtun
  Date: 10.12.13
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<p>
    Login: <%= request.getParameter("login") %>
</p>
<p>
    Password: <%= request.getParameter("password") %>
</p>
</body>
</html>
