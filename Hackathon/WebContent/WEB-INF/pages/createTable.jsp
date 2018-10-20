<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<form:form method="POST" action="adddataset" modelAttribute="table">

<div class="form-horizontal">
	<h2>Create a New DataSet</h2>
	<hr/>
	<br/>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="tableName">DataSet Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="tableName"></form:input>
    			<form:errors path="tableName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Create DataSet" class="btn btn-default" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>

</div>

</form:form>