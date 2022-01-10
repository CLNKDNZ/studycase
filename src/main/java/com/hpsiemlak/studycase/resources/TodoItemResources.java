package com.hpsiemlak.studycase.resources;


import com.hpsiemlak.studycase.models.TodoItem;
import com.hpsiemlak.studycase.models.TodoItemRequest;
import com.hpsiemlak.studycase.services.TodoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todoItem")
public class TodoItemResources {

    private final TodoItemService todoItemService;

    @CrossOrigin(value = "*")
    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TodoItem>> getAllTodoItem() {
        return todoItemService.getTodoItemList();
    }

    @CrossOrigin(value = "*")
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> saveTodoItem(@RequestBody TodoItemRequest request) {
        return todoItemService.saveTodoItem(request);
    }

    @CrossOrigin(value = "*")
    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable("id") String id, @RequestBody TodoItemRequest request) {
        return todoItemService.updateTodoItem(id, request);
    }

    @CrossOrigin(value = "*")
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTodoItem(@PathVariable String id) {
        return todoItemService.deleteTodoItem(id);
    }

    @CrossOrigin(value = "*")
    @GetMapping(path = "/getByUserName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TodoItem>> getTodoItemByUserName(@PathVariable String userName) {
        return todoItemService.getTodoItemByUserName(userName);
    }

    @CrossOrigin(value = "*")
    @GetMapping(path = "/getByCategory/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TodoItem>> getTodoItemByCategory(@PathVariable String category) {
        return todoItemService.getTodoItemByCategory(category);
    }
}
