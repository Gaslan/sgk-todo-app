package com.sgk.todoapp.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
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
		TodoMongoDbRepository dbRepo = new TodoMongoDbRepository();
		if(request.getParameter("checkbox") != null) {
			String newJob = request.getParameter("todo-inputbox");
			System.out.println(newJob);
			TodoDvo todo = new TodoDvo();
			todo.setTitle("deneme");
			todo.setDetail(newJob);
			todo.setStatus(1);
			todo.setCreationDate(LocalDateTime.now());
			
			dbRepo.create(todo);
			
			List<TodoDvo> finalList = dbRepo.readAll();
						
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(request.getParameter("listbtn") != null) {
			List<TodoDvo> finalList = dbRepo.readAll();
						
			request.setAttribute("finalList", finalList);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
//			request.setAttribute("list_item", "deneme");
//			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		else {
			List<TodoDvo> finalList = dbRepo.readAll();
			
			request.setAttribute("finalList", finalList);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
