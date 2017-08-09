<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Service Documents</title>

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
						<img src="images/default-avatar.png" class="img-circle" width="30">
					</p>
					<h5 class="centered"><a href="personalDashboard.do">Marcel Newman</a></h5>
				</div>
				<ul class="nav">
					<li ><a href="careteamDashboard.do"> <i class="pe-7s-graph"></i>
							<p>CareTeam Dashboard</p>
					</a></li>
					<li><a href="manageServices.do"> <i class="pe-7s-note"></i>
							<p>Manage Services</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-users"></i>
							<p>Team Members</p>
					</a></li>
					<li class="active"><a href="#"> <i class="pe-7s-note2"></i>
							<p>Documents</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-credit"></i>
							<p>Payment</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-science"></i>
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
		<div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h3 >Services Document List</h3>
                            </div>
                            
                              <div class="content all-icons">
                              <div class ="row">
                            

										<c:choose>
											<c:when
												test="${fn:containsIgnoreCase(subscribedServices, 'Housing')}">
												<div
													class="font-icon-list col-lg-2 col-md-3 col-sm-6 col-xs-6 col-xs-6">
													<div class="font-icon-detail">
														<i class="pe-7s-folder"></i>
														<p><a href="seniorHousingDoc.do">Senior Housing</a></p>
													</div>
												</div>
											</c:when>
										</c:choose>

										<c:choose>
											<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Ancillary')}">
												<div class="font-icon-list col-lg-2 col-md-3 col-sm-6 col-xs-6 col-xs-6">
													<div class="font-icon-detail">
														<i class="pe-7s-folder"></i>
														<p><a href="#">Ancillary Services</a></p>
													</div>
												</div>
											</c:when>
										</c:choose>

										<c:choose>
											<c:when test="${fn:containsIgnoreCase(subscribedServices, 'Vendor')}">
												<div class="font-icon-list col-lg-2 col-md-3 col-sm-6 col-xs-6 col-xs-6">
													<div class="font-icon-detail">
														<i class="pe-7s-folder"></i>
														<p><a href="#">Vendor Management</a></p>
													</div>
												</div>
											</c:when>
										</c:choose>
										
							 <div class="font-icon-list col-lg-2 col-md-3 col-sm-6 col-xs-6 col-xs-6">
                             <div class="font-icon-detail"><i class="pe-7s-folder"></i>
                               <p><a href="#">Others</a></p>
                             </div>
                          	 </div>

						</div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        </div>
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


</html>
