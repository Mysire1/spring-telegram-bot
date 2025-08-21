package com.example.telegram_bot_baran.command.todocommands;

import com.example.telegram_bot_baran.command.Command;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.example.telegram_bot_baran.command.todocommands.todostore.TaskStorage;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class ToDoListCommand implements Command {
    private TaskStorage taskStorage;

    public ToDoListCommand(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }

    @Override
    public String getName() {
        return "/list";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        if (taskStorage.getTasks(update.message().chat().id()) == null) {
            bot.execute(new SendMessage(update.message().chat().id(), "Нема тасків"));
        }
        String text = "Таскі:\n";
        for (String task : taskStorage.getTasks(update.message().chat().id())) {
            text += task + "\n";
        }
        bot.execute(new SendMessage(update.message().chat().id(), text));
    }
}
