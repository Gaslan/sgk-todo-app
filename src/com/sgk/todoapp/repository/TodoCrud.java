package com.sgk.todoapp.repository;

import java.util.List;

import com.sgk.todoapp.model.TodoDvo;

public interface TodoCrud {
	
	public void create(TodoDvo todo);
	public TodoDvo read(String id);
	public List<TodoDvo> readAll();
	public void update(TodoDvo todo);
	public void delete(String id);

}
