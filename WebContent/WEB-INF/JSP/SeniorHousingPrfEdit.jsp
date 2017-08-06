<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="SeniorHousingTop.jsp"/>
<!-- *********Starts Here************ -->
			<div style="margin-left:50px; margin-right:50px">
				<h1>My Preferences</h1>
				<c:forEach var="error" items="${errors}">
					<div class="alert alert-warning">
					  <strong>${error}</strong>
					</div>
				</c:forEach>
				<form action="">
					<div class="form-group">
				    	<label for="email">Preferred Price:</label>
				    	<select class="form-control" name="price">
				    		<c:choose>
				    			<c:when test="${ form.price eq '0-100' }">
				    				<option selected>0-100</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>0-100</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.price eq '100-200' }">
				    				<option selected>100-200</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>100-200</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.price eq '200-300' }">
				    				<option selected>200-300</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>200-300</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.price eq '300-400' }">
				    				<option selected>300-400</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>300-400</option>
				    			</c:otherwise>
				    		</c:choose>
						</select>
				    	<!-- <input type="text" class="form-control" name="price"> -->
				    </div>
				    <div class="form-group">
				    	<label for="pwd">Preferred Location:</label>
				    	<select class="form-control" name="location">
				    		<c:choose>
				    			<c:when test="${ form.location eq 'Pittsburgh' }">
				    				<option selected>Pittsburgh</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>Pittsburgh</option>
				    			</c:otherwise>
				    		</c:choose>
				    		<c:choose>
				    			<c:when test="${ form.location eq 'Chicago' }">
				    				<option selected>Chicago</option>
				    			</c:when>
				    			<c:otherwise>
				    				<option>Chicago</option>
				    			</c:otherwise>
				    		</c:choose>
						</select>
				    	<!-- <input type="text" class="form-control" name="location"> -->
				    </div>
			    	<input type="submit" name="action" class="btn btn-info" value="Submit" />
			    	<input type="submit" name="action" class="btn btn-defualt pull-right" value="Cancel" />
				</form>
				<%-- <ul class="list-group">
				  <li class="list-group-item"><label>Price: </label><br>${ price }</li>
				  <li class="list-group-item"><label>Location: </label><br>${ location }</li>
				</ul>
				<form action="">
					<input type="hidden" name="price" value="${ price }">
					<input type="hidden" name="price" value="${ location }">
	  				<input type="submit" class="btn btn-info" value="EDIT">
				</form> --%>
			</div>
<!-- *********Ends Here************ -->
<jsp:include page="SeniorHousingBottom.jsp"/>