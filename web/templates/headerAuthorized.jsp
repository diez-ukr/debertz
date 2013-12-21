<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Debertz</a>

            <div class="nav-collapse collapse">
                <p class="navbar-text">Logged in as <%= request.getAttribute("username").toString() %>
                </p>
                <button type="button" class="btn btn-primary">Logout</button>
            </div>
        </div>
    </div>
</div>