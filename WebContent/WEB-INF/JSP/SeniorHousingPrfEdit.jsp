<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Create CareTeam</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="js/plugins/camera/css/camera.css" rel="stylesheet">
<link href="js/plugins/magnific-popup/magnific-popup.css"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="css/PersonalDashboard.css" rel="stylesheet">

<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="assets/css/demo.css" rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

<!--   Core JS Files   -->
<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

<c:if test="${noPreference}">
	<script type="text/javascript">
			$(window).load(function(){        
		   		$('#myModal').modal('show');
		    });
	</script>
</c:if>
</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="blue"
			data-image="assets/img/sidebar-5.jpg">
			<!--
			Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
			Tip 2: you can also add an image using data-image tag -->
			<div class="sidebar-wrapper">
				<div class="logo">
					<p class="centered">
						<img src="images/default-avatar.png" class="img-circle" width="30"></a>
					</p>
					<h5 class="centered">Marcel Newman</h5>
				</div>
				<ul class="nav">
					<li class="active"><a href="personalDashboard.do"> <i
							class="pe-7s-graph"></i>
							<p>My Preference</p>
					</a></li>
					<li><a href="user.html"> <i class="pe-7s-user"></i>
							<p>Housing List</p>
					</a></li>
					<li><a href="table.html"> <i class="pe-7s-note2"></i>
							<p>Document</p>
					</a></li>
					<li><a href="typography.html"> <i class="pe-7s-news-paper"></i>
							<p>Payment</p>
					</a></li>
					<li><a href="icons.html"> <i class="pe-7s-science"></i>
							<p>Education</p>
					</a></li>

				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navigation-example-2">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Dashboard</a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-dashboard"></i>
							</a></li>

						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li><a href=""> Home </a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> Services &#9662; </a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Vendor Management</a></li>
									<li><a href="#">Senior Housing</a></li>
									<li><a href="#">Ancillary Services</a></li>
									<li><a href="#">Estate Management</a></li>
							</ul></li>
							<li><a href="#"> My Dashboard </a></li>
							<li><a href="#"> <i class="fa fa-phone"></i>Concierge Services </a></li>
							<li><a href="#"> Log out </a></li>
						</ul>
					</div>
				</div>
			</nav>



<!-- *********Starts Here************ -->
			<div style="margin-left:50px; margin-right:50px">
				<h1>My Preferences</h1>
				<c:forEach var="error" items="${errors}">
					<div class="alert alert-warning">
					  <strong>${error}</strong>
					</div>
				</c:forEach>
				<form action="">
					<div class="form-group">
				    	<label for="email">Preferred Price:</label>
				    	<select class="form-control" name="price">
				    		<c:choose>
				    			<c:when test="${ form.price eq '0-100' }">
				    				<option selected>0-100</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>0-100</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.price eq '100-200' }">
				    				<option selected>100-200</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>100-200</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.price eq '200-300' }">
				    				<option selected>200-300</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>200-300</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.price eq '300-400' }">
				    				<option selected>300-400</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>300-400</option>
				    			</c:otherwise>
				    		</c:choose>
						</select>
				    	<!-- <input type="text" class="form-control" name="price"> -->
				    </div>
				    <div class="form-group">
				    	<label for="pwd">Preferred Location:</label>
				    	<select class="form-control" name="location">
				    		<c:choose>
				    			<c:when test="${ form.location eq 'Pittsburgh' }">
				    				<option selected>Pittsburgh</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>Pittsburgh</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.location eq 'Chicago' }">
				    				<option selected>Chicago</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>Chicago</option>
				    			</c:otherwise>
				    		</c:choose>
						</select>
				    	<!-- <input type="text" class="form-control" name="location"> -->
				    </div>
			    	<input type="submit" name="action" class="btn btn-info" value="Submit" />
			    	<input type="submit" name="action" class="btn btn-defualt pull-right" value="Cancel" />
				</form>
				<%-- <ul class="list-group">
				  <li class="list-group-item"><label>Price: </label><br>${ price }</li>
				  <li class="list-group-item"><label>Location: </label><br>${ location }</li>
				</ul>
				<form action="">
					<input type="hidden" name="price" value="${ price }">
					<input type="hidden" name="price" value="${ location }">
	  				<input type="submit" class="btn btn-info" value="EDIT">
				</form> --%>
			</div>
		</div>
	</div>
<!-- *********Ends Here************ -->




</body>
</html>