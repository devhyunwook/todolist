package com.example.todolist.dao;

import java.util.List;

import com.example.todolist.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao {
    List<Todo> selectTodoList();

    void insertTodo(Todo todo);

    void updateTodo(Todo todo);

    void deleteTodo(Long Id);

    Todo selectTodoById(Long Id);
}
