package com.elifsz.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elifsz.todoapp.domain.TodoItem;
import com.elifsz.todoapp.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired // inject
	private TodoRepository todoRepo;

	public List<TodoItem> fetchAllTodoItems() {
		return todoRepo.fetchAllTodoItems();
	}

	public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
		Optional<TodoItem> todoOpt =	todoRepo.fetchAllTodoItems()
				.stream()
				.filter(item -> item.getId().equals(id))
				.findAny();
		
		if(todoOpt.isPresent()) {
			TodoItem item = todoOpt.get();
			item.setIsDone(todoItem.getIsDone());
			item.setTask(todoItem.getTask());
			return item;
		}
		return null;
	}

	public TodoItem createTodoItem() {
		TodoItem todoItem = new TodoItem();
		
		todoItem.setIsDone(false);
		todoItem = todoRepo.save(todoItem);		
		todoItem.setTask("Task #" + todoItem.getId());
		return todoItem;
	}
}
