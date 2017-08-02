<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Add to team</title>
</head>
<body>

	<h3 class="main-heading1"><center> Invite a new member to the team! </center></h3>
	<form action="invite.do" method="POST">
		 <table align="center">
		 <tr>
		 	<td>Email:</td>
	      	<td><input type="text" name="email" required></td>
		 </tr>
	     <tr>
	     <td></td>
	     <td>
	     	<button type="submit">Send Invitation</button>

	<h3 class="main-heading1"><center> Add a new member to the team! </center></h3>
	<form action="invite.do" method="POST">
		 <table align="center">
		 <tr>
		 	<td>Member Email</td>
	      	<td><input type="text" name="email" required></td>
		 </tr>
	     <tr>
	     	<td>Member Name</td>
	      	<td><input type="text" name="name" required><td>
	     </tr>
	     <tr>
	     <td>
	     	<button type="submit">Add to Team</button>
	      </td>
	      </tr>
    	</table>
    	<p class="alert alert-info" align="center">

       		 	We'll send an invitation with a link to this member's email!
      	</p>
    </form>

</body>
</html>