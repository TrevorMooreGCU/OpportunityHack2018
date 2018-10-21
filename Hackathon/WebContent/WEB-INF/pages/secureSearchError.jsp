<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="search">

<div class="form-horizontal" style="overflow-x:scroll;">

	<div class="form-group">
    		<div class="col-md-10">
    			<form:errors path="search" cssClass="errors"/>
			</div>
	</div>
	
</div>

</form:form>