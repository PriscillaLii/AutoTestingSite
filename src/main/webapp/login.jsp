<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="head_common.jsp"/>

    <title>Log in with your account</title>

<jsp:include page="head_files.jsp"/>

<div class="container">
<div class="row">
<div class="col-4"></div>
<div class="col-4">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Sign-in page</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-primary btn-lg btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
    </form>

</div>
</div>
</div><!-- /container -->
<jsp:include page="footer.jsp"/>
