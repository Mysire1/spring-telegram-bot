package com.example.telegram_bot_baran.botDB.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BotEntity {
    @Id
    private Long id;

    @Column(name = "chatid", unique = true, nullable = false)
    private Long chatid;

    public BotEntity(Long chatid) {
        this.chatid = chatid;
    }

    public BotEntity() {}

    public BotEntity(String chatid) {
        this.chatid = Long.parseLong(chatid);
    }

}

