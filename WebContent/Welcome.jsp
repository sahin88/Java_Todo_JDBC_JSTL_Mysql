<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
 <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />" rel="stylesheet">
<%--  <link type="text/css" href="<c:url value="${pageContext.request.contextPath}/WebContent/App.css" />" rel="stylesheet">
 --%>
<meta charset="UTF-8">
 <script src="https://kit.fontawesome.com/yourcode.js"></script>
<title>Insert title here</title>
<style type="text/css">


@charset "UTF-8";

@charset "UTF-8";
body{
	background-color:#ededed;
	font-family: 'Roboto', sans-serif;
	box-sizing:border-box;
}

header{
	
	background-color:#131921;
	width:100;
	height:60px;
	display:flex;
	align-items:center;
}

.header_logo{
	color:#fff;
	margin:15px;
}

.header_search{
	
	display:flex;
	flex:1;
	margin:0 15px 0 15px;
	
}

.header_searchIcon{
	background-color:#c49042;
	padding:8px;
	height:21px !important
}

.header_searchInput{
	padding:10px;
	height:16px;
	width:100%;
	border:none;
	
}

.header_container{

	display:flex;
	align-items:center;
	padding:15px; 

	
		
}
.header_container a{
	text-decoration:none;
	color:red;
	margin:10px;

}
.header_container form input[type=submit]{
	text-decoration:none;
	color:red;
	background-color:#131921;
	margin:10px;
	border:none;
	font-family: 'Roboto', sans-serif;
	font-size:16px;

}
.addNew{
text-decoration:none;
color:green;
border:3px solid green;
padding:10px;
font-size:16px;
font-wight:600;
position:relative;
top: 25px;
}

.table_horizontal{
	width:60vw;
}
.table_horizontal {
  width: 60vw;
  min-width: 350px;
  z-index: 1;
  position: relative;
  top: 110px;
  left: 0%;
  background: #fafafa;
  text-align: center;
  border-collapse: collapse;
  border-spacing: 0;
  box-shadow: 0 5px 10px rgba(50, 66, 80, 1);
  margin-bottom: 50px;
  overflow: auto;
}
.Table_vertical {
  display: none;
}
th,
td {
  padding: 20px 12px;
}

th {
  background: #131921;
  color:#fff;
}

tbody:nth-child(odd) {
  background-color: #131921;
}
tbody:nth-child(even) {
  background-color: #c49042;
}

.update_button {
  border: 2px solid green;
  box-sizing: border-box;
  color: green;
  transition: 0.4s ease-in-out;
  text-decoration:none;
  padding:5px;
  background-color:#fff;
  border :1px solid green;
}

.delete_button {
  border: 2px solid #e91e63;
  box-sizing: border-box;
  color: #e91e63;
  transition: 0.4s ease-in-out;
  text-decoration:none;
  padding:5px;
  background-color:#fff;
  border :1px solid #e91e63;
}

.delete_button:hover {
  background-color: #e91e63;
  box-sizing: border-box;
  color: #fff;
}

.update_button:hover {
  background-color: green;
  box-sizing: border-box;
  color: #fff;
}




@media all and (max-width: 560px) {
  .table_horizontal {
    display: none;
  }
  .Table_vertical {
    position: relative;
    display: block;
    width: 380px;
    left: 20%;
  }
  tr {
    border: 2px solid #aaaa;
    box-sizing: border-box;
  }

  tbody:nth-child(odd) {
    background-color: #c49042;
  }
  .Division-Create-Form input[type="text"] {
    width: 300px;
  }
}

@media all and (min-width: 410px) {
  input[type="text"],
  input[type="password"],
  input[type="email"] {
    width: 350px;
  }

  .forms {
    width: 420px;
  }

  .login-user-image {
    left: 170px;
  }
  .h2 {
    left: 50px;
  }
}

</style>
</head>
<body>
<header>




	<% 
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate" );
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	System.out.println("username  : "+session.getAttribute("username"));
	if(session.getAttribute("username")==null){
		RequestDispatcher dispatcher= request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
		
	}%>
	<div class="header_logo">
		<h1>DDMO</h1>
	</div>

	<div class="header_search">
		<input class="header_searchInput" type="text">
		<i class=" header_searchIcon fas fa-search"></i>
	</div>
	<div class="header_container">
		
		<a href="About.jsp">About</a>
		<a href="Videos.jsp">Videos</a>
		<form action="logout">
			<input type="submit" value="Logout"/>	
		</form>
	</div>

</header>


<a class='addNew' href='<c:out value="new"></c:out>'>Add New</a>


 <div> 
 		
 		
 	   <table class="table_horizontal">
 	   <tr>
 	   <th>#</th>
          <th>Image</th>
          <th>Author</th>
          <th>Title</th>
          <th>Update</th>
          <th>Delete</th>
 	   </tr>
          
              <tbody>
             <c:forEach items="${postlist}" var="itm">
                <tr>
                  <td><c:out value="${itm.postId}"></c:out></td>

                  <td>
                    <img
                      src=""
                      style=
                    />
                  </td>

                  <td><c:out value="${itm.postName}"></c:out></td>
                  <td><c:out value="${itm.postAuthor}"></c:out></td>
                  <td>
                
                    
                    <a href="edit?id=<c:out value="${itm.postId}"></c:out>" class="update_button">Edit</a>
                  </td>
                  <td>
                      <a href="delete?id=<c:out value="${itm.postId}"></c:out>" class="delete_button">Delete</a>
                  </td>
                </tr>
                </c:forEach> 
              </tbody>
      
        </table>
        <table class="Table_vertical">
       
              <tbody>
                <tr>
                  <td>#</td>
                  <td>1</td>
                </tr>
                <tr>
                  <td>Image</td>
                  <td>
                    <img
                      src=""
                      
                    />
                  </td>
                </tr>
                <tr>
                  <td>Author</td>
                  <td>Erdal Erzincan</td>
                </tr>
                <tr>
                  <td>Title</td>
                  <td>Pir 	Sultan Abdal</td>
                </tr>
                <tr>
                  <td>Update</td>
                  <td>
                    <form >
                      <button class="Update_Button" type="submit">
                        Update
                      </button>
                    </form>
                  </td>
                </tr>
                <tr>
                  <td>Delete</td>
                  <td>
                    <form
                     
                    >
                      <button class="Delete_Button" type="submit">
                        Delete
                      </button>
                    </form>
                  </td>
                </tr>
              </tbody>
        </table>
 
 
 

 
 
 </div>


</body>
</html>