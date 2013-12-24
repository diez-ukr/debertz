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

    <%if (((Table)session.getAttribute("table")).getCreator()
            == session.getAttribute("user")){%>
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
    while (response == 0)
    {
        
    }
</script>
</body>
</html>
