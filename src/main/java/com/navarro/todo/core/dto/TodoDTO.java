package com.navarro.todo.core.dto;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "todo", schema = "public")
@Data
public class TodoDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_todo")
    private Long id;

    private String description;
    private String title;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean done;


}
