<%@ include file="header.jsp" %>

<h1>
    <div style="text-align: center;">New User</div>
</h1>

<form action="/create" method="post">
    <fieldset class="form-group">
        <label>Name</label>
        <input type="text" name="name" required>
    </fieldset>
    <fieldset class="form-group">
        <label>Title</label>
        <input type="text" name="title" required>
    </fieldset>
    <fieldset class="form-group">
        <label>Security Code</label>
        <input type="text" name="secureNumber" required>
    </fieldset>
    <button type="submit" class="btn btn-success">Save</button>
</form>

<%@ include file="footer.jsp" %>
