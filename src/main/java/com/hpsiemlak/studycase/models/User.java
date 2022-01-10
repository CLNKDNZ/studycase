package com.hpsiemlak.studycase.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Data
@Document
@TypeAlias("user")
@CompositeQueryIndex(fields = {"id", "name"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;
    @QueryIndexed
    @Field
    private String name;
    @Field
    private String username;
    @Field
    private String password;
    @Field
    private String role;

    public User() {
    }

    @PersistenceConstructor
    public User(String name, String username, String password, String role) {

        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
