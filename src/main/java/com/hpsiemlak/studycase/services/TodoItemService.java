package com.hpsiemlak.studycase.services;


import com.hpsiemlak.studycase.models.TodoItem;
import com.hpsiemlak.studycase.models.TodoItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TodoItemService {

    public ResponseEntity<List<TodoItem>> getTodoItemList();

    public ResponseEntity<TodoItem> saveTodoItem(TodoItemRequest todoItem);

    public ResponseEntity updateTodoItem(String id, TodoItemRequest todoItemRequest);

    public ResponseEntity deleteTodoItem(String id);

    public ResponseEntity<List<TodoItem>> getTodoItemByUserName(String userName);

    public ResponseEntity<List<TodoItem>> getTodoItemByCategory(String category);
}
