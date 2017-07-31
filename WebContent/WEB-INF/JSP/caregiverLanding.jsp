<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
		<div class="main-banner one">
			<div class="container">
				<h2><span>Our Offers</span></h2>
			</div>
		</div>
	<!-- Main Banner Ends -->
	<!-- Breadcrumb Starts -->
		<div class="breadcrumb">
			<div class="container">
				<ul class="list-unstyled list-inline">
					<li><a href="welcome.do">Home</a></li>
					<li class="active">Our Offers</li>
				</ul>
			</div>
		</div>
	<!-- Main Container Starts -->
		<div class="container main-container">
		<!-- Medical Services Section Ends -->
		<!-- Content Starts -->
		<!-- Book Appointment Box Starts -->
			<section class="welcome-area about">
				<div class="row">
					<div class="col-md-6 col-xs-12 about-col">
						<h3 class="main-heading1">Welcome to CURANTIS</h3>
						<h3 class="main-heading2">
							What You Need &amp; Can Do with CURANTIS
						</h3>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut volutpat rutrum eros amet sollicitudin interdum. Suspendisse pulvinar, velit nec pharetra interdum, ante tellus ornare mi, et mollis tellus neque vitae elit. Mauris adipiscing mauris fringilla turpis interdum sed pulvinar nisi malesuada. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						</p>
						<p>
							Donec sed odio dui. Nulla vitae elit libero, a pharetra augue. Nullam id dolor id nibh ultricies vehicula ut id elit. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Duis mollis, est non commodo luctus, nisi erat porttitor ligula. Mauris sit amet neque nec nunc gravida. 
						</p>
						<div class="row">
							<div class="col-sm-6 col-xs-12">
								<ul class="list-unstyled list-style-3">
									<li><a href="#">Senior Housing</a></li>
									<li><a href="#">Vendor Management</a></li>
								</ul>
							</div>
							<div class="col-sm-6 col-xs-12">
								<ul class="list-unstyled list-style-3">
									<li><a href="#">Ancillary Service</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xs-12 hidden-sm hidden-xs">
					</div>
				</div>
			</section>
		</div>
		<section class="footer-top-bar">
			<div class="contact-content">
				<div class="row">
				<!-- Contact Form Starts -->
					<div class="col-sm-1 col-xs-12"></div>
					<div class="col-sm-10 col-xs-12">
						<h3>Get Your Customized Caregivning Guide by Registering Now</h3>
						<div class="status alert alert-success contact-status"></div>
						<form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="sendemail.php" role="form">
							<div class="row">
							<!-- Message Field Starts -->
								<div class="col-xs-12">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">I need a comprehensive guide to the Caregiving process</label>
									</div>
								</div>
								<div class="col-xs-12">
									<label>Instead, I'd like to design my plan around specific Caregiving activities</label>
								</div>
							<!-- Message Field Ends -->
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Senior Housing</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">In-home Care</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Vendor Management</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Legal</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Estate Planning</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Taxation</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Financial Planning</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="checkbox-inline"><input type="checkbox" value="">Insurance</label>
									</div>
								</div>
								<div class="container clearfix text-center-sm text-center-xs col-md-12">
									<input type="text" class="input-lg pull-left" size="65" placeholder="Email Address">
								</div>
								<div class="container clearfix text-center-sm text-center-xs col-md-12">
									<input type="submit" class="btn btn-black text-uppercase pull-right" value="Register">
								</div>
							</div>
						</form>
					</div>
				<!-- Contact Form Ends -->
				</div>
			</div>
		</section>
	<!-- Main Container Ends -->
<jsp:include page="footer.jsp"/>