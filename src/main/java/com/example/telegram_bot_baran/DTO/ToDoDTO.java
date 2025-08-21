package com.example.telegram_bot_baran.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToDoDTO {
    @JsonProperty("task_id")
    Long id;
    @JsonProperty("task")
    String task;
    @JsonProperty("user_name")
    String name;

}
