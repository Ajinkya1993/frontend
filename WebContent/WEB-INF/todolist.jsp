<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="template-top.jsp" />

<html>
    <head>
        <title>Favorite URLs </title>
    </head>
    
    <body>
    
        <h2>URLs</h2>
		
		<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>

        <form action="add.do" method="POST">
            <table>
                <tr> <td colspan="3"> <hr /> </td> </tr>
                <tr>
                    <td style="font-size: large">
                        URL:
                    </td>
                    <td colspan="2">
                        <input id="url" type="url" size="40" name="url"/>
                    </td>
                </tr>
                <tr>
                	<td style="font-size: large">
                        Comment:
                    </td>
                    <td colspan="2">
                        <input id="comment" type="text" size="40" name="comment"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="action" value="Add to Favorites" />
                    </td>
                </tr>
                <tr> <td colspan="3"> <hr /> </td> </tr>
            </table>
        </form>

		<p style="font-size: x-large">The list now has ${ fn:length(favorites) } favorites.</p>

		<table>
			<c:set var="count" value="0" />
			<c:forEach var="item" items="${favorites}">
				<c:set var="count" value="${ count+1 }" />
           		<tr>
       				<td>
			            <form action="delete.do" method="POST">
                			<input type="hidden" name="id" value="${item.favoriteid }" />
                			<input type="submit" name="button" value="X" />
           				</form>
        			</td>
        			<td style="font-size: x-large"> &nbsp; ${count}. &nbsp; </td>
        			<td>
        				<span style="font-size: x-large">
        					<a href="update.do?updateid=${item.favoriteid}&link=${item.url}">
        				${item.url }
        					</a>
        				</span><br>
        				<span style="font-size: x-large">
        					${item.comment }
        				</span><br>
        				<span>
        					Click Count = ${item.clickcount}
        				</span>
        			</td>
   				</tr>
   			</c:forEach>
		</table>
    </body>
</html>