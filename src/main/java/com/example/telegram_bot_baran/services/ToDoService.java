package com.example.telegram_bot_baran.services;

import com.example.telegram_bot_baran.DTO.ToDoDTO;
import com.example.telegram_bot_baran.mapper.ToDoMapper;
import com.example.telegram_bot_baran.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {
    private final ToDoRepository repository;
    @Autowired
    private final ToDoMapper mapper;  // додали маппер

    public ToDoService(ToDoRepository repository, ToDoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ToDoDTO> getTasksForUser(String name) {
        return repository.findByName(name).stream()
                .map(mapper::toDto)     // виклик через інстанс
                .collect(Collectors.toList());
    }

    public void addTask(ToDoDTO dto) {
        repository.save(mapper.toEntity(dto));  // теж через інстанс
    }
}

