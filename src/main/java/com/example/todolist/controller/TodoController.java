package com.example.todolist.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.example.todolist.domain.Todo;
import com.example.todolist.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 목록 조회
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos() throws Exception {
        List<Todo> todos = todoService.selectTodos();
        return ResponseEntity.ok(todos);
    }

    // 목록 등록
    @PostMapping
    public ResponseEntity<String> postTodo(@RequestBody Todo todo) throws Exception {
        todo.setCreatedDateTime(LocalDateTime.now());
        todo.setIsComplete(false);
        todoService.insertTodo(todo);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    // 목록 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> putTodo(@PathVariable("id") Long id) throws Exception {
        Todo todo = todoService.selectTodoById(id);

        Boolean isComplete = todo.getIsComplete() ? false : true;
        todo.setIsComplete(isComplete);
        todoService.updateTodo(todo);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    // 목록 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
        todoService.deleteTodo(id);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }
}
