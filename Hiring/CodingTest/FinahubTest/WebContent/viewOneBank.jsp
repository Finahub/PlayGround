<%@ page language="java" contentType="text/html; charset=windows-1256"
   pageEncoding="windows-1256" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>View Bank Info</title>
</head>
<body>
  <h1>Bank Info</h1>
        <h2>
         <a href="addBank">Add New Bank</a>
         <a href="viewBankInfo">View All Bank Info</a>
         
        </h2>

    <div align="center">
        <table border="1" cellpadding="5">
   		<tr>
    		<th>Bank ID </th>
    		<th>Bank Name </th>
    		<th>Credit Card Amount </th>
    		<th>Debit Card Amount </th>
    	</tr>
    	<tr>
    		<td><c:out value='${bankinfo.bank_id}' /></td>
    		<td><c:out value='${bankinfo.bankname}' /></td>
    		<td><c:out value='${bankinfo.creditcardamount}' /></td>
    		<td><c:out value='${bankinfo.debitcardamount}' /></td>
    	</tr>
        </table>
    </div> 
</body>
</html>