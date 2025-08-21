package com.example.telegram_bot_baran.command;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class StartCommand implements Command {

    @Override
    public String getName() {
        return "/start";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        bot.execute(new SendMessage(update.message().chat().id(),"BOT ALLLOOOOOO"));
    }
}
