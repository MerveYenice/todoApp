package org.yenice.todolist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.yenice.user.User;

import javax.persistence.*;


@Entity
@Table(name = "todo_item")
public class TodoItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TODO_LIST_ID")
    @JsonIgnore
    private TodoList list;

    @OneToOne
    @JoinColumn(name = "OWNER_USER_ID")
    @JsonIgnore
    private User owner;

    public TodoList getList() {
        return list;
    }

    public User getOwner() {
        return owner;
    }

    public void setList(TodoList list) {
        this.list = list;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
