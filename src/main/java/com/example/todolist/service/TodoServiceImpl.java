package com.example.todolist.service;

import java.util.List;

import com.example.todolist.dao.TodoDao;
import com.example.todolist.domain.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoDao tododao;

    @Override
    public List<Todo> selectTodos() {
        List<Todo> todoList = tododao.selectTodoList();
        System.out.println(todoList);

        return todoList;
    }

    @Override
    public void insertTodo(Todo todo) {
        tododao.insertTodo(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        tododao.updateTodo(todo);
    }

    @Override
    public void deleteTodo(Long Id) {
        tododao.deleteTodo(Id);
    }

    @Override
    public Todo selectTodoById(Long Id) {
        Todo todo = tododao.selectTodoById(Id);

        return todo;
    }
}
