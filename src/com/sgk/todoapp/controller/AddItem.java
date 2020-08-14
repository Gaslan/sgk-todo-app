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

@WebServlet("/add")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddItem() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newItem = request.getParameter("addedItem");
		
		TodoDvo todo = new TodoDvo();
		todo.setTitle("deneme");
		todo.setDetail(newItem);
		todo.setStatus(1);
		todo.setCreationDate(LocalDateTime.now());
		
		TodoMongoDbRepository dbRepo = new TodoMongoDbRepository();
		dbRepo.create(todo);
	}

}
