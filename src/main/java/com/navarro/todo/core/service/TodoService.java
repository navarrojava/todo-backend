package com.navarro.todo.core.service;

import com.navarro.todo.core.dto.TodoDTO;

public interface TodoService {

    Iterable<TodoDTO> list();
    TodoDTO findById(Long id);
    TodoDTO createOrUpdate(TodoDTO todo);
    void delete(Long id);

}
