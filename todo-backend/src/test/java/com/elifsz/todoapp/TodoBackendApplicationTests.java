package com.elifsz.todoapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.tomcat.util.http.fileupload.util.FileItemHeadersImpl;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import com.elifsz.todoapp.domain.TodoItem;
import com.elifsz.todoapp.repository.TodoRepository;


class TodoBackendApplicationTests {

	
	@Test
	public void createTodoItemTest() {
		TodoItem item =new TodoItem();
		item = new TodoItem("Task #" + item.getId(),false);

		assertEquals(false, item.getIsDone());
	}
	
	@Test
	public void updateTodoItemTest() {
		TodoItem item =new TodoItem();
		item = new TodoItem("Task #" + item.getId(),false);
		
		item.setIsDone(true);
		assertEquals(true, item.getIsDone());
	}
	
	@Test
	@Rollback(value = false)
	public void deleteTodoItemTest() {
		TodoItem item = new TodoItem();
		TodoRepository repo = new TodoRepository();		
		repo.delete(item.getId());
		assertThat(item.getId()).isNull(); 
		assertThat(item.getIsDone()).isNull();
		assertThat(item.getTask()).isNull();
	}
	
}
