<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>CareTeam Dashboard</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="blue"
			data-image="assets/img/sidebar-5.jpg">

			<!--
        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag
    -->

			<div class="sidebar-wrapper">
				<div class="logo">
					<p class="centered">
						<img src="images/default-avatar.png" class="img-circle" width="30">
					</p>
					<h5 class="centered"><a href="personalDashboard.do">Marcel Newman</a></h5>
				</div>
				<ul class="nav">
					<li class="active"><a href="careteamDashboard.do"> <i class="pe-7s-graph"></i>
							<p>CareTeam Dashboard</p>
					</a></li>
					<li><a href="manageServices.do"> <i class="pe-7s-note"></i>
							<p>Manage Services</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-users"></i>
							<p>Team Members</p>
					</a></li>
					<li><a href="ServiceDocList.do"> <i class="pe-7s-note2"></i>
							<p>Documents</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-credit"></i>
							<p>Payment</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-notebook"></i>
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
							<li><a href="index.jsp"> Home </a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> Services &#9662; </a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Vendor Management</a></li>
									<li><a href="#">Senior Housing</a></li>
									<li><a href="#">Ancillary Services</a></li>
									<li><a href="#">Estate Management</a></li>
								</ul></li>

							<li><a href="personalDashboard.do"> My Dashboard </a></li>
							<li><a href="#"> <i class="fa fa-phone"></i>Concierge
									Services
							</a></li>
							<li><a href="#"> Log out </a></li>
						</ul>
					</div>
				</div>
			</nav>


			<div class="content">
				<div id="parent">
					<div class="container-fluid">

						<div class="row">

							<div class="col-md-6">

								<div id="narrow">
									<div class="card">
										<div class="header">
											<h4 class="title">Loved One's Profile</h4>
										</div>
										<div class="content">
											<div class="card">
												<img src="images/lovedone.jpg" alt="John"
													style="width: 100%">
												<div class="container">
												
													<h1>${lovedone_firstName} &nbsp; ${lovedone_LastName}</h1>
													<p>Address: ${lovedoneaddr}</p>
													<p>Trigger Event: ${triggerEvent}</p>
													<c:choose>
													<c:when test="${primaryCaregiver == true}">
													<p>
														<button class="btn btn-info"><a href="updatelovedoneinfo.do">Edit Information</a></button>
													</p>
													</c:when>
													</c:choose>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>




							<div id="wide">
								<div class="col-md-6">
									<div class="card">
										<div class="header">
											<h4 class="title">Team Members</h4>
											<p class="category">The team members are:</p>
										</div>
										<div class="content">
											<table class="new">
<style>												
* {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}
table {
	border-collapse: separate;
	background: #fff;
}
tbody tr td {
	font-family: 'Open Sans', sans-serif;
	font-weight: 400;
	color: #5f6062;
	font-size: 13px;
	padding: 20px 20px 20px 20px;
	border-bottom: 1px solid #e0e0e0;
}
.new tbody tr:nth-child(2n) {
	background: #f0f3f5;
}
.new tbody tr:last-child td {
	border-bottom: none;
	&:
	first-child
	{
	@include
	border-bottom-left-radius(5px);
}
&
:last-child { @include border-bottom-right-radius(5px);
	
}
}
.new tbody:hover>tr:hover td { @include text-shadow(none);
	color: #2d2d2d;
	@
	include
	opacity(1.0);
}
</style>
<c:choose>
    <c:when test="${!empty errorsct}">
    <tr>
    <td style="padding-right: 30px; color:red; style:italic;"> No caregiver in this circle! Please create a circle!</td>
    </tr>
    </c:when>
    <c:otherwise>
        <c:forEach items="${careteammembers}" var="element">    
    <tr>
													<td style="padding-right: 15px"><img
														src="images/default-avatar.png" alt="" width="30" /></td>
														<c:set var="elemParts" value="${fn:split(element, '|')}" />
													<td style="padding-right: 15px">${elemParts[0]}</td>
													<td style="padding-right: 15px">${elemParts[1]}</td>
													<td style="padding-right: 15px">${elemParts[2]}</td>
												</tr>
												</c:forEach>
												</c:otherwise>
												</c:choose>
  
												<tr>* : Primary Caregiver</tr>
											</table>
										</div>
									</div>
								</div>
							</div>



							<div class="col-md-6">
								<div class="card">
									<div class="header">
										<h4 class="title">Active Services</h4>
										<p class="category">List of services active for this
											team</p>
									</div>
									<div class="content">
										<div class="nav3">

											<div class="photo">
												<style>
												.photo img {
												width: 140px;
												height: 140px;
												background-color: grey;
												}
												</style>
												<table>
													<tr>
													<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Housing')}">
													
														<td><a href="manageSeniorHousing.do" class="icons">
																<img src="images/ServiceIcons/senior-housing.png"
																width="160">
														</a>
														<div style = "text-align: center">Senior Housing</div>
														</td>
														</c:when>
													
													</c:choose>
													
													<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Ancillary')}">
														
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/in-home-care.png"
																width="160">
														</a>
														<div style = "text-align: center">In-Home Care</div>
														</td>
														</c:when>
														</c:choose>
														
														<c:choose>
														<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Vendor')}">
														<td><a href="vendorDashboard.do" class="icons">
																<img src="images/ServiceIcons/vendor-service.png"
																width="160">
														</a>
														<div style = "text-align: center">Vendor Management</div>
														</td>
														</c:when>
														</c:choose>
													</tr>
												</table>

											</div>
										</div>
									</div>
									<div class="footer">

										<hr>
										<div class="stats">
											<i class="fa fa-history"></i> Updated 3 minutes ago
										</div>
									</div>
								</div>
							</div>
						</div>



					</div>
				</div>
			</div>
			
			<jsp:include page="DashboardFooter.jsp"/>
			
		</div>
	</div>


</body>
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

<script type="text/javascript">
	$(document).ready(function() {
		demo.initChartist();
		$.notify({
			icon : 'pe-7s-gift',
			message : "Welcome to <b>${lovedone_firstName}  ${lovedone_LastName}</b> care team's dashboard"
		}, {
			type : 'info',
			timer : 4000
		});
	});
</script>

</html>