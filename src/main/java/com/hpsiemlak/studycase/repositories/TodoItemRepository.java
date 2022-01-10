package com.hpsiemlak.studycase.repositories;

import com.hpsiemlak.studycase.models.TodoItem;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "todoitem", viewName = "all")
public interface TodoItemRepository extends CouchbaseRepository<TodoItem, String> {
    public Optional<TodoItem> findById(String id);

    public List<TodoItem> findByUser(String username);

    public List<TodoItem> findByCategory(String category);

    @Query("#{#n1ql.selectEntity} WHERE category = 'Daily' AND #{#n1ql.filter}")
    public List<TodoItem> findByCategor();


}
