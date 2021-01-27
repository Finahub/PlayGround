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




.viewbutton {
    display: block;
    width: 150px;
    height: 20px;
    background: #555555;
    padding: 10px; 
    border-radius: 5px;
    color: white;
    text-decoration:none;
    display:inline-block;
}

.savebutton {
    display: block;
    width: 150px;
    height: 20px;
    background: #4BB543;
    padding: 10px;
    border-radius: 5px;
    color: white;
    text-decoration:none;
    display:inline-block;
}



</style>
<div class="outer">
<div class="inner">
<h1>Welcome to home page</h1>
<br><br>
<a class="savebutton" href="addDetails">Add New Details</a>  
<a class="viewbutton" href="viewDetails">View Details</a>
</div>
</div>
      