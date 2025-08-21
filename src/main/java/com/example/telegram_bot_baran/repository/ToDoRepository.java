package com.example.telegram_bot_baran.repository;

import com.example.telegram_bot_baran.botDB.Entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    List<ToDoEntity> findByName(String name);
}