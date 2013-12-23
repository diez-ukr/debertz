<%@ page import="com.debertz.logic.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="templates/bootstrap-include.jsp" %>
    <title>Debertz Online</title>
</head>

<body style="padding-top: 65px;">
<jsp:include page="/header"/>
<div class="container">
    <div style="width: auto; margin-bottom: 5px">
        <a class="btn btn-primary btn-lg" href="/">
            Leave table
        </a>
    </div>

    <%if (request.getAttribute("isCreator") != null) {%>
    <div style="margin-bottom: 5px; float: left">
        <a class="btn btn-primary btn-lg" href="/game">
            Start Game
        </a>
    </div>
    <%}%>

    <div>
        <table class="table table-bordered">
            <tr>
                <th>Players</th>
            </tr>

        </table>
    </div>
</div>

</body>
</html>
