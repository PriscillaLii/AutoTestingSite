<%@ include file="header.jspf" %> 

<div class="container">
<div class="row">
<div class="col-4"></div>
<div class="col-6">

${testingHistory[0].getId()}

</div>
</div>
</div><!-- /container -->
<script>
window.onload = function() {
	setNavActive("testingHistory");
}
</script>
<jsp:include page="footer.jsp"/>
