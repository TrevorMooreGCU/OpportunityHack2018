<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*"%>

<style>


td {

	border: none !important;
}
.table-sbs {
	display: inline-block;
	width: 200px;
	margin-left: auto;
	margin-right: auto;
}

tr {
	height: 60px !important;
	border: 0;
}

tbody {

}

.table-container {
	width: 100%;
	height: 100%;
	text-align: center;
}

.form-horizontal {
	
}
</style>




	<div class="form-horizontal" style="overflow-x: scroll;">


		<form:form method="POST"
			action="${pageContext.request.contextPath}/dynamic/addinput"
			modelAttribute="wrapper">


			<div class="table-container">
				<h2>${tableName}</h2>
				<br>
				<table class="table table-sbs">
					<tbody>

						<c:forEach items="${headModels}" var="headModel"
							varStatus="status">
							<tr>
								<td>${headModel.columnName}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<table class="table table-sbs">


					<tbody>

						<c:forEach items="${wrapper.columnDataModels}"
							var="columnDataModel" varStatus="status">

							<tr>
								<td><form:input cssClass="form-control text-body"
										path="columnDataModels[${status.index}].columnData" /></td>
							</tr>

						</c:forEach>


					</tbody>
				</table>
				<br>
						<input type="submit" value="Create" class="btn btn-default"
							style="width: 50%; margin-bottom: 50px;" />

			</div>


			<form:hidden path="tableName" value="${tableName}" />

		</form:form>
	</div>