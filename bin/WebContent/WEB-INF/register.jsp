<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />

<html>
    <head>
        <title>Register Page</title>
    </head>
    
	<body>
	
		<h2>Register</h2>
		
		<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>
	
		<form action="register.do" method="POST">
		    <table>
		        <tr>
		            <td style="font-size: x-large">Email Address:</td>
		            <td>
		                <input type="text" name="emailaddress" value="${form.emailaddress}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: x-large">First Name:</td>
		            <td>
		                <input type="text" name="firstname" value="${form.firstname}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: x-large">Last Name:</td>
		            <td>
		                <input type="text" name="lastname" value="${form.lastname}" autofocus />
		            </td>
		        </tr>
		        <tr>
		            <td style="font-size: x-large">Password:</td>
		            <td><input type="password" name="password" /></td>
		        </tr>
		        <tr>
		            <td style="font-size: x-large">Confirm Password:</td>
		            <td><input type="password" name="confirmpassword"/></td>
		        </tr>
		        <tr>
		            <td colspan="2" align="center">
		                <input type="submit" name="action" value="Register" />
		            </td>
		        </tr>
			</table>
		</form>
	</body>
</html>