package org.yenice.todolist;

public class TodoListRequest {

    private String name;

    public TodoListRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
