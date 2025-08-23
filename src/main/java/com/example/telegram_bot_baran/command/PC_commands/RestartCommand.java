package com.example.telegram_bot_baran.command.PC_commands;

import java.io.IOException;

import com.example.telegram_bot_baran.command.Command;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class RestartCommand implements Command {
    @Override
    public String getName() {
        return "/restart";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        if (update.message().text().equals(getName())) {
            bot.execute(new SendMessage(update.message().chat().id(), "Restarting"));
            try {
                new ProcessBuilder("cmd.exe", "/c", "shutdown /r -t 0")
                        .start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
