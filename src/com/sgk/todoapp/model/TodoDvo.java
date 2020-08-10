package com.sgk.todoapp.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

public class TodoDvo {
	
	private String id;
	private String title;
	private String detail;
	private Integer status;
	private LocalDateTime creationDate;
	
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
