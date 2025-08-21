package com.example.telegram_bot_baran.command.todocommands.todostore;

import java.util.*;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskStorage {

    private final Map<Long, List<String>> tasks = new HashMap<>();

    public void addTask(Long chatId, String task) {
        tasks.computeIfAbsent(chatId, k -> new ArrayList<>()).add(task.trim());
    }

    public List<String> getTasks(Long chatId) {
        return tasks.getOrDefault(chatId, Collections.emptyList());
    }

    public void clearTasks(Long chatId) {
        tasks.remove(chatId);
    }

    public boolean editTask(Long chatId, int index, String newText) {
        List<String> tasksM = tasks.get(chatId);
        if (tasksM != null && index >= 0 && index < tasksM.size()) {
            tasksM.set(index, newText);
            return true;
        }
        return false;
    }
}

