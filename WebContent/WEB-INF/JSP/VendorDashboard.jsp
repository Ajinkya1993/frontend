<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Vendor Dashboard</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<link href="js/plugins/camera/css/camera.css" rel="stylesheet">
		<link href="js/plugins/magnific-popup/magnific-popup.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link href="css/responsive.css" rel="stylesheet"> 
		<link href="css/PersonalDashboard.css" rel="stylesheet">   

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
    <div class="sidebar" data-color="blue" data-image="assets/img/sidebar-5.jpg">

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
                    <a href="vendorDashboard.do">
                        <i class="pe-7s-graph"></i>
                        <p>Vendor Dashboard</p>
                    </a>
                </li>
            
                <li><a href="manageServices.do"> <i class="pe-7s-graph"></i>
							<p>Manage Services</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-user"></i>
							<p>Team Members</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-note2"></i>
							<p>Documents</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-news-paper"></i>
							<p>Payment</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-science"></i>
							<p>Education</p>
					</a></li>
					<li><a href="#"> <i class="fa fa-heart"></i>
							<p>Loved One</p>
					</a></li>
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
                           <a href="welcome.do">
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
                        
                            <a href="personalDashboard.do">
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
                
                
                <div class="col-md-20 col-sm-18 col-xs-12" style="width: 100%;margin-right:2%;">
                <div class="notification-boxes row">
					<div class="box">
						<a href><img src="images/circle-of-people.png" alt="Create Circle" height="70" width="70"></a>
					
						<h4><a href="addVendor.do">Add Vendor</a></h4>
						<p>
							You can add a vendor and keep track of your expenses, be notified about upcoming payments and have a one stop for all your vendors information.
						</p>
					
						<a href="#" class="btn btn-primary-outline" style="color:white">Read More</a>
					</div>
				</div>
				</div>
				
				
                <div class="col-md-8" style="width:30%;";margin-right:5%;">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Your Vendors</h4>
                            </div>
                            <div class="content">
                                <table>
                                <c:choose>
    <c:when test="${!empty errors}">
    <tr>
    <td style="padding-right: 30px; color:red; style:italic;"> You have no vendors at present.
    Please add a vendor!</td>
    </tr>
    </c:when>
    <c:otherwise>
    
    <c:forEach items="${vendorName}" var="element">  
    <tr>
        <td style="padding-right: 15px">
            <img src="images/default-avatar.png" alt="" width="30" />
        </td>
        <td style="padding-right: 30px"><a href="vendorInfo.do?vnm=${element}" onclick="callMe('${element}')"><c:out value="${element}"/> </a></td>
   <script>
   function callMe(myId) {
	   var jsAtt = '${maps}';
	   var jsnew = JSON.parse(jsAtt);
	   var cicid = jsnew[String(myId)];
       }
   </script>
    </tr>
   </c:forEach>
        
    </c:otherwise>
     </c:choose>

</table>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                    
                <div class="col-md-8" style="left;">
                        <div class="notification-boxes row">
					<div class="box">
						<a href><img src="images/circle-of-people.png" alt="View Expenses" height="70" width="70"></a>
						<h4><a href="addVendor.do">View expenses</a></h4>
						<p>
							You can view your expenses for all the vendors or view the expense for a particular vendor in a particular month.
						</p>
					
						<a href="#" class="btn btn-primary-outline" style="color:white">Read More</a>
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
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

	
</html>
