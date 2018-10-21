<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<!-- Will make a button for every table that user has created -->
			<!--
			<c:forEach items="${$tableNames}" var="tableName" varStatus="status">
				<c:choose>
					<c:when test="${$tableNames.size() > 0}">
					
					</c:when>
					<c:otherwise>
						<button type="button" class="btn" data-toggle="modal" data-target="#modalDiscount">Table</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			 -->
			 
			 <!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
			  Table Modal Test
			</button>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header" style="background-color:0,0,0,.6">
			        <h5 class="modal-title" id="exampleModalLabel">Table Title</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<button type="button" class="btn btn-primary" data-dismiss="modal">View Table</button>
			      	<button type="button" class="btn btn-primary" data-dismiss="modal">New Input</button>
			      	<button type="button" class="btn btn-primary" data-dismiss="modal">Report Data</button>
			      	<button type="button" class="btn btn-primary" data-dismiss="modal">Export Data</button>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			  
		</div>
		<div class="col-sm-8">
			<div class="container" id="viewTable">
			
				<table>
					<tr>
						<th>View Table</th>
					</tr>
				</table>
			
			</div>
			<div class="container" id="newInput">
				<table>
					<tr>
						<td>
							<input type="text" placeholder="New Input">
						</td>
					</tr>
				</table>
			</div>
			<div class="container" id="reportData">
				<table>
					<tr>
						<th>Report Data</th>
					</tr>
				</table>
			</div>
			<div class="container" id="exportData">
				<button>Export Data</button>
			</div>
		</div>
		<script>
			function showViewTable() {
			    var x = document.getElementById("viewTable");
			    if (x.style.display === "none") {
			        x.style.display = "block";			
			    } else {
			        x.style.display = "none";
			    }
			}
			function showNewInput() {
			    var x = document.getElementById("viewTable");
			    if (x.style.display === "none") {
			        x.style.display = "block";			
			    } else {
			        x.style.display = "none";
			    }
			}
			function showReportData() {
			    var x = document.getElementById("viewTable");
			    if (x.style.display === "none") {
			        x.style.display = "block";			
			    } else {
			        x.style.display = "none";
			    }
			}
			function showExportData() {
			    var x = document.getElementById("viewTable");
			    if (x.style.display === "none") {
			        x.style.display = "block";			
			    } else {
			        x.style.display = "none";
			    }
			}
		</script>
	</div>
</div>

