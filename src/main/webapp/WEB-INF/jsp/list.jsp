<%@ include file="header.jsp" %>
<h1>
    <div style="text-align: center;">Users</div>
</h1>

<div class="panel-body">
    <div style="align-content: center;">
        <a type="button" class="btn btn-primary" href="/create">Create User</a>
    </div>
    <table class="table table-sm">
        <thead>
        <tr>
            <th width="30%">Name</th>
            <th width="30%">Title</th>
            <th width="20%">Security Number</th>
            <th width="20%">Available Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.title}</td>
                <td>${user.secureNumber}</td>
                <td><a type="button" class="btn btn-warning"
                       href="/edit?id=${user.id}">Edit</a>
                    <a type="button" class="btn btn-danger"
                       href="/delete?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>