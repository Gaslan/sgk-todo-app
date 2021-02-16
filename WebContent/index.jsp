<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
    <link href="https://fonts.googleapis.com/css2?family=Red+Rose&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Serif+Pro&display=swap" rel="stylesheet">
  </head>
<body>
	<h1 class="todo-title-main">To Do App</h1>
	
	<div class="todo-input">
	  <div class="form-row">
	    <input name="todo-inputbox" id="todo-textbox" type="text" class="form-control" placeholder="Yapılacak işi yazın">
	    
	    <form id="addItem">
		    <button name="checkbox" type="button" class="btn btn-success input-checkbox form-control" >
		    		<span class="glyphicon glyphicon-ok" aria-hidden="true">
		    </button>
	    </form>
	    <form action="./ReadDatabase" method="get" >
		    <button name="listbtn" class="btn btn-info input-listbtn form-control">
		   		<span class="glyphicon glyphicon-th-list" aria-hidden="true" >
		   	</button>
	   	</form>
	  </div> 
	</div>
	

	<div id="success-alert" class="alert alert-success success-message" style="display:none;">
    	<strong>Başarılı!</strong> Yeni iş başarıyla eklendi.
	</div>

	
	
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/script.js"></script>
	<script type="text/javascript">
	$('.input-checkbox').on("click", function(e) {
		var addedItem = document.getElementById("todo-textbox").value;

		if (addedItem !== ""){
			
			$.ajax({
				url: 'add',
				method: 'POST',
				data: {addedItem: addedItem},
				success: function(resultText) {
					$('#success-alert').fadeIn();
					$('#success-alert').fadeOut(2500);
					
/* 					$('#addItem').submit(function (e) {
				        if (!validate(this)) e.preventDefault();
				    }); */
				},
				error: function(jqXHR, exception) {
					console.log('Error occured!!');
				}
			});
		}
		
	})
	
	</script>

</body>
</html>