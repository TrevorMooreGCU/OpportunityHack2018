<style>

	#carouselButtons {
	    margin-left: 100px;
	    position: absolute;
	    bottom: 0px;
	}
	
	.image-height {
	
		
	}
	
	
	.carousel-height {
	
		height: 500px;
	}

</style>





<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="6000">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner carousel-height">
    <div class="item active">
      <img src="${pageContext.request.contextPath}/resources/images/image3.1.jpg" style="height: 100%;width:100%">
      <div class="carousel-caption">
      	<h1>Welcome to our Hackathon App!</h1>
          <p>The root for all your business needs.</p>
          <p><a class="btn btn-lg btn-primary" href="#">Learn More</a></p>
      </div>
    </div>
    <div class="item">
      <img src="${pageContext.request.contextPath}/resources/images/image1.1.jpg" style="height: 100%;width:100%">
      <div class="carousel-caption">
      	<h1>Explore!</h1>
          <p>Feel free to browse our app and enjoy all our content.</p>
          <p><a class="btn btn-large btn-primary" href="#">Learn more</a></p>
      </div>
    </div>
    <div class="item">
      <img src="${pageContext.request.contextPath}/resources/images/image2.1.jpg" style="height: 100%;width:100%">
      <div class="carousel-caption">
      	<h1>Sign Up and Get Started!</h1>
          <p>Register and login to get started!</p>
          <p><a class="btn btn-large btn-primary" href="#">Learn More</a></p>
      </div>
    </div>
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div> <!-- Carousel -->









<script>
	$('.carousel').carousel({
		interval: 3000
	})
</script>

    
    