<%@ page import="com.debertz.logic.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="templates/bootstrap-include.jsp" %>
    <title>Debertz Online</title>
</head>

<body style="padding-top: 65px;">
<jsp:include page="/header"/>

<div class="modal fade" id="newTableModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class=" modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Adding table</h4>
            </div>
            <form class="form-horizontal" role="form" method="post" action="/newTable">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="playersCount" class="col-sm-3 control-label">Players count: </label>

                        <div class="col-sm-2">
                            <select class="form-control" id="playersCount" name="players">
                                <option value="2" selected>2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pointsCount" class="col-sm-3 control-label">Points count: </label>

                        <div class="col-sm-2">
                            <select class="form-control" id="pointsCount" name="points">
                                <option value="501" selected>501</option>
                                <option value="1001">1001</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-primary" value="Create"></button>
                </div>
            </form>
        </div>
    </div>
</div>


<div class="container">
    <div style="margin-bottom: 5px">
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newTableModal">
            Add table
        </button>
    </div>
    <div>
        <table class="table table-bordered table-hover">
            <tr>
                <th>Parameters</th>
                <th>Players</th>
            </tr>
            <jsp:include page="/tableList"/>
        </table>
    </div>
</div>

</body>
</html>
