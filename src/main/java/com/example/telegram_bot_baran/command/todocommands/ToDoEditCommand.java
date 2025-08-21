package com.example.telegram_bot_baran.command.todocommands;

import com.example.telegram_bot_baran.command.Command;
import com.example.telegram_bot_baran.command.todocommands.todostore.TaskStorage;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoEditCommand implements Command {
    private TaskStorage taskStorage;

    public ToDoEditCommand(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }

    @Override
    public String getName() {
        return "/edit";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        Long chatId = update.message().chat().id();

        String [] parts = update.message().text().split(" ", 3);

        if (parts.length < 3) {
            bot.execute(new SendMessage(chatId, "⚠️ Вкажіть номер таску для редагування, наприклад: /edit 2 <Новий текст> "));
            return;
        }

        try {
            int index = Integer.parseInt(parts[1]) - 1;
            String taskName = parts[2];
            List<String> tasks = taskStorage.getTasks(chatId);

            boolean edited = taskStorage.editTask(chatId,index,taskName);

            if (index < 0 || index >= tasks.size()) {
                bot.execute(new SendMessage(chatId, "❌ Нема таски з таким номером"));
                return;
            }

            if (edited) {
                bot.execute(new SendMessage(chatId, "✅ Задачу змінено!"));
            } else {
                bot.execute(new SendMessage(chatId, "❌ Задачі з таким номером не існує."));
            }

        }catch (NumberFormatException e) {
            bot.execute(new SendMessage(chatId, "❗ Номер задачі має бути числом."));
        }

    }
}
