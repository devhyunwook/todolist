package com.example.todolist.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.todolist.domain.Todo;

import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{
    @Override
    public List<Todo> getTodos() throws Exception {
        List<Todo> resList = new ArrayList<>();
        Todo todo = new Todo();
        todo.setContent("test content");
        todo.setId(0L);
        todo.setCreatedDateTime(LocalDateTime.now());
        todo.setIsComplete(false);
        resList.add(todo);

        Todo todo2 = new Todo();
        todo2.setContent("test content2");
        todo2.setId(1L);
        todo2.setCreatedDateTime(LocalDateTime.now());
        todo2.setIsComplete(false);
        resList.add(todo2);

        Todo todo3 = new Todo();
        todo3.setContent("test content3");
        todo3.setId(2L);
        todo3.setCreatedDateTime(LocalDateTime.now());
        todo3.setIsComplete(false);
        resList.add(todo3);
        return resList;
    }
}
