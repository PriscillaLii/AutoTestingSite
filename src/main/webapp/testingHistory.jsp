<%@ include file="header.jspf" %> 
<script type="text/javascript" src="resources/js/myjs.js"></script>
<script>
window.onload = function() {
	setNavActive("testingHistory");
}
</script>

<div class="container">
<div class="row">
<div class="col-12">

	<c:if test="${not empty testingHistory}">
	
		<table class="table">
		  	<thead>
			    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Date</th>
				      <th scope="col">File Name</th>
				      <th scope="col">Machine</th>
				      <th scope="col">Operating System</th>
				      <th scope="col">Result</th>
			    </tr>
		  	</thead>
		  	
		  	<c:forEach var="testing" items="${testingHistory}">
			  	<tbody>
			  		<tr>
			  			<th scope="row">${testing.getId()}</th>
			  			<td>${testing.getDate()}</td>
			  			<td>${testing.getFileName()}</td>
			  			<td>${testing.getMachine()}</td>
			  			<td>${testing.getOs()}</td>
			  			<td>${testing.getResult()}</td>
			  		</tr>
			  	</tbody>
			</c:forEach>
		  	
		</table>
	</c:if>

</div>
</div>
</div><!-- /container -->


<jsp:include page="footer.jsp"/>
