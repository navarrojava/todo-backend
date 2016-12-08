package com.navarro.todo.core.service.impl;

import com.navarro.todo.core.dto.TodoDTO;
import com.navarro.todo.core.repository.TodoRepository;
import com.navarro.todo.core.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Iterable<TodoDTO> list() {
        return todoRepository.findAll();
    }

    @Override
    public TodoDTO findById(Long id) {
        return todoRepository.findOne(id);
    }

    @Override
    public TodoDTO createOrUpdate(TodoDTO todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
