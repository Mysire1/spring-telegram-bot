package com.example.telegram_bot_baran.botDB.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToDoEntity {
    @Id
    private Long id;

    @Column(name = "Title")
    private String task;

    @Column(name = "User")
    private String name;

    public ToDoEntity () {}

    public ToDoEntity(Long id, String task, String name) {
        this.id = id;
        this.task = task;
        this.name = name;
    }
}
