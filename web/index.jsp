<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My JSP Page</title>
    <style type="text/css">
        div#authorization{
            position: absolute;
            margin: auto;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            width: 250px;
            height: 150px;
            border: 1px solid;
        }​
    </style>
  </head>
  <body>
    <div id="authorization">
        <form name="authorizationForm" method="post" action="test.jsp">
            <div style="width: 100%; height: 33%;">
                <div style="width: auto; float: left">
                    Login:
                </div>
                <div style="width: 150px; float: right;">
                    <input name="login" type="text">
                </div>
            </div>
            <div style="width: 100%; height: 33%;">
                <div style="width: auto; float: left;">
                    Password:
                </div>
                <div style="width: 150px; float: right;">
                    <input name="password" type="password">
                </div>
            </div>
            <div style="width: 100%; height: 33%;">
                <input type="submit" value="Login">
                <input type="reset" value="Clear">
            </div>
        </form>
    </div>
  </body>
</html>