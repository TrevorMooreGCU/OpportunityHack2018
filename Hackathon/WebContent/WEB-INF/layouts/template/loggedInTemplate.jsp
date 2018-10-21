<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>


<style>

	.charts > div {
            width: 560px;
            height: 470px;
            padding: 0 15px;
            margin: 5px;
            border-radius: 10px;
            background-color: rgb(245, 245, 245);
            float: left;
        }

         .charts > div > button {
             margin-top: 15px;
         }

         .charts > div > div {
             margin: 15px 0;
         }

     h1, h2 {
         padding-left: 15px;
     }

	.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
		  background-color: #696969;
	}

	option {
	  	color: #000000;
	}

	.errors {
		color: #ff0000;
	}

	.navbar {
    position: relative;
	}
	
	.brand {
	    position: absolute;
	    display: block;
	}

	h4, .control-label {
		color: #fff
	}

	.form-horizontal {
		min-height: 70%;
		width: 100%;
		padding: 19px;
		position: relative;
		
		background: rgba(0, 0, 0, 0.6);
		margin-bottom: 80px;
		padding-bottom: 20px;
		border: 1px solid #464646;
		border-radius: 4px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	}

	*{
		color: #fff;
	
	}

	body {
		background: url("${pageContext.request.contextPath}/resources/images/background.jpg");
		padding: 50px;
		height: 100%;
		background-attachment: fixed;
		background-repeat: no-repeat;
		background-size: cover;
	}

	#login-dp{
		min-width: 250px;
		padding: 14px 14px 0;
		overflow:hidden;
		background-color:rgba(255,255,255,.8);
	}
	
	#login-dp .help-block{
		font-size:12px
	}
	#login-dp .bottom{
		background-color:rgba(255,255,255,.8);
		border-top:1px solid #ddd;
		clear:both;
		padding:14px;
	}
	#login-dp .social-buttons{
		margin:12px 0
	}
	#login-dp .social-buttons a{
		width: 49%;
	}
	#login-dp .form-group {
		margin-bottom: 10px;
	}
	.btn-fb{
		color: #fff;
		background-color:#3b5998;
	}
	.btn-fb:hover{
		color: #fff;
		background-color:#496ebc
	}
	.btn-tw{
		color: #fff;
		background-color:#55acee;
	}
	.btn-tw:hover{
		color: #fff;
		background-color:#59b5fa;
	}

</style>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Hackathon</title>
	<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>-->
<!--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
	
	<!-- This is where we define our open source resources, which we mapped in -->

	<!-- <link href="<c:url value="/WEB-INF/scripts/bootstrap.min.css" />" rel="stylesheet"> -->
	
	<script src="<c:url value="/resources/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/mdb.js" />"></script>
	<script src="<c:url value="/resources/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery-1.10.2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery.unobtrusive-ajax.js" />"></script>
	
	
	<!-- This was in the individual jsps -->
	<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
	<!-- Secure Header -->
	<tiles:insertAttribute name="secureHeader" />

	<!-- Body Page -->
	<div class="container body-content" style="padding-bottom: 100px">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Secure Footer -->
	<div class="footer" style="padding-top: 100px">
		<tiles:insertAttribute name="secureFooter" />
	</div>
</body>

</html>