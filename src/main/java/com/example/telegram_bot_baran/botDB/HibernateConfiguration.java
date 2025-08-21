//package com.example.telegram_bot_baran.botDB;
//
//import com.example.telegram_bot_baran.botDB.Entity.BotEntity;
//import com.example.telegram_bot_baran.botDB.Entity.Student;
//import com.example.telegram_bot_baran.botDB.Entity.ToDoEntity;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class HibernateConfiguration {
//
//    @Bean
//    public SessionFactory sessionFactory() {
//        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//
//        configuration.addAnnotatedClasses(BotEntity.class, ToDoEntity.class)
//                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
//                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
//                .setProperty("hibernate.connection.username", "postgres")
//                .setProperty("hibernate.connection.password", "")
//                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
//                .setProperty("hibernate.show_sql", "true")
//                .setProperty("hibernate.hbm2ddl.auto", "create-update");
//
//        return configuration.buildSessionFactory();
//    }
//}
//
