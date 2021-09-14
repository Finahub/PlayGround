<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Save New Bank</title>
</head>
<body>
  <h1>Add New Bank</h1>
        <h2>
         <a href="insertUser.jsp">Add New BAnk</a>
         <a href="viewUser">List All Users</a>   
        </h2>
  <form action="save" method="post">
        <table border="1" cellpadding="5">
      
            <tr>
                <th>Bank Name: </th>
                <td>
                 <input type="text" name="bankname" 
                   value=""
                 />
                </td>
            </tr>
            <tr>
                <th>Credit Card Amount: </th>
                <td>
                 <input type="text" name="creditcardamount" 
                   value=""
                 />
                </td>
            </tr>
            <tr>
                <th>Debit Card Amount: </th>
                <td>
                 <input type="text" name="debitcardamount" 
                   value="" />
                </td>
               
            </tr>

            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save Bank Info" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>