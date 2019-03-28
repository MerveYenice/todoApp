package org.yenice.todolist;

import org.springframework.data.repository.CrudRepository;
import org.yenice.user.User;

import javax.transaction.Transactional;
import java.util.List;


public interface TodoListRepository extends CrudRepository<TodoList, Long> {
    List<TodoList> findAllByOwner(User owner);

    TodoList findOneByIdAndOwner(Long id, User owner);

    @Transactional
    void deleteByIdAndOwner(Long id, User owner);
}
