<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form method="POST" action="loginuser" modelAttribute="login">

<div class="form-horizontal">
	<h2>Login</h2>
	<hr/>
	<br/>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="username">Username:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="username"></form:input>
    			<form:errors path="username" cssClass="errors"/>
			</div>
	</div>
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="password">Password:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" type="password" path="password"></form:input>
    			<form:errors path="password" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Login" class="btn btn-default" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>
	
</div>

</form:form>


