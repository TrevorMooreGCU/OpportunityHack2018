<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>



<div class="containter">
<div class="form-horizontal table-responsive-sm" style="overflow-x:scroll;">
<h2>${tableTitle.tableName}</h2>

<table class="table">
		<thead>
			<tr>
				<c:forEach items="${columns}" var="column">
					<th>${column.columnName}</th>
				</c:forEach>
			</tr>
		</thead>


<c:forEach items="${datacolumns}" var="innerlist">

		<tbody>
				<tr>
				
				    <c:forEach items="${innerlist}" var="data">
				        <td>${data.columnData}</td>
				    </c:forEach>
				
				</tr>
		</tbody>
		
</c:forEach>

</table>
<a href="<c:url value="/export/downloadCSV?file=${tableTitle.tableName}" />" class="btn btn-default">Download ${tableTitle.tableName}.csv</a>
</div>
</div>
