package com.sgk.todoapp.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sgk.todoapp.model.TodoDvo;
import com.sgk.todoapp.repository.TodoMongoDbRepository;

/**
 * Servlet implementation class SorgulaServlet
 */
@WebServlet("/sorgula")
public class SorgulaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SorgulaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newJob = request.getParameter("todo-inputbox");
		System.out.println(newJob);
		TodoDvo todo = new TodoDvo();
		todo.setId("1");
		todo.setTitle("deneme");
		todo.setDetail(newJob);
		todo.setStatus(1);
		todo.setCreationDate(LocalDateTime.now());
		
		
		TodoMongoDbRepository dbRepo = new TodoMongoDbRepository();
		dbRepo.create(todo);
		
		List<TodoDvo> finalList = dbRepo.readAll();
		System.out.println(finalList.get(0));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
