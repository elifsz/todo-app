package com.elifsz.todoapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.elifsz.todoapp.service.TodoService;

class TodoBackendApplicationTests {

	@Autowired
	TodoService service;
	
	//@Test
	/*public void createTodoItemTest() {
		TodoItem item =null;
		item = new TodoItem("Task #" + item.getId(),false);
		
		Mockito.when(repo.save(item)).thenReturn(item);
		assertEquals(item, service.createTodoItem());
		
	}*/
	
    @Test
    public void testGet() {
        assertEquals(false, service.createTodoItem().getIsDone());
    }

}
