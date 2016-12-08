package com.navarro.todo.core.repository;

import com.navarro.todo.core.dto.TodoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends CrudRepository<TodoDTO,Long>{


}
