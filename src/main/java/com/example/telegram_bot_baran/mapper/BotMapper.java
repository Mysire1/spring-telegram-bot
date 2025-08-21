package com.example.telegram_bot_baran.mapper;

import com.example.telegram_bot_baran.botDB.Entity.BotEntity;
import com.example.telegram_bot_baran.DTO.BotDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BotMapper {

    BotDTO toDto(BotEntity botEntity);
    BotEntity toEntity(BotDTO botDTO);


//    public static BotDTO toDTO (BotEntity botEntity) {
//        BotDTO botDTO = new BotDTO();
//        botDTO.setId(botEntity.getId());
//        botDTO.setChatid(botEntity.getChatid());
//
//        return botDTO;
//    }
//
//    public static BotEntity toEntity (BotDTO botDTO) {
//        BotEntity botEntity = new BotEntity();
//        botEntity.setId(botDTO.getId());
//        botEntity.setChatid(botDTO.getChatid());
//
//        return botEntity;
//    }
}
