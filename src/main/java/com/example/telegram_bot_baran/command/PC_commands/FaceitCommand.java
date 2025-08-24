package com.example.telegram_bot_baran.command.PC_commands;

import com.example.telegram_bot_baran.command.Command;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FaceitCommand implements Command {
    private static final String FACEIT_PATH = "\"C:\\Program Files\\FACEIT AC\\faceitclient.exe\"";

    @Override
    public String getName() {
        return "/faceit";
    }

    @Override
    public void execute(TelegramBot bot, Update update) {
        if (update.message().text().equals(getName())) {
            bot.execute(new SendMessage(update.message().chat().id(), "Starting Faceit"));
            try {
                new ProcessBuilder(FACEIT_PATH).start();
                Thread.sleep(60000);

                bot.execute(new SendMessage(update.message().chat().id(), "Faceit already working. Starting Counter-Strike 2..."));
                new ProcessBuilder("cmd.exe", "/c", "start", "steam://rungameid/730").start();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
