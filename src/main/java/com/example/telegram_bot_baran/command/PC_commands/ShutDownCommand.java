package com.example.telegram_bot_baran.command.PC_commands;

import com.example.telegram_bot_baran.command.Command;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ShutDownCommand implements Command {
    @Override
    public String getName() {
        return "/shutdown";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        if (update.message().equals(getName())) {
            bot.execute(new SendMessage(update.message().chat().id(), "Shutting down in 5 seconds"));
            try {
                new ProcessBuilder("cmd.exe", "/c", "shutdown /s /t 5")
                        .start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
