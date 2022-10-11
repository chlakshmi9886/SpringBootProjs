<%@page isELIgnored="false"%>

<h1 style="color:blue;text-align: center">Student Registration Form Page</h1>
<form action="register" method="post">
	<table border=0 align="center" bgcolor="cyan">
		<tr>
			<td>Student no::</td>
			<td><input type="text" name="sno"></td>
		</tr>		
		<tr>
			<td>Student name::</td>
			<td><input type="text" name="sname"></td>
		</tr>		
		<tr>
			<td>Student address::</td>
			<td><input type="text" name="saddr"></td>
		</tr>		
		<tr>
			<td>Student average::</td>
			<td><input type="text" name="average"></td>
		</tr>		
		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="Cancel"></td>
		</tr>
		
	</table>
</form>