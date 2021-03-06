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
					<c:choose>
						<c:when test="${curTab eq 'preference'}">
							<li class="active"><a href="manageSeniorHousing.do"> <i
									class="pe-7s-graph"></i>
									<p>My Preference</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="manageSeniorHousing.do"> <i
									class="pe-7s-graph"></i>
									<p>My Preference</p>
							</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${curTab eq 'housings'}">
							<li class="active"><a href="#"> <i
									class="pe-7s-graph"></i>
									<p>Housing List</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"> <i
									class="pe-7s-graph"></i>
									<p>Housing List</p>
							</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${curTab eq 'document'}">
							<li class="active"><a href="seniorHousingDoc.do"> <i
									class="pe-7s-graph"></i>
									<p>Document</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="seniorHousingDoc.do"> <i
									class="pe-7s-graph"></i>
									<p>Document</p>
							</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${curTab eq 'payment'}">
							<li class="active"><a href="#"> <i
									class="pe-7s-graph"></i>
									<p>Payment</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"> <i
									class="pe-7s-graph"></i>
									<p>Payment</p>
							</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${curTab eq 'education'}">
							<li class="active"><a href="#"> <i
									class="pe-7s-graph"></i>
									<p>Education</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"> <i
									class="pe-7s-graph"></i>
									<p>Education</p>
							</a></li>
						</c:otherwise>
					</c:choose>

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
							<li><a href="careteamDashboard.do"> Home </a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> Services &#9662; </a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Vendor Management</a></li>
									<li><a href="#">Senior Housing</a></li>
									<li><a href="#">Ancillary Services</a></li>
									<li><a href="#">Estate Management</a></li>
							</ul></li>
							<li><a href="personalDashboard.do"> My Dashboard </a></li>
							<li><a href="#"> <i class="fa fa-phone"></i>Concierge Services </a></li>
							<li><a href="#"> Log out </a></li>
						</ul>
					</div>
				</div>
			</nav>