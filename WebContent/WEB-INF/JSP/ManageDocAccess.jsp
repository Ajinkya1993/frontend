<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="SeniorHousingTop.jsp"/>
<!-- *********Starts Here************ -->
			<div style="margin-left:50px; margin-right:50px">
				<h2>Manage Team Members' Access to ${documentName}</h2>
				<c:forEach var="error" items="${errors}">
					<div class="alert alert-warning">
					  <strong>${error}</strong>
					</div>
				</c:forEach>
				<form action="changeAccess.do" method="post">
					<div class="form-group">
						<c:forEach items="${documentPeople}" var="member">
							<label for="fname">${member.firstName} ${member.lastName}</label>
							<select id="ok" class="form-control" name="accessLevel${member.email}" style="right:200px">
								<option selected>${member.accessLevel}</option>
								<option>View and Download</option>
								<option>Share and Delete</option>
							</select>
							
						</c:forEach>
					</div>
					<input type="submit" name="action" class="btn btn-info" value="Submit" />
				</form>
			</div>
<!-- *********Ends Here************ -->
<jsp:include page="SeniorHousingBottom.jsp"/>