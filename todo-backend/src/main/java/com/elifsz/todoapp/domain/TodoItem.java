package com.elifsz.todoapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
	@Id
	@GeneratedValue
	private Long Id;
	private String task;
	private Boolean isDone;
	
	public static Long staticid = (long) 0;

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
	
	public TodoItem() {
		
	}
	
	public TodoItem(String task,Boolean isDone) {
		this.Id = staticid++;
		this.task = task;
		this.isDone=isDone;
	}

}
