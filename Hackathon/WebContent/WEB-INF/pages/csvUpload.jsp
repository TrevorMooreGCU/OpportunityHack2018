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

<form action="${pageContext.request.contextPath}/upload/uploadfile" method="POST" enctype="multipart/form-data">

<div class="form-horizontal" style="overflow-x:scroll;">

<h2>Upload Data for Reporting</h2>

	<div class="input-group">
	    <label class="input-group-btn">
	        <span class="btn btn-primary">
	            Browse&hellip; <input type="file" name="file" id="file" style="display: none;" multiple>
	        </span>
	    </label>
	    <input type="text" class="form-control" readonly>
	</div>
	<span class="help-block">
	    File must be in comma delimited CSV format.
	</span>
	<br>
	
	<div class="input-group">
		<input type="submit" onClick="showSpinner()" value="Upload" class="btn btn-default" /><div class="loader" id="spinner" style="display:none;"></div>
	</div>
	
	
		<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>
	
</div>

</form>


<script>
$(function() {

	  // We can attach the `fileselect` event to all file inputs on the page
	  $(document).on('change', ':file', function() {
	    var input = $(this),
	        numFiles = input.get(0).files ? input.get(0).files.length : 1,
	        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
	    input.trigger('fileselect', [numFiles, label]);
	  });

	  // We can watch for our custom `fileselect` event like this
	  $(document).ready( function() {
	      $(':file').on('fileselect', function(event, numFiles, label) {

	          var input = $(this).parents('.input-group').find(':text'),
	              log = numFiles > 1 ? numFiles + ' files selected' : label;

	          if( input.length ) {
	              input.val(log);
	          } else {
	              if( log ) alert(log);
	          }

	      });
	  });
	  
	});

</script>

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

