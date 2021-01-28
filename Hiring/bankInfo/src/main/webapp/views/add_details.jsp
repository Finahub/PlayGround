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

.savebutton {
    display: block;
    width: 70px;
    height: 25px;
    background: #4BB543;
    text-padding : 5px;
    border-radius: 5px;
    color: white;
    left-margin :20px;
}


input[type=text],select 
{
  width: 100%;
}
</style>

    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
      <div class="outer">
        <div class="inner">
            <h1 >${heading}</h1>  <br>
           <form:form action="save" method="post" commandName="bank" >    
            <table align="center">    
             <tr>
             <td></td>
             <td><form:input path="id" value="${bank.id}" readonly="true" hidden="true"/></td>
           </tr> 
             <tr>    
              <td>Bank Name  </td> 
              <td><form:input path="name" value="${bank.name}"  /></td>  
             </tr>    
             <tr>    
              <td>Credit Card Count </td>  
              <td><form:input path="credit" value="${bank.credit}"/></td>  
             </tr>   
             <tr>    
              <td>Debit card Count</td> 
              <td><form:input path="debit" value="${bank.debit}"/></td>  
             </tr>    
             
             <tr>   
              <td> </td> 
              <td><input type="submit" value="${buttonLabel}"  class ="savebutton"/></td>    
             </tr>    
            </table>    
           </form:form> 
           <br><br>
        <a class="button1" href="viewDetails">View Details</a>
       <a class="backbutton" href="/bankInfo">Back to Home</a>   
        </div> 
        
        </div>  