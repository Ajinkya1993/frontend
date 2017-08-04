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

<!--  JavaScript for popup -->
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

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
					<li class="active"><a href="dashboard.html"> <i
							class="pe-7s-graph"></i>
							<p>CareTeam Dashboard</p>
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
													<h1>John Doe</h1>
													<p>Address: 5000 Forbes Avenue</p>
													<p>Relationship: Father</p>
													<p>Georelationship: Pittsburgh, PA</p>
													<p>Trigger Event: Heart Attack</p>
													<p>
														<button>Edit Information</button>
													</p>
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
												<tr>
													<td style="padding-right: 15px"><img
														src="images/default-avatar.png" alt="" width="30" /></td>
													<td style="padding-right: 15px">Jane Smith</td>
													<td style="padding-right: 15px">janesmith@gmail.com</td>
													<td style="padding-right: 15px">4126261234</td>
												</tr>
												<tr>
													<td><img src="images/default-avatar.png" alt=""
														width="30" /></td>
													<td style="padding-right: 15px">John Smith</td>
													<td style="padding-right: 15px">johnsmith@gmail.com</td>
													<td style="padding-right: 15px">4126261243</td>
												</tr>
												<tr>
													<td><img src="images/default-avatar.png" alt=""
														width="30" /></td>
													<td style="padding-right: 15px">Troy Smith *</td>
													<td style="padding-right: 15px">troysmith@gmail.com</td>
													<td style="padding-right: px">4126264321</td>
												</tr>
												<tr>
													<td><img src="images/default-avatar.png" alt=""
														width="30" /></td>
													<td style="padding-right: 15px">Joy Smith</td>
													<td style="padding-right: 15px">joy@gmail.com</td>
													<td style="padding-right: 15px">3124563232</td>
												</tr>
												<tr>* : Primary Caregiver &nbsp;&nbsp;</tr>

								<!--  input type="button" allign="right" value="Invite new member to this team" 
									   onclick='javascript:window.open("invite.do", "inviteWindow", 
									   "scrollbars=1,resizable=1,height=300,width=450");' title='Invite Popup'/ -->
  
 

											</table>
  <div data-role="main" class="ui-content">
    <a href="#myPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left" 
    	style="float:right">Invite a new member</a>

    <div data-role="popup" id="myPopup" class="ui-content" style="min-width:500px;right:400px;bottom:200px;">
      <form method="post" action="invite.do">
        <div>
          <h3>Invite a new member by email</h3>
          <label for="email" class="ui-hidden-accessible">Email:</label>
          <input type="text" name="emailToAdd" id="emailToAdd" placeholder="Enter Email...">
          <input type="submit" name="action" data-inline="true" value="Send Invitation">
        </div>
      </form>
    </div>
  </div>
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
												width: 135px;
												height: 150px;
												background-color: grey;
												}
												</style>
												<table>
													<tr>
														<td><a href="https://www.google.com" class="icons">
																<img src="images/ancillary.png"
																width="220">
														</a></td>
														<td><a href="https://www.google.com" >
																<img src="images/Housingservices.png"
																width="220">
														</a></td>
														<td><a href="https://www.google.com" class="icons">
																<img src="images/vendor_mgmt.png"
																width="220" height="100">
														</a></td>
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
		</div>



		<footer class="footer">
			<div class="container-fluid">
				<p class="copyright pull-right">
					&copy; 2017 <a href=#>Curantis Solution</a>
				</p>
			</div>
		</footer>
 <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                About
                            </a>
                        </li>
                        <li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										Services &#9662;
									</a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">Vendor Management</a></li>
										<li><a href="#">Senior Housing</a></li>
										<li><a href="#">Ancillary Services</a></li>
										<li><a href="#">Estate Management</a></li>
									</ul>
								</li>
                        
                        
                        <li>
                        
                        <li>
                            <a href="#">
                               SignOut
                            </a>
                        </li>
                    </ul>
                </nav>
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
