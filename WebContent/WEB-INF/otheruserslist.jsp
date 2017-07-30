<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="template-top.jsp" />

<html>
    <head>
        <title>HW4</title>
    </head>
    
    <body>
    
        <h2>Favorites for ${guestfname} ${guestlname}</h2>
        
        <c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>	
		<table>
		<p style="font-size: x-large">This user has ${fn:length(favorites)} favorite URL.</p>
			<c:set var="count" value="0" />
			<c:forEach var="fav" items="${favorites}">
				<c:set var="count" value="${ count+1 }" />     
           		<tr>
        			<td style="font-size: x-large"> &nbsp; ${count}. &nbsp; </td>
        			<td>
        				<span style="font-size: x-large">
        					<a href="update.do?updateid=${fav.favoriteid}&link=${fav.url}">
        						<c:out value="${fav.url }" />
        					</a>
        				</span><br>
        				<span style="font-size: x-large">
        					<c:out value="${fav.comment }" />
        				</span><br>
        				<span>
        					Click Count = ${fav.clickcount}
        				</span>
        			</td>
   				</tr>
   			</c:forEach>
		</table>
    </body>
</html>