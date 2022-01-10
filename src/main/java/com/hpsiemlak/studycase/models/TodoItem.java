package com.hpsiemlak.studycase.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;

@Data
@Document
@TypeAlias("todoitems")
@CompositeQueryIndex(fields = {"id", "title"})
@N1qlPrimaryIndexed()

public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)

    private String id;

    @Field(name = "title")
    @QueryIndexed

    private String title;

    @Field(name = "descriptin")

    private String description;

    @Field(name = "category")

    private String category;

    @Field(name = "user")

    private String user;

    public TodoItem() {
    }

    public TodoItem(String title, String description, String category, String user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.user = user;
    }
}
