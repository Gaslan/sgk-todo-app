package com.sgk.todoapp.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgk.todoapp.model.TodoDvo;
import com.sgk.todoapp.repository.TodoMongoDbRepository;


@WebServlet("/update")
public class UpdateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateItem() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updatedJob = request.getParameter("updatedJob");
		String _id = request.getParameter("_id");
		
		TodoDvo todo = new TodoDvo();
		todo.setId(_id);
		todo.setTitle("deneme");
		todo.setDetail(updatedJob);
		todo.setStatus(1);
		todo.setCreationDate(LocalDateTime.now());
		
		TodoMongoDbRepository dbRepo = new TodoMongoDbRepository();
		dbRepo.update(todo);
	}

}
