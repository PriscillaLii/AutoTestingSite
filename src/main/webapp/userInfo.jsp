<%@ include file="header.jspf" %> 

<div class="container">
<div class="row">
<div class="col-4"></div>
<div class="col-4">
	<h4>${message}</h4>

    <form:form method="POST" action="${contextPath}/userInfo" modelAttribute="userForm" class="form-signin">
        <span>User Name:</span>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="${pageContext.request.userPrincipal.name}"
                		value="${pageContext.request.userPrincipal.name}" autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>

		<span>Old Password:</span>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Old Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>

		<span>New Password:</span>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control" placeholder="New Password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>

        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
    </form:form>

</div>
</div>
</div><!-- /container -->
<script>
window.onload = function() {
	setNavActive("userInfo");
}
</script>
<jsp:include page="footer.jsp"/>
