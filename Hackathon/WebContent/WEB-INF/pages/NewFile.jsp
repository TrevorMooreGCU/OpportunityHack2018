<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>




<div class="form-horizontal" style="overflow-x:scroll;">

<table class="table">
		<thead>
			<tr>
				<td>View All DataSets:</td>
			</tr>
		</thead>


<c:forEach items="${tableNames}" var="table" varStatus="status">

		<tbody>

				<tr>
				<td>${table.tableName}</td>
				<td><a href="<c:url value="/dynamic/getdataset?table=${table.tableName}" />" class="btn btn-default">View</a></td>
				<td><a href="<c:url value="/dynamic/analysis?table=${table.tableName}" />" class="btn btn-default">Analyze</a></td>
				<td><a href="<c:url value="/dynamic/displayInputForm?tableName=${table.tableName}" />" class="btn btn-default">Input</a></td>
				<td><a onclick="activateSpinner(this);" href="<c:url value="/export/downloadCSV?file=${table.tableName}" />" class="btn btn-default">Export</a></td>
				</tr>

			
		</tbody>
</c:forEach>
</table>

</div>


<script type="text/javascript">

function activateSpinner(input)
{
		
}

</script>
