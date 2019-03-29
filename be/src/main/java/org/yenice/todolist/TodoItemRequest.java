package org.yenice.todolist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoItemRequest {

    private boolean completed;
    private String name;

    public TodoItemRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
