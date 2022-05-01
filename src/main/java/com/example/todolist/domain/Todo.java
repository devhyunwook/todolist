package com.example.todolist.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Todo {
    private Long id;
    private String content;
    private LocalDateTime createdDateTime;
    private Boolean isComplete;
}
