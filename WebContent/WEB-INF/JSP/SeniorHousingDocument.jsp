<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="SeniorHousingTop.jsp"/>
<!-- *********Starts Here************ -->
			<div style="margin-left:50px; margin-right:50px">
				<h1>My Documents</h1>
				<button style="width:350px;margin-bottom:20px" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">UPLOAD NEW DOCUMENT</button>
				<c:forEach var="error" items="${errors}">
					<div class="alert alert-warning">
					  <strong>${error}</strong>
					</div>
				</c:forEach>
				<ul class="list-group">
					<c:forEach var="doc" items="${docList}">
						<li class="list-group-item">
							<h3>${doc.name}</h3>
							<%-- <c:if test="${doc.accessLevel}"> --%>
								<form action="seniorHousingDocManage.do">
									<input type="hidden" name="docName" value="${doc.name}">
									<input type="hidden" name="docURL" value="${doc.url}">
									<input type="submit" class="btn btn-success" value="DOWNLOAD">
									<c:if test="${doc.accessLevel}">
										<input type="submit" class="btn btn-info" value="MANAGE SHARING">
										<input type="submit" class="btn btn-warning" value="DELETE">
									</c:if>
								</form>
							<%-- </c:if> --%>
						</li>
					</c:forEach>
				</ul>
			</div>
<!-- *********Ends Here************ -->
		</div>
	</div>
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Upload New Document</h4>
	      </div>
	      <div class="modal-body">
	        <form action="">
	        	<div class="form-group">
					<label>Document Name:</label>
					<input type="text" name="docName" class="form-control">
				</div>
	        	<input type="file" name="doc" csw-file-input file-data="address.file">
	        	<br>
	        	<input type="submit" name="action" class="btn btn-info" value="Submit" />
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>