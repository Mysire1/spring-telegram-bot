package com.example.telegram_bot_baran;

import com.example.telegram_bot_baran.command.*;
import com.example.telegram_bot_baran.command.PC_commands.FaceitCommand;
import com.example.telegram_bot_baran.command.PC_commands.RestartCommand;
import com.example.telegram_bot_baran.command.PC_commands.ShutDownCommand;
import com.example.telegram_bot_baran.command.todocommands.*;
import com.example.telegram_bot_baran.command.todocommands.todostore.TaskStorage;
import com.example.telegram_bot_baran.configuration.BotConfig;
import com.example.telegram_bot_baran.services.ToDoService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@EnableJpaRepositories("com.example.telegram_bot_baran.repository")
@EntityScan("com.example.telegram_bot_baran.botDB.Entity")
@Component
public class TelegramBotBaran  {
    private final ToDoService toDoService;
    private BotConfig botConfig;
    private TelegramBot bot;
    private final TaskStorage taskStorage = new TaskStorage();

    public TelegramBotBaran(BotConfig botConfig, ToDoService toDoService) {
        this.bot = new TelegramBot(botConfig.getToken());
        this.toDoService = toDoService;
        StartTelegramBot();
    }

    public void StartTelegramBot () {
        CommandRouter router = new CommandRouter();
        Command[] commands = {
                new StartCommand(),
                new ClearCommand(),
                new ToDoCommand(),
                new ToDoAddCommand(toDoService),
                new ToDoListCommand(taskStorage),
                new ToDoDeleteCommand(taskStorage),
                new ToDoEditCommand(taskStorage),
                new RestartCommand(),
                new ShutDownCommand(),
                new FaceitCommand()
        };

        for (Command command : commands) {
            router.on(command.getName(),update -> command.execute(bot,update) );
        }

        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                router.handle(update);
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

}
