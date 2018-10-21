<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<style>
.loader {
  border: 8px solid #f3f3f3;
  border-radius: 100%;
  border-top: 8px solid #3498db;
  width: 30px;
  height: 30px;
  -webkit-animation: spin 2s ease-out infinite; /* Safari */
  animation: spin 2s ease-out infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>

<div class="form-horizontal" style="overflow-x:scroll;">

<table class="table">
		<thead>
			<tr>
				<td>View All DataSets: <div class="loader" id="spinner" style="display:none;"></div></td> 
			</tr>
		</thead>


<c:forEach items="${tableNames}" var="table" varStatus="status">

		<tbody>

				<tr>
				<td>${table.tableName}</td>
				<td><a href="<c:url value="/dynamic/getdataset?table=${table.tableName}" />" class="btn btn-default" onclick="showSpinner()">View</a></td>
				<td><a href="<c:url value="/dynamic/analysis?table=${table.tableName}" />" class="btn btn-default" onclick="showSpinner()">Analyze</a></td>
				<td><a href="<c:url value="/dynamic/displayInputForm?tableName=${table.tableName}" />" class="btn btn-default" onclick="showSpinner()">Input</a></td>
				<td><a href="<c:url value="/export/downloadCSV?file=${table.tableName}" />" class="btn btn-default" onclick="showSpinner()">Export</a></td>
				</tr>

			
		</tbody>
</c:forEach>
</table>

<script>
function showSpinner() {
    var x = document.getElementById("spinner");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
</script>

</div>
