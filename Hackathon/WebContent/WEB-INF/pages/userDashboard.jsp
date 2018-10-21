<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<!-- Will make a button for every table that user has created-->
			<c:forEach items="${tableNames}" var="tableNames" varStatus="status">					
				<button type="button" class="btn" onclick="checkElements(this)" value="${tableNames.tableName}" style="background-color:#101010;color:#9d9d9d;">${tableNames.tableName}</button>
				<br>
				<br>
			</c:forEach>
			
		</div>
		<div class="col-sm-8">
		
		  	
		  	<div class="container" id="options" style="display:none;">
		  		<a href="<c:url value="/dynamic/getdataset?table=${tableNames.tableName}" />"><button type="button" class="btn btn-primary" onclick="showViewTable()" data-dismiss="modal">View Table</button></a>
		  		
		  		<button type="button" class="btn btn-primary" onclick="showNewInput()" data-dismiss="modal">New Input</button>
		  		
		  		<a href="<c:url value="/dynamic/analysis?table=${tableNames.tableName}" />"><button type="button" class="btn btn-primary" onclick="showReportData()" data-dismiss="modal">Report Data</button></a>
		  		
		  		<a href="<c:url value="/export/downloadCSV?file=${tableTitle.tableName}" />"><button type="button" class="btn btn-primary" onclick="showExportData()" data-dismiss="modal">Export Data</button></a>                                                                                                                          
		  	</div>
		
			<div class="container" id="viewTable" style="display:none;">
			
				<table>
					<tr>
						<th>View Table</th>
					</tr>
				</table>
			
			</div>
			<div class="container" id="newInput" style="display:none;">
				<table>
					<tr>
						<td>
							<input id="hidingboi" type="text" placeholder="">
						</td>
					</tr>
				</table>
			</div>
			<div class="container" id="reportData" style="display:none;">
				<table>
					<tr>
						<th>Report Data</th>
					</tr>
				</table>
			</div>
			<div class="container" id="exportData" style="display:none;">
				<button>Export Data</button>
			</div>
		</div>
		<script>
		
			var currentTable = '';
		
			function checkElements(elmnt) {
				var m = document.getElementById("options");
				var x = document.getElementById("viewTable");
				var y = document.getElementById("newInput");
				var z = document.getElementById("reportData");
				var a = document.getElementById("exportData");
				
				var h = document.getElementById("hidingboi");
				
				m.style.display = "block";
				x.style.display = "none";
				y.style.display = "none";
				z.style.display = "none";
				a.style.display = "none";
				
				currentTable = elmnt.value;
				
				h.placeholder = currentTable;
				
			}
			function showViewTable() {
			    var x = document.getElementById("viewTable");
			    var m = document.getElementById("options");
			    if (x.style.display === "none") {
			        x.style.display = "block";
			        m.style.display = "none";
			    } else {
			        x.style.display = "none";
			    }
			}
			function showNewInput() {
			    var x = document.getElementById("newInput");
			    var m = document.getElementById("options");
			    if (x.style.display === "none") {
			        x.style.display = "block";	
			        m.style.display = "none";
			    } else {
			        x.style.display = "none";
			    }
			}
			function showReportData() {
			    var x = document.getElementById("reportData");
			    var m = document.getElementById("options");
			    if (x.style.display === "none") {
			        x.style.display = "block";	
			        m.style.display = "none";
			    } else {
			        x.style.display = "none";
			    }
			}
			function showExportData() {
			    var x = document.getElementById("exportData");
			    var m = document.getElementById("options");
			    if (x.style.display === "none") {
			        x.style.display = "block";	
			        m.style.display = "none";
			    } else {
			        x.style.display = "none";
			    }
			}
		</script>
	</div>
</div>

