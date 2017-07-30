<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="pragma" content="no-cache">
	<title>URLs Sharing Website</title>
	<style>
		.menu-head {font-size: 10pt; font-weight: bold; color: black; }
		.menu-item {font-size: 10pt;  color: black }
    </style>
</head>

<body>

<table cellpadding="4" cellspacing="0">
    <tr>
	    <!-- Banner row across the top -->
        <td width="130" bgcolor="#99FF99"></td>
        <td bgcolor="#99FF99">&nbsp;  </td>
        <td width="500" bgcolor="#99FF99">
            <p align="center">
<c:choose>
			<c:when test="${ (empty title) }">
		        <font size="4">HW4- Web App for Favorite URLs</font>
			</c:when>
				<c:otherwise>
		        <font size="5">${ title }</font>
		        </c:otherwise>
		</c:choose>
			</p>
		</td>
    </tr>
	
	<!-- Spacer row -->
	<tr>
		<td bgcolor="#99FF99" style="font-size:5px">&nbsp;</td>
		<td colspan="2" style="font-size:5px">&nbsp;</td>
	</tr>
	
	<tr>
		<td bgcolor="#99FF99" valign="top" height="500">
			<!-- Navigation bar is one table cell down the left side -->
            <p align="left">
<c:choose>
			<c:when test="${ (empty user) }">
				<span class="menu-item"><a href="navigate.do?navact=register">Register</a></span><br/>
				<span class="menu-item"><a href="navigate.do?navact=login">Login</a></span><br/>
		</c:when>
			<c:otherwise>
				<span class="menu-head">${user.firstname} ${user.lastname}</span><br/>
				<span class="menu-item"><a href="navigate.do?navact=myfav">Manage your favorites</a></span><br/>
				<span class="menu-item"><a href="navigate.do?navact=change-pwd">Change Password</a></span><br/>
				<span class="menu-item"><a href="navigate.do?navact=logout">Logout</a></span><br/>
				<span class="menu-item">&nbsp;</span><br/>
				<span class="menu-head">Favorites From:</span><br/>
			</c:otherwise>
		</c:choose>
		
<c:choose>
			<c:when test="${ (empty userlist) }">
			</c:when>
			<c:otherwise>
			<c:forEach var="usr" items="${userlist}">
			    <span class="menu-item">
					<a href="navigate.do?navact=otherslist&uid=${usr.userid}">
						${usr.firstname } ${usr.lastname}
					</a>
				</span>
				<br/>
			</c:forEach>
			</c:otherwise>
		</c:choose>
			</p>
		</td>
		
		<td>
			<!-- Padding (blank space) between navbar and content -->
		</td>
		<td  valign="top">
