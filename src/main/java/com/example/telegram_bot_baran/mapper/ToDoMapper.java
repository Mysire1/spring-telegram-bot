package com.example.telegram_bot_baran.mapper;

import com.example.telegram_bot_baran.DTO.ToDoDTO;
import com.example.telegram_bot_baran.botDB.Entity.ToDoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToDoMapper {

    ToDoDTO toDto(ToDoEntity entity);
    ToDoEntity toEntity(ToDoDTO dto);

//    public static ToDoDTO toDTO(ToDoEntity entity) {
//        ToDoDTO dto = new ToDoDTO();
//        dto.setId(entity.getId());
//        dto.setTask(entity.getTask());
//        dto.setName(entity.getName());
//        return dto;
//    }
//
//    public static ToDoEntity toEntity(ToDoDTO dto) {
//        ToDoEntity entity = new ToDoEntity();
//        entity.setId(dto.getId());
//        entity.setTask(dto.getTask());
//        entity.setName(dto.getName());
//        return entity;
//    }
}
