package com.elifsz.todoapp.domain;

public class TodoItem {
	private Long Id;
	private String task;
	private Boolean isDone;

	public Long getId() {
		return Id;
	}

	public void setId(Long idCounter) {
		this.Id = idCounter;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

}
