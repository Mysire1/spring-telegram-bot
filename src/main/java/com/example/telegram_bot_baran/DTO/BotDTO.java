package com.example.telegram_bot_baran.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BotDTO {
    @JsonProperty("bot_id")
    Long id;
    @JsonProperty("chatID")
    Long chatid;

}
