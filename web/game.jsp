<%@ page import="com.debertz.logic.PlayingCard" %>
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
    <title>piska-pipiska</title>
    <link rel="stylesheet" href="css/game.css" />
</head>
<body>
<div class="north">
</div>

<div class="topName">
    TOPNAME
</div>

<div class="south">
    <%! String cardUrl = PlayingCard.getResourceName(new PlayingCard(PlayingCard.Rank.King, PlayingCard.Suit.Club));%>
    <div class="vertical-card playing-card-image" style="background: url(<%=cardUrl%>)">

    </div>
</div>

<div class="moreButton">
    MORE
</div>

<div class="enoughButton">
    ENOUGH
</div>

<div class="points">
    POINTS
</div>

<div class="gameMessage">
    MESSAGE CYKA PIPIRKA WIN
</div>

<div class="west">
</div>

<div class="leftName">
    LEFTNAME
</div>

<div class="rightName">
    RIGHTNAME
</div>

<div class="east">
</div>
</body>
</html>