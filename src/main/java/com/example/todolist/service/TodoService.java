package com.example.todolist.service;

import java.util.List;

import com.example.todolist.domain.Todo;

public interface TodoService {
    List<Todo> selectTodos() throws Exception;

    void insertTodo(Todo todo) throws Exception;

    void updateTodo(Todo todo) throws Exception;

    void deleteTodo(Long id) throws Exception;

    Todo selectTodoById(Long id) throws Exception;
}
