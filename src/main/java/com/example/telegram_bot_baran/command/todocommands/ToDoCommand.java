package com.example.telegram_bot_baran.command.todocommands;

import com.example.telegram_bot_baran.command.Command;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class ToDoCommand implements Command {
    @Override
    public String getName() {
        return "/todo";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        var msg = "Ma boi use one of these 1./add 2./delete 3./list";
        bot.execute(new SendMessage(update.message().chat().id(), msg));
    }
}
