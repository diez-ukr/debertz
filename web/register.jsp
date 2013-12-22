<%@ page import="com.debertz.status.Status" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="templates/bootstrap-include.jsp" %>
    <title>Register</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span8">
            <form class="form-horizontal" method="post" action="/register">
                <fieldset>
                    <legend>Registration</legend>
                    <div id="alertMsg" class="alert alert-error" style="display: none">
                        <a class="close" data-dismiss="alert">x</a>
                        ${requestScope.status.toString()}
                    </div>
                    <div class="control-group">
                        <label class="control-label">Login</label>

                        <div class="controls">
                            <input id="login_input" type="text" class="input-xlarge" name="login"
                                   data-original-title="Login">
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label">Password</label>

                        <div class="controls">
                            <input id="password_input" type="password" class="input-xlarge" name="password"
                                   data-original-title="Password">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label"></label>

                        <div class="controls">
                            <button type="submit" class="btn btn-success">Create Account</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script>
<%if (request.getAttribute("status") != null &&
        request.getAttribute("status") != Status.Authorization.OK.toString()){%>
        $(".alert").show();
<%}%>
</script>
</body>
</html>