<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGK To Do App</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Red+Rose&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Serif+Pro&display=swap" rel="stylesheet">
  </head>
<body>
	
  
	<h1 class="todo-title-main">To Do App</h1>
	<form action="./sorgula" method="get">
		<div class="form-group todo-input">
		  <div class="input-group">
		    <input name="todo-inputbox" id="todo-textbox" type="text" class="form-control" placeholder="Yapılacak işi yazın">
		    
		    <button name="checkbox" class="input-group-addon input-checkbox" type="submit">
		      <span class="glyphicon glyphicon-ok" aria-hidden="true">
		    </button>
		    
		    <button name="listbtn" class="input-group-addon input-listbtn">
		   
		        <span class="glyphicon glyphicon-th-list" aria-hidden="true" >

		    </button>
		  </div> 
		</div>
	</form>
	
	
	
	
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>