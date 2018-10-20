<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/resources/Site.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet" type="text/css" id="bootstrap-css"/>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!-- 
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
-->
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
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<li><a href="<c:url value="/Home" />">Home</a></li>

					<%
						if(session != null && session.getAttribute("admin") != null){
					%>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<c:url value="/employee/employees" />">View Employees</a></li>
							<li><a href="<c:url value="/employee/addemployee" />">Add Employee</a></li>
						</ul>
					</li>
					<!-- dropdown option end -->
					<%
						}else{
					%>
					
					<%
						}
					%>
				</ul>
				
				

				<!--Search form start -->
				<!-- method="POST" action="search" -->
				<form:form method="POST" action="${pageContext.request.contextPath}/search/securesearch" modelAttribute="search" class="navbar-form navbar-left" role="search">
					<div class="input-group">
				        <form:input type="text" class="form-control" placeholder="Search" path="search"></form:input>
					    <span class="input-group-btn">
	                        <input type="submit" value="Search" class="btn btn-default" />
	                    </span>
				    </div>
				</form:form>
				<!--Search form end -->

				




				<!--the right side of the navbar -->
				<ul class="nav navbar-nav navbar-right">
					<!-- Logout link start -->
					<li><a href="<c:url value="/" />"><b>Logout</b> <span class="glyphicon glyphicon-log-out"></span></a></li>
					<!-- Logout link end -->
				</ul>
				
				
				
				
			</div><!-- navbar-collapse end -->
			
			
			
			
		</div><!-- container-fluid end -->
		
		
		
		
	</nav><!-- navbar end -->

</body>

<br/>
<br/>
<br/>
<br/>