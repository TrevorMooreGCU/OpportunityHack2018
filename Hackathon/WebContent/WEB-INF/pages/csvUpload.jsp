

<form action="${pageContext.request.contextPath}/upload/uploadfile" method="POST" enctype="multipart/form-data">

<div class="form-horizontal">

<h2>Upload Data for Reporting</h2>

	<div class="input-group">
	    <label class="input-group-btn">
	        <span class="btn btn-primary">
	            Browse&hellip; <input type="file" id="file" name="file" style="display: none;" multiple>
	        </span>
	    </label>
	    <input type="text" class="form-control" readonly>
	</div>
	<span class="help-block">
	    File must be in comma delimited CSV format.
	</span>
	<br>
	
	<div class="input-group">
		<input type="submit" value="Upload" class="btn btn-default" />
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

