package com.hpsiemlak.studycase.services;


import com.hpsiemlak.studycase.models.TodoItem;
import com.hpsiemlak.studycase.models.TodoItemRequest;
import com.hpsiemlak.studycase.repositories.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Override
    public ResponseEntity<List<TodoItem>> getTodoItemList() {
        var result = todoItemRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @Override
    public ResponseEntity<TodoItem> saveTodoItem(TodoItemRequest todoItemRequest) {
        var todoItem = bindTodoItem(todoItemRequest);
        todoItemRepository.save(todoItem);
        return ResponseEntity.status(HttpStatus.OK).body(todoItem);
    }

    @Override
    public ResponseEntity updateTodoItem(String id, TodoItemRequest todoItemRequest) {
        var selectedResult = todoItemRepository.findById(id);
        if (selectedResult.isPresent()) {
            var result = bindTodoItem(todoItemRequest, selectedResult.get());
            todoItemRepository.save(result);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    public ResponseEntity deleteTodoItem(String id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity<List<TodoItem>> getTodoItemByUserName(String userName) {
        var result = todoItemRepository.findByUser(userName);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Override
    public ResponseEntity<List<TodoItem>> getTodoItemByCategory(String category) {
        var result = todoItemRepository.findByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    private final TodoItem bindTodoItem(TodoItemRequest todoItemRequest) {
        TodoItem todoItem = new TodoItem();
        todoItem.setCategory(todoItemRequest.getCategory());
        todoItem.setDescription(todoItemRequest.getDescription());
        todoItem.setTitle(todoItemRequest.getTitle());
        todoItem.setUser(todoItemRequest.getUser());
        return todoItem;
    }

    private final TodoItem bindTodoItem(TodoItemRequest todoItemRequest, TodoItem todoItem) {
        todoItem.setId(todoItem.getId());
        todoItem.setCategory(todoItemRequest.getCategory());
        todoItem.setDescription(todoItemRequest.getDescription());
        todoItem.setTitle(todoItemRequest.getTitle());
        todoItem.setUser(todoItemRequest.getUser());
        return todoItem;

    }
}
