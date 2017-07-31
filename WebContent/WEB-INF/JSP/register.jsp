<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>Hospitals - Bootstrap 3 Template</title>
		
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Google Web Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,100italic,300italic,400italic,500,500italic,700,700italic,900,900italic" rel="stylesheet" type="text/css">
		
		<!-- Template CSS Files  -->
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<link href="js/plugins/camera/css/camera.css" rel="stylesheet">
		<link href="js/plugins/magnific-popup/magnific-popup.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link href="css/responsive.css" rel="stylesheet">
		<link href="css/registration.css" rel="stylesheet">
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		<!-- Fav and touch icons -->
		
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/fav-144.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/fav-114.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/fav-72.png">
		<link rel="apple-touch-icon-precomposed" href="images/fav-57.png">
		<link rel="shortcut icon" href="images/fav.png">
		
	</head>
	<body>
	<!-- Header Starts -->
		<header class="main-header">
		<!-- Nested Container Starts -->
			<div class="container">
			<!-- Top Bar Starts -->
				<div class="top-bar hidden-sm hidden-xs">
					<div class="row">
						<div class="col-sm-4 col-xs-12">
							
						</div>
						<div class="col-sm-8 col-xs-12">
							<ul class="list-unstyled list-inline">
								<li><a href="mailto:care@yourhosptialsname.com">
									<i class="fa fa-envelope-o"></i>
									concierge@curantis.com
								</a></li>
								
								<li><i class="fa fa-phone"></i> Call Us: 1-800-123-4567</li>
								<li> <a href="#"><font color = "blue"><b>Login</b></font></a>
								</li>
								<li> <a href="#"><font color = "blue"><b>Register</b></font></a>
								</li>
								
							</ul>
						</div>
					</div>
				</div>
			<!-- Top Bar Ends -->
			<!-- Navbar Starts -->
				<nav id="nav" class="navbar navbar-default" role="navigation">
					<div class="container-fluid">
					<!-- Navbar Header Starts -->
						<div class="navbar-header">
						<!-- Collapse Button Starts -->
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>								
							</button>
						<!-- Collapse Button Ends -->
						<!-- Logo Starts -->
							<a href="index.html" class="navbar-brand">
								<i class="fa fa-wheelchair"></i>
								Curantis Solutions
							</a>
						<!-- Logo Ends -->
						</div>
					<!-- Navbar Header Ends -->
					<!-- Navbar Collapse Starts -->
						<div class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li class="active"><a href="index.html">Home</a></li>
								<li><a href="about.html">About</a></li>
								
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										Services
									</a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">Vendor Management</a></li>
										<li><a href="#">Senior Housing</a></li>
										<li><a href="#">Ancillary Services</a></li>
										<li><a href="#">Estate Management</a></li>
									</ul>
								</li>
								<li><a href="#">News</a></li>								
								<li><a href="#">Contact</a></li>
							</ul>
						</div>
					<!-- Navbar Collapse Ends -->
					</div>
				</nav>
			<!-- Navbar Ends -->
			</div>
		<!-- Nested Container Ends -->
		</header>
	<!-- Header Ends -->
		<br></br>
		<h3 class="main-heading1"><center>Register</center></h3>
		
		<c:forEach var="error" items="${errors}">
			<h5 style="color:red" align="center"> ${error} </h5>
		</c:forEach>
		<form action="register.do" method="POST">
		<script type= "text/javascript" src = "js/countries.js"></script>
		    <table align="center">
		        <tr>
		            <td style="font-size: large">Email Address:</td>
		            <td>
		                <input type="text" name="email" value="${form.email}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">Password:</td>
		            <td><input type="password" name="password" /></td>
		        </tr>
		        <tr>
		            <td style="font-size: large">Confirm Password:</td>
		            <td><input type="password" name="confirmPassword"/></td>
		        </tr>
		        <div>
		        <tr>
		            <td style="font-size: large">First Name:</td>
		            <td>
		                <input type="text" name="firstName" value="${form.firstName}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">Middle Name:</td>
		            <td>
		                <input type="text" name="middleName" value="${form.middleName}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">Last Name:</td>
		            <td>
		                <input type="text" name="lastName" value="${form.lastName}" autofocus />
		            </td>
		        </tr>
		        </div>
		        <tr>
		            <td style="font-size: large">Address Line 1:</td>
		            <td>
		                <input type="text" name="addressLine1" value="${form.addressLine1}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">Address Line 2:</td>
		            <td>
		                <input type="text" name="addressLine2" value="${form.addressLine2}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">Country:</td>
		            <td>
		                <select id="country" name ="country"></select>
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">State:</td>
		            <td>
		                <select name ="state" id ="state"></select>
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: large">City:</td>
		            <td>
		                
		                <input type="text" name="city" value="${form.city}" autofocus />
		            </td>
		        </tr>
		        
		        <tr>
		            <td style="font-size: large">Zip Code:</td>
		            <td>
		                <input type="text" name="zip" value="${form.zip}" autofocus />
		            </td>
		        </tr>
		        
		        <tr>
		            <td colspan="2" align="center">
		                <input type="submit" name="action" class="btn btn-secondary" value="Register" />
		            </td>
		        </tr>
			</table>
		</form>
		<script language="javascript">
	populateCountries("country", "state");</script>
	<!-- Footer Starts -->
		<footer class="main-footer">
		<!-- Footer Area Starts -->
			<div class="footer-area">
			<!-- Nested Container Starts -->
				<div class="container">
					<div class="row">
					<!-- Hosptial Information Starts -->
						<div class="col-md-3 col-sm-4 col-xs-12">
							<h4>Company Information</h4>
							<p>
								We would be happy to help you with any help realted to eldercare. Please feel free to connect with us.
							</p>
							<ul class="list-unstyled address-list">
								<li class="clearfix address">
									<i class="fa fa-home"></i>
									5000 Forbes Ave, Pittsburgh, PA 15213
								</li>
								<li class="clearfix">
									<i class="fa fa-fax"></i>
									001 - 785 987 1234
								</li>
								<li class="clearfix">
									<i class="fa fa-phone"></i>
									001 - 123 478 5987
								</li>
								<li class="clearfix">
									<i class="fa fa-envelope"></i>
									<a href="mailto:info@yourhospitalsite.com">info@curantis_solutions.com</a>
								</li>
							</ul>
						</div>
					<!-- Hosptial Information Ends -->
					<!-- Services Starts -->
						
					<!-- Services Ends -->
					<!-- Twitter Starts -->
						<div class="col-md-3 col-sm-4 col-xs-12">
							<h4>Twitter</h4>
							<ul class="list-unstyled tweets-list">
								<li>
									<i class="fa fa-twitter"></i>
									Our Website Launched.
									<a href="#">http://t.co/xyz12abc</a>
								</li>
								<li>
									<i class="fa fa-twitter"></i>
									Our Twitter Page, please follow.
									<a href="#">http://t.co/testlink</a>
								</li>
								<li>
									<i class="fa fa-twitter"></i>
									Our Facebook Page, please like.
									<a href="#">http://t.co/abc123link</a>
								</li>
								<li>
									<i class="fa fa-twitter"></i>
									Our Broucher Launched.
									<a href="#">http://t.co/xyz-test1</a>
								</li>
							</ul>
						</div>
					<!-- Twitter Ends -->
					<!-- Signup Newsletter Starts -->
						<div class="col-md-4 col-xs-12 newsletter-block">
							<h4>Signup Newsletter</h4>
							<form action="#" class="newsletter">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Your Name">
								</div>
								<div class="form-group">
									<input type="email" class="form-control" placeholder="Enter your Email Address">
								</div>
								<button type="submit" class="btn btn-lg btn-block btn-secondary">Submit</button>
							</form>
						</div>
					<!-- Signup Newsletter Ends -->
					</div>
				</div>
			<!-- Nested Container Ends -->
			</div>
		<!-- Footer Area Ends -->
		<!-- Copyright Starts -->
			<div class="copyright">
				<div class="container clearfix">
					<p class="pull-left">
						&copy; Copyright 2015. AlL Rights Reserved By <span>Curantis Solutions</span>
					</p>
					<ul class="list-unstyled list-inline pull-right">
						<li><a href="#">Terms Of Services</a></li>
						<li><a href="#">Privacy</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
			</div>
		<!-- Copyright Ends -->
		</footer>
	<!-- Footer Ends -->
	<!-- Template JS Files -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/jquery-migrate-1.2.1.min.js"></script>	
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/camera/js/jquery.mobile.customized.min.js"></script>
	<script src="js/plugins/camera/js/jquery.easing.1.3.js"></script>
	<script src="js/plugins/camera/js/camera.min.js"></script>	
	<script src="js/plugins/shuffle/jquery.shuffle.modernizr.min.js"></script>
	<script src="js/plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js"></script>	
	<script src="js/custom.js"></script>	
	</body>
</html>