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
				<ul class="list-group">
				  <li class="list-group-item"><label>Price: </label><br>${ price }</li>
				  <li class="list-group-item"><label>Location: </label><br>${ location }</li>
				</ul>
				<form action="editSeniorHousingPrf.do">
					<input type="hidden" name="price" value="${ price }">
					<input type="hidden" name="location" value="${ location }">
	  				<input type="submit" class="btn btn-info" value="EDIT">
				</form>
			</div>
		</div>
	</div>
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Fill Out This Questionnaire to Set Up Your Preferences</h4>
	      </div>
	      <div class="modal-body">
	        <form action="addSeniorHousingPrf.do" method="post">
	        	<div class="form-group">
			    	<label for="email">Preferred Price:</label>
			    	<select class="form-control" name="price">
					    <option>0-100</option>
					    <option>100-200</option>
					    <option>200-300</option>
					    <option>300-400</option>
					</select>
			    	<!-- <input type="text" class="form-control" name="price"> -->
			    </div>
			    <div class="form-group">
			    	<label for="pwd">Preferred Location:</label>
			    	<select class="form-control" name="location">
					    <option>Pittsburgh</option>
					    <option>Chicago</option>
					</select>
			    	<!-- <input type="text" class="form-control" name="location"> -->
			    </div>
			    <input type="submit" name="action" class="btn btn-info" value="Submit" />
	        </form>
	      </div>
	    </div>
	
	  </div>
	</div>
<!-- *********Ends Here************ -->




</body>
</html>