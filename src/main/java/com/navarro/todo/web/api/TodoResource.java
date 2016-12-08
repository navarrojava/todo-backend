package com.navarro.todo.web.api;

import com.navarro.todo.core.dto.TodoDTO;
import com.navarro.todo.core.service.TodoService;
import com.navarro.todo.core.validator.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "todo")
public class TodoResource {

    private final TodoService todoService;

private final TodoValidator todoValidator;


    @Autowired
    public TodoResource(TodoService todoService, TodoValidator todoValidator) {
        this.todoService = todoService;
        this.todoValidator = todoValidator;
    }

    @InitBinder
    protected void securityInitBinder(WebDataBinder binder) {
        binder.setValidator(todoValidator);
    }


    @GetMapping
    public Iterable<TodoDTO> getAll() {
        return todoService.list();
    }


    @GetMapping(value = "{id}")
    public TodoDTO getById(@PathVariable Long id) {
        return todoService.findById(id);
    }


    @PostMapping
    public ResponseEntity create(@Validated @RequestBody TodoDTO todo) {
        return todoService.createOrUpdate(todo) != null ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update(@Validated @RequestBody TodoDTO todo) {
        return todoService.createOrUpdate(todo) != null ? new ResponseEntity(HttpStatus.NO_CONTENT) : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
