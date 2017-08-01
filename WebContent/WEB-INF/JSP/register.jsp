<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
		<br></br>	
		<c:forEach var="error" items="${errors}">
			<h5 style="color:red" align="center"> ${error} </h5>
		</c:forEach>
<div class="container">
    <h3 class="well">Registration Form</h3>
    <script type= "text/javascript" src = "js/countries.js"></script>
	<div class="col-lg-12 well">
	<div class="row">
				<form>
					<div class="col-sm-12">
					<div class="form-group">
								<label>Email Address</label>
								<input type="text" name="email" value="${form.email}" placeholder="Enter Email Address.." class="form-control">
							</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Password</label>
								<input type="password" name="password" placeholder="Enter Password.." class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Confirm Password</label>
								<input type="password" name="confirmPassword" placeholder="Re-enter Password.." class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								<input type="text" name="firstName" value="${form.firstName}" placeholder="Enter First Name.." class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<input type="text" name="lastName" value="${form.lastName}" placeholder="Enter Last Name.." class="form-control">
							</div>
						</div>					
						<div class="form-group">
							<label>Address</label>
							<input type="text" name="address" value="${form.address}" placeholder="Enter Address.." class="form-control">
						</div>
						<div class="form-group">
							<label>Phone Number</label>
							<input type="text" name="phoneNumber" value="${form.phoneNumber}" placeholder="Enter Phone Number Here.." class="form-control">
					    </div>	
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>City</label>
								<input type="text" name="city" value="${form.city}" placeholder="Enter City Name.." class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Zip Code</label>
								<input type="text" name="zip" value="${form.zip}" placeholder="Enter Zip Code.." class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Country</label>
								<select id="country" name ="country" class="form-control"></select>
							</div>
							<div class="col-sm-6 form-group">
								<label>State</label>
								<select id="state" name ="state" class="form-control"></select>
							</div>
						</div>						
							<input type="submit" name="action" class="btn btn-lg btn-info" value="Register" />
										
					</div>
				</form>
				<script language="javascript">
	populateCountries("country", "state");</script> 
				</div>
				</div>
			</div>
	<jsp:include page="footer.jsp"/>