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
	<h1 class="todo-title-list" onclick="location.href = 'index.jsp';" >To Do App</h1>
	
	<div id="success-alert" class="alert alert-success success-message" style="display:none; width:50%; margin:auto; text-align:center;">
    	<strong>Başarılı!</strong> Seçilen iş silindi.
	</div>
		
	<ul id="todo-list" class="list-group todo-list">
		<c:forEach items="${finalList}" var="item">
			<li id="list_item" class="list-group-item" data-value='${item.getId()}'>
				<span class="not-editable-item">${item.getDetail()}</span>
				<input class="form-control input-lg list-item-input" type="text" style="display: none;" placeholder="Değiştirmek için yazın.">

				<div class="pull-right">
					<a href="#" id="update_button" style="margin-right: 10px;">
						<span class="glyphicon glyphicon-pencil"></span>      
					</a>
					<a href="#" id="delete_button">
						<span class="glyphicon glyphicon-remove"></span>
					</a>
				</div>
			</li>
		</c:forEach>
	</ul>

	
	
	

  <!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/script.js"></script>
	<script type="text/javascript">
	var todoList = document.querySelector("#todo-list");
	todoList.addEventListener("click", updateButtonHandler, false);

	function updateButtonHandler(e) {
		if (e.path[1].id === "update_button") {
			var parent = findParent(e.target, 3);
			var uneditable = findChild(parent).$span;
			var editableInp = findChild(parent).$input;
			
			uneditable.style.display = 'none';
			editableInp.style.display = 'inline';
			editableInp.focus();
		}
	}
	function findChild(nodeObj) {
		var $span = nodeObj.children[0];
		var $input = nodeObj.children[1];
		return {
			$span,
			$input
		};
	}

	function findParent(nodeObj, number) {
		var i;
		for (i = 0; i < number; i++) {
			nodeObj = nodeObj.parentNode;
		}
		return nodeObj;
	}

	$('.list-item-input').on('blur keydown', function(e) {
		if (e.type === 'blur' || e.keyCode === 13) {
			var parent = $(this).parent();

			parent.find('.not-editable-item').show();
			parent.find('.list-item-input').hide();
			parent.find('.update_done').hide();

			if (parent.find('.list-item-input').val() !== "") {
				var updatedJob = parent.find('.list-item-input').val();
				var _id = document.getElementById("list_item").getAttribute("data-value");
				parent.find('.not-editable-item').text(updatedJob);
				$.ajax({
					url: 'update',
					method: 'POST',
					data: { updatedJob: updatedJob, _id: _id },
					success: function(resultText) {
						$('#result').html(resultText);
					},
					error: function(jqXHR, exception) {
						console.log('Error occured!!');
					}
				});

			}
		}

	});
	
	todoList.addEventListener("click", deleteButtonHandler, false);
	function deleteButtonHandler(e) {
		var parent = findParent(e.target, 3);
		var _id = parent.getAttribute("data-value");
 		if (e.path[1].id === "delete_button") {
			$.ajax({
				url: 'delete',
				method: 'POST',
				data: {_id: _id },
				success: function(resultText) {
					findParent(e.target, 4).removeChild(findParent(e.target, 3));
					$('#success-alert').fadeIn();
					$('#success-alert').fadeOut(1000);
				},
				error: function(jqXHR, exception) {
					console.log('Error occured!!');
				}
			});
		}
		 
		
	}
	
	
	</script>
</body>
</html>
