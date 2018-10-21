<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<!-- Will make a button for every table that user has created -->
			
			<c:forEach items="${$tableNames}" var="tableName" varStatus="status">
				<c:choose>
					<c:when test="${$tableNames.size() > 0}">
					
					</c:when>
					<c:otherwise>
						<button type="button" class="btn" data-toggle="modal" data-target="#modalDiscount">Table</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>
</div>

<div class="modal-dialog modal-side modal-bottom-right modal-notify modal-danger" role="document">
  <!--Content-->
  <div class="modal-content">
    <!--Header-->
    <div class="modal-header">
      <p class="heading">Table Name</p>

      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true" class="white-text">&times;</span>
      </button>
    </div>

    <!--Body-->
    <div class="modal-body">

      <div class="row">
        <div class="col-3">
          <p></p>
          <p class="text-center">
            <i class="fa fa-gift fa-4x"></i>
          </p>
        </div>

        <div class="col-9">
        
        	<button type="button" class="viewTable">View Table</button>
			<button type="button" class="newInput">New Input</button>
			<button type="button" class="reprotData">Report Data</button>
			<button type="button" class="exportData">Export Data</button>
			
        </div>
      </div>
    </div>

    <!--Footer-->
    <div class="modal-footer flex-center">
      <a type="button" class="btn btn-outline-danger waves-effect" data-dismiss="modal">Close</a>
    </div>
  </div>
  <!--/.Content-->
</div>