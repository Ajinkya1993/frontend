<jsp:include page="error.jsp" />

<p style="font-size:medium">
	Enter your new password
</p>

<p>
	<form method="POST" action="change-pwd.do">
		<table>
			<tr>
				<td> New Password: </td>
				<td><input type="password" name="newpassword" value=""/></td>
			</tr>
			<tr>
				<td> Confirm New Password: </td>
				<td><input type="password" name="confirmpassword" value=""/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="button" value="Change Password"/>
				</td>
			</tr>
		</table>
	</form>
</p>

