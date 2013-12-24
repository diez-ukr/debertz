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
    <div style="width: auto; margin: 5px; float: left;">
        <a class="btn btn-primary btn-lg" href="/table?join">
            Leave table
        </a>
    </div>

    <%
        User userCurrent = (User)session.getAttribute("user");
        if (TablePool.get(userCurrent).getCreator() == userCurrent) {
    %>
    <div style="margin: 5px;">
        <a class="btn btn-primary btn-lg" href="/game">
            Start Game
        </a>
    </div>
    <%}%>

    <div>
        <table class="table table-bordered">
            <tr>
                <th>Players:</th>
            </tr>
            <jsp:include page="/playerList"/>
        </table>
    </div>
</div>
<script>
    var response = 0;
    (function worker() {
        $.ajax({
            url: "/table",
            data: 'gameStatus',
            success: function (resp) {
                if (resp == '1')
                {
                    document.location.href = "/game";
                }
                setTimeout(worker, 500);
            }
        });
    })();

</script>
</body>
</html>
