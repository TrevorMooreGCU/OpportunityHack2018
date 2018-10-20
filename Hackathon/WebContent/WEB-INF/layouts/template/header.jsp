<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/resources/Site.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet" type="text/css" id="bootstrap-css"/>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<body>
	<nav class="navbar navbar-default navbar-inverse" role="navigation" style="padding: 0px; left: 0; top: 0; width: 100%; position:absolute; border-radius: 0;">
		<div class="container-fluid">
		
		
		
		
		
			<!-- Brand and toggle get grouped for better mobile display (responsive hamburger) -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<img src="<c:url value="/resources/images/logo.png" />" width="120" height="40" align="left" style="margin-top: 3px; padding-left: 5px" class="logo" />
			</div>
			<!-- end responsive hamburger -->
			
			
			
			<!-- id="bs-example-navbar-collapse-1" -->
			<!-- Everything inside this will be collapsed into hamburger if resized (responsive) -->
			<div class="navbar-collapse collapse" >
				<ul class="nav navbar-nav">

					<!-- Link to the home page -->
					<li><a href="<c:url value="/" />">Home</a></li>

				</ul>
				
				

				<!--Search form start -->
				<!-- 
				<form:form method="POST" action="${pageContext.request.contextPath}/search/usersearch" modelAttribute="search" class="navbar-form navbar-left" role="search">
				    <div class="form-group">
				        <form:input type="text" class="form-control" placeholder="Search" path="search"></form:input>
				    </div>
				    <input type="submit" value="Search" class="btn btn-default" />
				</form:form>
				-->
				<!--Search form end -->

				




				<!--the right side of the navbar -->
				<ul class="nav navbar-nav navbar-right">
					<!-- Register link start -->
					<li><a href="<c:url value="/register/" />"><b>Register</b> <span class="glyphicon glyphicon-user"></span></a></li>
					<!-- register link end -->
					
					<!--Login form start-->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="glyphicon glyphicon-log-in"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">

										<!-- The actual login form: -->
										<form:form method="POST" action="${pageContext.request.contextPath}/login/loginuser" modelAttribute="login" class="form-inline">

										<div>

											<h4 style="color: #000000">Login</h4>
											<hr />
											<div class="form-group">
												<div class="col-md-12">
													<form:input path="username" class="form-control mr-sm-2" value="trevomoo@gmail.com" placeholder="Username" aria-label="Username"/>
													<form:errors path="username" cssClass="errors"/>
												</div>
											</div>

											<div class="form-group">
												<div class="col-md-12">
													<form:input path="password" type="password" class="form-control mr-sm-2" value="$Shanklin86" placeholder="Password" aria-label="Password"/>
													<form:errors path="password" cssClass="errors"/>
												</div>
											</div>

											<div class="form-group">
												<div class="col-md col-md-12">
													<input type="submit" id="btnLogin" value="Login" class="btn btn-primary" />
												</div>
											</div>

										</div>
										</form:form>
										<!-- end actual login form -->
										</div>

									<div class="bottom text-center" style="color: #000000">
										Don't have an account?
										<br/>
										<!-- Link to the register page -->
										<a href="<c:url value="/register/" />"><b style="color: #0951a0">Sign Up Here</b></a>
									</div>
								</div>
							</li>
						</ul>
					</li><!-- login form end -->
				</ul>
				
				
				
				
			</div><!-- navbar-collapse end -->
			
			
			
			
		</div><!-- container-fluid end -->
		
		
		
		
	</nav><!-- navbar end -->

</body>


<br/>
<br/>
<br/>
<br/>