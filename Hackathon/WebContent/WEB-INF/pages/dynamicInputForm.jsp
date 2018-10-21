<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>


<div class="form-horizontal" style="overflow-x:scroll;">

<form:form method="POST" action="${pageContext.request.contextPath}/dynamic/addinput" modelAttribute="wrapper">
<table class="table">
		<thead>
			<tr>
				<c:forEach items="${headModels}" var="headModel" varStatus="status">
					<th>${headModel.columnName}</th>
				</c:forEach>

			</tr>

		</thead>

	<tbody>
		<c:forEach items="${wrapper.columnDataModels}" var="columnDataModel" varStatus="status">

			<td>
				<form:input cssClass="form-control text-body" path="columnDataModels[${status.index}].columnData"/>
			</td>

		</c:forEach>

	</tbody>
</table>
	<div class="form-group">
		<div class="col-md-10">
			<input type="submit" value="Create" class="btn btn-default" />
		</div>
	</div>
	
	
	
	<form:hidden path="tableName" value="${tableName}" />
	
</form:form>
</div>



