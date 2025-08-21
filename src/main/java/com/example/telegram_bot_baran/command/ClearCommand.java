package com.example.telegram_bot_baran.command;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import java.util.*;

public class ClearCommand implements Command {
    @Override
    public String getName() {
        return "/clear";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        DeleteMessage deleteMessage = new DeleteMessage(update.message().chat().id(), update.message().messageId());
        BaseResponse response = bot.execute(deleteMessage);
    }

}
