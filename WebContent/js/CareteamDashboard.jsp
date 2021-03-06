<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>CareTeam Dashboard</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <p class="centered"><img src="images/default-avatar.png" class="img-circle" width="30"></a></p>
              	  <h5 class="centered">Marcel Newman</h5>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="dashboard.html">
                        <i class="pe-7s-graph"></i>
                        <p>CareTeam Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="user.html">
                        <i class="pe-7s-user"></i>
                        <p>Team Members</p>
                    </a>
                </li>
                <li>
                    <a href="table.html">
                        <i class="pe-7s-note2"></i>
                        <p>Documents</p>
                    </a>
                </li>
                <li>
                    <a href="typography.html">
                        <i class="pe-7s-news-paper"></i>
                        <p>Payment</p>
                    </a>
                </li>
                <li>
                    <a href="icons.html">
                        <i class="pe-7s-science"></i>
                        <p>Education</p>
                    </a>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="fa fa-heart"></i>
                        <p>Loved One</p>
                    </a>
                </li>
                
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
                            </a>
                        </li>
                        
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                               Home
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
                            <a href=""JSP/dashboard3.jsp"">
                                My Dashboard
                            </a>
                        </li>
                         <li>
                            <a href="#">
                                <i class="fa fa-phone"></i>Concierge Services
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Log out
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
        <div id = "parent">
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
  <img src="images/lovedone.jpg" alt="John" style="width:100%">
  <div class="container">
    <h1>John Doe</h1>
    <p>Address: 5000 Forbes Avenue</p>
    <p>Relationship: Father</p>
    <p>Georelationship: Pittsburgh, PA</p>
    <p>Trigger Event: Heart Attack</p>
   <p><button>Edit Information</button></p>
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
                                <p class="category">The team members of this caregiver circle are:</p>
                            </div>
                            <div class="content">
                                <table>
    <tr>
        <td style="padding-right: 15px">
            <img src="images/default-avatar.png" alt="" width="30" />
        </td>
        <td style="padding-right: 15px">Jane Smith</td>
        <td style="padding-right: 15px"> janesmith@gmail.com </td>
        <td style="padding-right: 15px"> 4126261234 </td>
    </tr>
    <tr>
        <td>
            <img src="images/default-avatar.png" alt="" width="30" />
        </td>
        <td style="padding-right: 15px">John Smith</td>
        <td style="padding-right: 15px"> johnsmith@gmail.com </td>
        <td style="padding-right: 15px"> 4126261243 </td>
    </tr>
    <tr>
        <td>
            <img src="images/default-avatar.png" alt="" width="30" />
        </td>
        <td style="padding-right: 15px">Troy Smith</td>
        <td style="padding-right: 15px"> troysmith@gmail.com </td>
        <td style="padding-right: px"> 4126264321 </td>
        <td style="padding-right: 15px"> (Primary caregiver) </td>
    </tr>
    <tr>
        <td>
            <img src="images/default-avatar.png" alt="" width="30" />
        </td>
        <td style="padding-right: 15px">Joy Smith</td>
        <td style="padding-right: 15px"> joy@gmail.com </td>
        <td style="padding-right: 15px"> 3124563232 </td>
    </tr>
</table>
                            </div>
                        </div>
                    </div>
                    </div>


 
                   
                   
                    <div class="col-md-6">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Active Services</h4>
                                <p class="category">List of services active for this circle</p>
                            </div>
                            <div class="content">
                            <div class= "nav3">
                            <a href="https://www.google.com" class="icons"><img src="images/vendor_mgmt.png" width="160"></a>
          
                            <a href="https://www.google.com" class="icons"><img src="images/ancillary.png" width="160"></a>
                            
                            <a href="https://www.google.com" class="icons"><img src="images/Housingservices.png" width="160" height="162"></a>
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
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

	<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'pe-7s-gift',
            	message: "Welcome to <b>John Doe's</b> care team's dashboard"

            },{
                type: 'info',
                timer: 4000
            });

    	});
	</script>

</html>
