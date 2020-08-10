<%@page import="com.sgk.todoapp.model.TodoDvo"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList"%> 
<%@page import="com.sgk.todoapp.model.TodoDvo" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGK To Do App</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    
  </head>
<body>
	
	<h1 class="todo-title-list">To Do App</h1>
	
	<c:forEach items="${finalList}" var="item">
		<ul class="list-group todo-list">
		  	<li name="item" class="list-group-item">${item.getDetail()}
		  	  <a href="<%=request.getContextPath()%>/delete"></a>
		      <span name="update_item_btn" class="glyphicon glyphicon-pencil update-list-item" aria-hidden="true">
		      
		      <a href="delete?id=<c:out value='${item.getId()}' />">
		      	<span name="delete_item_btn" class="glyphicon glyphicon-remove delete-from-list" aria-hidden="true">
		      </a>
		    </li>
		</ul>
	</c:forEach>
	
	

  

  

  <!-- jQuery (Bootstrap JS plugins depend on it) -->
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/script.js"></script>
</body>
</html>
