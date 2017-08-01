<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>


		<br></br>
		<c:forEach var="error" items="${errors}">
			<h5 style="color:red" align="center"> ${error} </h5>
		</c:forEach>
	<div class="container">
    <h3 class="well">Login Form</h3>
	<div class="col-lg-12 well">
	<div class="row">
				<form>
					<div class="col-sm-12">
							<div class="form-group">
								<label>Email Address</label>
								<input type="text" placeholder="Enter Email Address.." class="form-control">
							</div>
							<div class="form-group">
								<label>Password</label>
								<input type="password" placeholder="Enter Password.." class="form-control">
							</div>
								<input type="submit" name="action" class="btn btn-lg btn-info" value="Login" />			
					</div>
				    </form>
				</div>
	         </div>
	         </div>
	<jsp:include page="footer.jsp"/>