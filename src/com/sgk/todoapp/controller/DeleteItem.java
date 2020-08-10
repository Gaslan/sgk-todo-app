package com.sgk.todoapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgk.todoapp.repository.TodoMongoDbRepository;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/delete")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/delete":
			String id = request.getParameter("id");
			TodoMongoDbRepository dbRepo = new TodoMongoDbRepository();
			dbRepo.delete(id);
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/sorgula");
			break;
		case "/update":
			break;
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
