<%@ page import="com.debertz.logic.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="templates/bootstrap-include.jsp" %>
    <title>Debertz Online</title>
</head>

<body style="padding-top: 65px;">
<jsp:include page="/header"/>

<div class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Adding table</h4>
            </div>
            <form method="post" action="/newTable">
                <div class="modal-body">
                    <div>
                        Players count:
                    </div>
                    <div style="float: left">
                        <select name="players">
                            <option value="1" selected>2</option>
                            <option value="2">3</option>
                            <option value="3">4</option>
                        </select>
                    </div>
                    <div>
                        Max score:
                    </div>
                    <div style="float: left">
                        <select name="score">
                            <option value="501" selected>501</option>
                            <option value="1001">1001</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-primary">Create</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div class="container">
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newTableModal">
        Add table
    </button>
    <table class="table table-bordered table-hover">
        <tr>
            <th>Header1</th>
            <th>Header2</th>
            <th>Header3</th>
        </tr>
        <jsp:include page="/tables"/>
    </table>
</div>

</body>
</html>
