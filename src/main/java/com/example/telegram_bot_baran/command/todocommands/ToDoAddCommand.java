package com.example.telegram_bot_baran.command.todocommands;

import com.example.telegram_bot_baran.*;
import com.example.telegram_bot_baran.DTO.ToDoDTO;
import com.example.telegram_bot_baran.command.Command;
import com.example.telegram_bot_baran.services.ToDoService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.example.telegram_bot_baran.command.todocommands.todostore.TaskStorage;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class ToDoAddCommand implements Command {

    private final ToDoService toDoService;
    private TaskStorage taskStorage;

    public ToDoAddCommand(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @Override
    public String getName() {
        return "/add";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        try {
            Long chatId = update.message().chat().id();
            String taskText = update.message().text().split("/add ")[1];

            ToDoDTO dto = new ToDoDTO();

            dto.setId(System.currentTimeMillis()); // тимчасовий генератор id
            dto.setTask(taskText);
            dto.setName(chatId.toString()); // повʼязуємо задачу з користувачем через chatId

            toDoService.addTask(dto);

            taskStorage.addTask(chatId, taskText);
            bot.execute(new SendMessage(chatId, "✅ Задача додана!"));


        } catch (RuntimeException e) {
            bot.execute(new SendMessage(update.message().chat().id(), "⚠️ Не вдалося додати задачу."));
            e.printStackTrace();
        }
    }
}
