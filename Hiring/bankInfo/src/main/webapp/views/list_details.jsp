<style>
.outer {
    display: table;
    position: absolute;
    height: 100%;
    width: 100%;
    
}

.inner {
    top:100px;
    left:365px;
    width:50%;
    height:51px;
    color:white;
    position:absolute;
    text-align:center;
    background-color:black;
}
.inner h1
{
	margin:auto;
    line-height:51px;
    vertical-align:middle;
}
.button1 {
    display: block;
    width: 150px;
    height: 20px;
    background: #4E9CAF;
    padding: 10px; 
    border-radius: 5px;
    color: white;
    text-decoration:none;
    display:inline-block;
}

.button2 {
    display: block;
    width: 60px;
    height: 20px;
    background: #ff0000;
    border-radius: 5px;
    text-align: center;
    color: white;
    text-decoration:none;
    display:inline-block;
}
.button3 {
    display: block;
    width: 60px;
    height: 20px;
    background: #4CAF50;;
    border-radius: 5px;
    text-align: center;
    color: white;
    text-decoration:none;
    display:inline-block;
}

.backbutton {
    display: block;
    width: 150px;
    height: 20px;
    background: #555555;;
    padding: 10px; 
    border-radius: 5px;
    color: white;
    text-decoration:none;
    display:inline-block;
}


</style>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <div class="outer">
  <div class="inner">
<h1>Bank Details List</h1>  
<table border="2" width="100%" >  
<tr>
<th>Id</th>
<th>Name</th>
<th>Credit Card Count</th>
<th>Debit Card Count</th>
<th>Actions(Edit/Delete)</th>
</tr>  
   <c:forEach var="details" items="${banks}">   
   <tr>  
   <td>${details.id}</td>  
   <!-- <td>1</td>  -->
   <td>${details.name} </td>  
   <td>${details.credit}</td>  
   <td>${details.debit}</td>  
   <td><a class="button3" href="editDetails/${details.id}">Edit</a>&nbsp; 
       <a class="button2" href="deleteDetails/${details.id}">Delete</a>
   </td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a class="button1" href="addDetails">Add New Bank Details</a>
   <a class="backbutton" href="/bankInfo">Back to Home</a>
   </div>
   </div>  