package com.example.telegram_bot_baran.command;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;

public interface Command {
    String getName();
    void execute(TelegramBot bot, Update update);
}
