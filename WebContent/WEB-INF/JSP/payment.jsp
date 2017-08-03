<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>
<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
<br></br>	
		<c:forEach var="error" items="${errors}">
			<h5 style="color:red" align="center"> ${error} </h5>
		</c:forEach>
<div class="container">
    <div class="row">
        <!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
        <div class="col-xs-12 col-md-6">
        
        
            <!-- CREDIT CARD FORM STARTS HERE -->
            <div class="panel panel-default credit-card-box">
                <div class="panel-heading display-table" >
                    <div class="row display-tr" >
                        <h5><b>Payment Details</b></h5>
                        <div class="display-td" >
                      
	                        	<ul>
	                        		<li style="list-style:none;">
								  		<input type="radio" name="paymentMethods" value="ccMethods" checked="checked"><img  src="http://i76.imgup.net/accepted_c22e0.png"><br>
								  		<input type="radio" name="paymentMethods" id="paypalButton" value="paypal"> <img src="images/Paypal.png" HEIGHT="35" WIDTH="35"><br>
								  		<!-- Modal content -->
								  		<div id="myModal" class="modal">
											  <div class="modal-content">
											    <span class="close">&times;</span>
											    <p><b>Click Continue to PayPal to log in and confirm your purchase.</b></p>
											    <form action="https://www.paypal.com/signin?country.x=US&locale.x=en_US" > 
											  		<input type="submit" name="action" class="btn btn-lg btn-info" value="Continue to PayPal" />
												</form> 
											  </div>
								          </div>
								          <script>
											// Get the modal
											var modal = document.getElementById('myModal');
											
											// Get the button that opens the modal
											var btn = document.getElementById("paypalButton");
											
											// Get the <span> element that closes the modal
											var span = document.getElementsByClassName("close")[0];
											
											// When the user clicks the button, open the modal 
											btn.onclick = function() {
											    modal.style.display = "block";
											}
											
											// When the user clicks on <span> (x), close the modal
											span.onclick = function() {
											    modal.style.display = "none";
											}
											
											// When the user clicks anywhere outside of the modal, close it
											window.onclick = function(event) {
											    if (event.target == modal) {
											        modal.style.display = "none";
											    }
											}
											</script>
									</li>  
							     </ul>
                 
                        </div>
                    </div>                    
                </div>
                <div class="panel-body">
                    <form id="payment-form" method="POST">
                        <div class="row">
                        <div class="form-group">
							<div class="col-sm-4 form-group">
                                    <label for="FirstName">First Name</label>
                                    <input type="text" class="form-control" name="firstName" value="${form.firstName}" placeholder="First Name" />
                             </div>
                             <div class="col-sm-4 form-group">
                                    <label for="MiddleName">Middle Name</label>
                                    <input type="text" class="form-control" name="middleName" value="${form.middleName}" placeholder="Middle Name" />
                             </div>
                             <div class="col-sm-4 form-group">
                                    <label for="LastName">Last Name</label>
                                    <input type="text" class="form-control" name="lastName" value="${form.lastName}" placeholder="Last Name"/>
                             </div>
                        </div>                        
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="cardNumber">CARD TYPE</label>
                                    	<p>
				                        <select>
										  <option value="visa">VISA</option>
										  <option value="mastercard">MASTER CARD</option>
										  <option value="amex">AMERICAN EXPRESS</option>
										  <option value="discover">DISCOVER</option>
										</select>
										</p>
									</div>
								</div>
							</div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="cardNumber">CARD NUMBER</label>
                                    <div class="input-group">
                                        <input 
                                            type="text" name="cardNumber" value="${form.cardNumber}"
                                            class="form-control"
                                            placeholder="Valid Card Number"
                                            required autofocus 
                                        />
                                        <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                    </div>
                                </div>                            
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label for="cardExpiry">EXPIRATION DATE</label>
                                    <input 
                                        type="text" name="cardExpiry" value="${form.cardExpiry}" 
                                        class="form-control" 
                                        placeholder="MM / YY"
                                        required 
                                    />
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label for="cardCVC">CV CODE</label>
                                    <input 
                                        type="text" name="cardCVC" value="${form.cardCVC}" 
                                        class="form-control"
                                        placeholder="CVC"
                                        required
                                    />
                                </div>
                            </div>
                        </div>
                        <input type="submit" name="action" class="btn btn-lg btn-info" value="Subscribe" />
                    </form>
                </div>
            </div>            
            <!-- CREDIT CARD FORM ENDS HERE -->
            
            
        </div>            
         
    </div>
</div>
       <jsp:include page="footer.jsp"/>
        