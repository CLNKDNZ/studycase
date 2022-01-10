package com.hpsiemlak.studycase.models;

import lombok.Data;


@Data
public class TodoItemRequest {
    private String id;
    private String title;
    private String description;
    private String category;
    private String user;
}
