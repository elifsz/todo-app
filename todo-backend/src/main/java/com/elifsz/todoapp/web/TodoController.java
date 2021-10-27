package com.elifsz.todoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elifsz.todoapp.domain.TodoItem;
import com.elifsz.todoapp.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/api/todoItems")
	public ResponseEntity<?> fetchAllTodoItems() {
		List<TodoItem> todoItems = todoService.fetchAllTodoItems();

		return ResponseEntity.ok(todoItems);
	}

	// create
	@PostMapping("/api/todoItems")
	public ResponseEntity<?> createNewTodoItem() {
		TodoItem todoItem = todoService.createTodoItem();
		return ResponseEntity.ok(todoItem);
	}

	// update
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItems(@PathVariable Long id, @RequestBody TodoItem todoItem) {
		TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);
		return ResponseEntity.ok(updatedTodoItem);
	}

}
