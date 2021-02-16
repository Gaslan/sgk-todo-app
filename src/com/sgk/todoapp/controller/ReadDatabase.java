package com.sgk.todoapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgk.todoapp.model.TodoDvo;
import com.sgk.todoapp.repository.TodoMongoDbRepository;

@WebServlet("/ReadDatabase")
public class ReadDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReadDatabase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("listbtn") != null) {
			TodoMongoDbRepository dbRepo = new TodoMongoDbRepository();
			List<TodoDvo> finalList = dbRepo.readAll();
			
			request.setAttribute("finalList", finalList);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		
	}

}
