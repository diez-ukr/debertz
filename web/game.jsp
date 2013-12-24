<%@ page import="java.util.LinkedList" %>
<%@ page import="com.debertz.logic.*" %>
<%@ page import="com.debertz.dao.Users" %>
<%--
  Created by IntelliJ IDEA.
  User: diezu_000
  Date: 24.12.13
  Time: 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Game</title>
    <link rel="stylesheet" href="css/game.css"/>
    <jsp:include page="templates/bootstrap-include.jsp"/>
</head>
<body>
<div class="north">
</div>

<div class="topName">
    ${requestScope.topName}
</div>

<div class="south">
    <%
        LinkedList<PlayingCard> cards = (LinkedList<PlayingCard>) request.getAttribute("cards");
        for (PlayingCard card : cards) {
            String cardUrl = PlayingCard.getResourceName(card);
    %>
    <div class="vertical-card playing-card-image" style="background: url(<%=cardUrl%>)">

    </div>
    <%}%>
</div>

<%
    User userCurrent = (User) session.getAttribute("user");
    Table table = TablePool.get(userCurrent);
    DebertzGameRound round = table.getCurrentGame().getCurrentRound();
    DebertzGamePlayer playerCurrent = round.getTurn();
    User userPlaying = Users.getUser(playerCurrent.getPlayerName());
    if (userPlaying == userCurrent) {
%>
<div class="moreButton">
    <a href="/game&more" class="btn">More</a>
</div>

<div class="enoughButton">
    <a href="/game&enough" class="btn">Enough</a>
</div>
<%}%>
<div class="points">
    ${requestScope.pointsCount}
</div>

<div class="gameMessage">
    <%if (userPlaying != userCurrent) {%>
        Wait please
    <%}%>
</div>

<div class="leftName">
    ${requestScope.leftName}
</div>

<div class="rightName">
    ${requestScope.rightName}
</div>

</body>
</html>