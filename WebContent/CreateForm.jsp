<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

@charset "UTF-8";
body{
	background-color:#ededed;
	font-family: 'Roboto', sans-serif;
	box-sizing:border-box;
}

.login__div form {
	
	position:relative;
	left:40%;
	top:200px;
	background-color:#fff;
	width:300px;
	height:400px;
	display:flex;
	flex-direction: column;
	color:#101;
	padding:50px

}
.login__div form input[type=submit]{
	margin:15px 0px 15px 0px;
	background:#f0c14b;
	animation: .4s ease-in-out ;
	cursor:pointer;
	padding:7px;
	font-size:16px;
	border-color:#a88734 #9c7e31 #846a29;
}

.login__div form input[type=text], input[type=password]{
	margin:15px 0px 15px 0px;
	background:#fff;
	cursor:pointer;
	padding:7px;
	font-size:16px;
}



.login__div form input[type=submit]:hover{

	color:#fff;
}

 .login__div form span .return_regi{
	text-decoration:none;
	color:red;
	font-size:12px;
	
}


 .login__div form span .return_signin{
	text-decoration:none;
	color:royalblue;
	font-size:12px;
	
}





</style>






<meta charset="UTF-8">
<%--  <link href="<c:url value="/Login.css" />" rel="stylesheet"> --%>
 <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<div class="login__div">
		<c:if test="${postlist==null }">
		<form action="insert" method="post">
		<h2>Add New</h2>
		</c:if>
		<c:if test="${postlist!=null }">
		<form action="update" method="post">
		<input type='hidden' value='<c:out value="${postlist.postId}"></c:out>' name="postId">
		<h2>Update</h2>
		</c:if>
			Post Name:<input type='text' value='<c:out value="${postlist.postName}"></c:out>' name="postName">
			Post Author:<input type='text' value='<c:out value="${postlist.postAuthor}"></c:out>'  name="postAuthor">
			<input type="submit"/>
		</form>
	</div>

</body>
</html>