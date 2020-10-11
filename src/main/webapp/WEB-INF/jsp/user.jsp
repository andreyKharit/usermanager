<%@ include file="header.jsp" %>

<h1>
    <div style="text-align: center;">Current User</div>
</h1>

<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <fieldset class="form-group">
        <form:label path="name">Name</form:label>
        <form:input path="name" type="text" class="form-control"
                    required="required"/>
        <form:errors path="name" cssClass="text-warning"/>
    </fieldset>

    <fieldset class="form-group">
        <form:label path="title">Title</form:label>
        <form:input path="title" type="text" class="form-control"
                    required="required"/>
        <form:errors path="title" cssClass="text-warning"/>
    </fieldset>

    <fieldset class="form-group">
        <form:label path="secureNumber">Security Code</form:label>
        <form:input path="secureNumber" type="text" class="form-control"
                    required="required"/>
        <form:errors path="secureNumber" cssClass="text-warning"/>
    </fieldset>

    <button type="submit" class="btn btn-success">Save</button>
</form:form>

<%@ include file="footer.jsp" %>