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

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
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
		<c:forEach var="error" items="${errors}">
			<h5 style="color:red" align="center"> ${error} </h5>
		</c:forEach>
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
						<img src="images/default-avatar.png" class="img-circle" width="30"></a>
					</p>
					<h5 class="centered">Marcel Newman</h5>
				</div>

				<ul class="nav">
					<li><a href="user.html"> <i class="pe-7s-user"></i>
							<p>Careteam Dashboard</p>
					</a></li>
					<li class="active"><a href="manageServices.do"> <i
							class="pe-7s-graph"></i>
							<p>Manage Services</p>
					</a></li>
					<li><a href="user.html"> <i class="pe-7s-user"></i>
							<p>Team Members</p>
					</a></li>
					<li><a href="table.html"> <i class="pe-7s-note2"></i>
							<p>Documents</p>
					</a></li>
					<li><a href="typography.html"> <i class="pe-7s-news-paper"></i>
							<p>Payment</p>
					</a></li>
					<li><a href="icons.html"> <i class="pe-7s-science"></i>
							<p>Education</p>
					</a></li>
					<li><a href="maps.html"> <i class="fa fa-heart"></i>
							<p>Loved One</p>
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

							<li><a href=""JSP/dashboard3.jsp""> My Dashboard </a></li>
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
								<div class="card">
									<div class="header">
										<h4 class="title">Active Services</h4>
										<p class="category">List of services active for this team </p>
										
									</div>
									<div class="content">
										<div class="nav3">

											<div class="photo">
												<style>
												.photo img {
												width: 100px;
												height: 100px;
												background-color: grey;
												}
												</style>
												<table>
													<tr>
													<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Housing')}">
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/senior-housing.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Senior Housing</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Senior Housing">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:when>
													
													</c:choose>
													
													<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Home')}">
														
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/in-home-care.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">In Home Care</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="In Home Care">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														</c:when>
														</c:choose>
														
														<c:choose>
														<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Vendor')}">
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/vendor-service.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Vendor Service</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Vendor Service">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														</c:when>
														</c:choose>
														
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'legal')}">
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/legal.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Legal</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Legal">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:when>
													
													</c:choose>
													
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'taxation')}">
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/taxation.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Taxation</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Taxation">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:when>
													
													</c:choose>
													
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'financial')}">
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/financial-planning.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Financial Planning</div>
														
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Financial Planning">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
										      			</td>
														</c:when>
													
													</c:choose>
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'insurance')}">
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/insurance.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Insurance</div>
														
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Insurance">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														</c:when>
													
													</c:choose>
													</tr>
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'estate')}">
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/estate-planning.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Estate Planning</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Estate Planning">															
										          				<input type="submit" name="directRemove" data-inline="true" value="Unsubscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:when>
													
													</c:choose>
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
								<div id="wide">
								<div class="col-md-6">
									<div class="card">
										<div class="header">
											<h4 class="title">Add Services</h4>
											<br>
											<form method="post" action="manageServices.do">
										        <div>
										          
										          
										          <input type="text" name="serviceToAdd" id="serviceToAdd" placeholder="Enter Service Name">
										          <input type="submit" name="removeAction" data-inline="true" value="Add">
										          <br>
										          <br>
										        </div>
										      </form>
											
											
										</div>
									</div>
								</div>
						 	</div>
						 	
						 	<div id="wide">
								<div class="col-md-6">
									<div class="card">
										<div class="header">
											<h4 class="title">Unsubscribe Services</h4>
											<br>
											<form method="post" action="manageServices.do">
										        <div>
										          
										          
										          <input type="text" name="serviceToDelete" id="serviceToDelete" placeholder="Enter Service Name">
										          <input type="submit" name="deleteAction" data-inline="true" value="Delete">
										          <br>
										          <br>
										        </div>
										      </form>
											
											
										</div>
									</div>
								</div>
						 	</div>
							</div>

														<div class="col-md-6">
								<div class="card">
									<div class="header">
										<h4 class="title">More Services</h4>
										<p class="category">List of other services you can subscribe to </p>
										
									</div>
									<div class="content">
										<div class="nav3">

											<div class="photo">
												<style>
												.photo img {
												width: 100px;
												height: 100px;
												background-color: grey;
												}
												</style>
												<table>
													<tr>
													<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Housing')}">
													</c:when>
													<c:otherwise>
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/senior-housing.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Senior Housing</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Senior Housing">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:otherwise>
													
													</c:choose>
													
													<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Home')}">
													</c:when>
													<c:otherwise>	
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/in-home-care.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">In Home Care</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="In Home Care">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														</c:otherwise>
														</c:choose>
														
														<c:choose>
														<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Vendor')}">
														</c:when>
													<c:otherwise>	
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/vendor-service.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Vendor Service</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Vendor Service">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														</c:otherwise>
														</c:choose>
														
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'legal')}">
													</c:when>
													<c:otherwise>	
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/legal.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Legal</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Legal">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:otherwise>
													
													</c:choose>
													</tr>
													<tr>
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'taxation')}">
													</c:when>
													<c:otherwise>	
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/taxation.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Taxation</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Taxation">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:otherwise>
													
													</c:choose>
													
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'financial')}">
													</c:when>
													<c:otherwise>	
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/financial-planning.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Financial Planning</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Financial Planning">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:otherwise>
													
													</c:choose>
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'insurance')}">
													</c:when>
													<c:otherwise>	
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/insurance.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Insurance</div>
														<form method="post" action="manageServices.do">
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Insurance">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:otherwise>
													
													</c:choose>
													
														<c:choose>
													<c:when test="${fn:containsIgnoreCase(subscribedServices, 'estate')}">
													</c:when>
													<c:otherwise>	
													
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ServiceIcons/estate-planning.png"
																width="160">
														</a>
														<br>
														<br>
														<div style = "text-align: center">Estate Planning</div>
														<form method="post" action="manageServices.do" >
														<br>
										        			<div style = "text-align: center">	
										        				<input type="hidden" name="service" value="Estate Planning">															
										          				<input type="submit" name="directAdd" data-inline="true" value="Subscribe" style = "border-radius: 10%">
										          				<br>
										         	 			<br>
										        			</div>
										      			</form>
														</td>
														
														</c:otherwise>
													
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
  
												
											</table>


										</div>
									</div>
								</div>
							</div>




						</div>



					</div>
				</div>
			</div>
		</div>



		<footer class="footer">
			<div class="container-fluid">
				<p class="copyright pull-right">
					&copy; 2017 <a href=#>Curantis Solution</a>
				</p>
			</div>
		</footer>

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
			message : "Welcome to <b>John Doe's</b> care team's dashboard"
		}, {
			type : 'info',
			timer : 4000
		});
	});
</script>

</html>