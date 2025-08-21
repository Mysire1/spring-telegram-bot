package com.example.telegram_bot_baran.command;

import com.pengrad.telegrambot.model.Update;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CommandRouter {
    private final Map<String, Consumer<Update>> handlers = new HashMap<>();

    public void on(String command, Consumer<Update> handler) {
        handlers.put(command, handler);
    }

    public void handle(Update update) {
        if (update.message() != null && update.message().text() != null) {
            String text = update.message().text().split(" ")[0];
            if (handlers.containsKey(text)) {
                handlers.get(text).accept(update);
            }
        }
    }
}
