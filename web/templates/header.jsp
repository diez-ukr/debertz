<%@ page import="com.debertz.authorization.Authorization" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Debertz</a>

            <div class="nav-collapse collapse">

                <%
                    Object sessionID = session.getAttribute("sid");
                    Object userName = session.getAttribute("username");
                    if (sessionID == null ||
                            userName == null ||
                            Authorization.validateSid(userName.toString(), sessionID.toString())) {
                %>
                <form class="navbar-form pull-right">
                    <input class="span2" type="text" placeholder="Login">
                    <input class="span2" type="password" placeholder="Password">
                    <button type="submit" class="btn btn-success">Sign in</button>
                    <a class="btn btn-primary" href=<%= request.getContextPath()%>"/register.jsp">Sign up</a>
                </form>
                <% } else { %>
                <p class="navbar-text">Logged in as <%= userName.toString() %></p>
                <button type="button" class="btn btn-primary">Logout</button>
                <% } %>
            </div>
        </div>
    </div>
</div>