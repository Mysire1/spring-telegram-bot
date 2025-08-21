package com.example.telegram_bot_baran.repository;

import com.example.telegram_bot_baran.botDB.Entity.BotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotRepository extends JpaRepository<BotEntity, Long> {
    Optional<BotEntity> findByChatid(Long chatid);
}
