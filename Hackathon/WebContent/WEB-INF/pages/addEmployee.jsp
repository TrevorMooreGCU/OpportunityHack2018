<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<form:form method="POST" action="addemployee" modelAttribute="employee">

<div class="form-horizontal" style="overflow-x:scroll;">
	<h2>Add a New Employee</h2>
	<hr/>
	<br/>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="firstName">First Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="firstName"></form:input>
    			<form:errors path="firstName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="lastName">Last Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="lastName"></form:input>
    			<form:errors path="lastName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="email">Email:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="email"></form:input>
    			<form:errors path="email" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="phone">Phone:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="phone"></form:input>
    			<form:errors path="phone" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="employeeid">Employee ID:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="employeeid"></form:input>
    			<form:errors path="employeeid" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="admin" for="adminoptions">Admin:</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="admin" id="adminoptions">
				    <option value="0">No</option>
				    <option value="1">Yes</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="active" for="activeoptions">Active:</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="active" id="activeoptions">
				    <option value="0">No</option>
				    <option value="1">Yes</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="terminated" for="terminatedoptions">Terminated:</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="terminated" id="terminatedoptions">
				    <option value="0">No</option>
				    <option value="1">Yes</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Add Employee" class="btn btn-default" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>

</div>

</form:form>

