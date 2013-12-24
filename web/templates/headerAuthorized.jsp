<%@ page import="com.debertz.logic.User" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Debertz</a>

            <div class="nav-collapse collapse">
                <p class="navbar-text pull-left">Logged in as: <b>${requestScope.login}</b></p>
                <a class="btn btn-success pull-right" href="/authorize">Sign out</a>
            </div>
        </div>
    </div>
</div>