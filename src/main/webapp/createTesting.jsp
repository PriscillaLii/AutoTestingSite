<%@ include file="header.jspf" %> 
<script type="text/javascript" src="resources/js/myjs.js"></script>
<script>
window.onload = function() {
	setNavActive("createTesting");
}
</script>
<div class="container">
<div class="row">

<div class="col-4"></div>
<div class="col-4">
	<div style="align:center"><h4>${message}</h4></div>
	
    <form:form method="POST" action="${contextPath}/createTesting" modelAttribute="testingForm" class="form-signin" enctype="multipart/form-data">
        <span>Upload File:</span>
            <div class="form-group">
                <input type="file" name="file" class="form-control" placeholder="File Name" autofocus="true"></input>
            </div>

		<span>Testing Machine:</span>
            <div class="form-group">
	            <form:select class="browser-default custom-select form-control" path="machine" name="machine">
					<form:option value="iPhone 11">iPhone 11</form:option>
					<form:option value="Huawei P9">Huawei P9</form:option>
					<form:option value="Mate 20 Pro">Mate 20 Pro</form:option>
				</form:select>
            </div>

		<span>Operating System:</span>
            <div class="form-group">
            		<form:select class="browser-default custom-select form-control" path="os" name="machine">
					<form:option value="IOS 13">IOS 13</form:option>
					<form:option value="IOS 12">IOS 12</form:option>
					<form:option value="Android 8">Android 8</form:option>
				</form:select>
            </div>
            
        <span>App Package:</span>
            <div class="form-group">
                <form:input type="text" path="appPackage" class="form-control" placeholder="App Package"></form:input>
            </div>
            
        <span>App Activity:</span>
            <div class="form-group ">
                <form:input type="text" path="appActivity" class="form-control" placeholder="App Activity"></form:input>
            </div>
         
         <div>
        		<button class="btn btn-primary btn col-6" type="submit" style="width: 147px;">Submit</button>
        		<button type="reset" class="btn btn-secondary col-6" style="width: 147px;">Reset</button>
         </div>    
         
         <form:input type="hidden" path="userName" value="${pageContext.request.userPrincipal.name}"/> 	
    </form:form>

</div>
</div>
</div><!-- /container -->

<jsp:include page="footer.jsp"/>