<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bank</title>
</head>
<body>
<h1>Search Bank here</h1>


<div align ="center">
	<form action="ViewBank" method= "get">
		<table border="0">
			<tr>
				<th> Bank Name:</th>
				<td>
					<input type="text" name="bankname" value="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Search Bank">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>