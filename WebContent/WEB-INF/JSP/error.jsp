<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Curantis Solution</title>
    </head>
    
	<body>
		<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>
	</body>
</html>