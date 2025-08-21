package com.example.telegram_bot_baran.command.todocommands;

import com.example.telegram_bot_baran.command.Command;
import com.example.telegram_bot_baran.command.todocommands.todostore.TaskStorage;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoDeleteCommand implements Command {

    private TaskStorage taskStorage;

    public ToDoDeleteCommand(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }

    @Override
    public String getName() {
        return "/delete";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        Long chatId = update.message().chat().id();
        String[] parts = update.message().text().trim().split("\\s+"); // означает «любой пробельный символ» (пробел, табуляция, перенос строки).

        // Проверка: есть ли номер задачи после команды
        if (parts.length < 2) {
            bot.execute(new SendMessage(chatId, "⚠️ Вкажіть номер таску для видалення, наприклад: /delete 2"));
            return;
        }

        try {
            int index = Integer.parseInt(parts[1]) - 1; // Пользователь пишет 1, а индекс 0

            List<String> tasks = taskStorage.getTasks(chatId);

            if (index < 0 || index >= tasks.size()) {
                bot.execute(new SendMessage(chatId, "❌ Нема таски з таким номером"));
                return;
            }

            String removedTask = tasks.remove(index);
            bot.execute(new SendMessage(chatId, "🗑️ Видалено: " + removedTask));
        } catch (NumberFormatException e) {
            bot.execute(new SendMessage(chatId, "❗ Номер таску має бути числом, наприклад: /delete 1"));
        }
    }
}
