package com.example.todolist.service;

import java.util.List;

import com.example.todolist.domain.Todo;

public interface TodoService {
    List<Todo> getTodos() throws Exception;
}
