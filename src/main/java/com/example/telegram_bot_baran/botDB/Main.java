//package com.example.telegram_bot_baran.botDB;
//
//import com.example.telegram_bot_baran.botDB.Entity.Student;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.telegram_bot_baran.botDB");
//
//        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
//        Session session = sessionFactory.openSession();
//
//
//
//
////        Student student = new Student("Vasya",22);
////        Student student2 = new Student("Andrii",25);
////        session.beginTransaction();
////        session.persist(student);
////        session.persist(student2);
////        session.getTransaction().commit();
////
////        Student studentById1 = session.createQuery(
////                "SELECT s FROM Student s WHERE s.id = :id", Student.class
////        ).setParameter("id",2).getSingleResult();
////
////        session.beginTransaction();
////
////        Student studentForUpdate = session.get(Student.class, 1L);
////        studentForUpdate.setAge(30);
////        studentForUpdate.setName("Dima");
////
////        session.getTransaction().commit();
////        List<Student> students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
////        System.out.println(students.toString());
////        session.beginTransaction();
////
////        session.getTransaction().commit();
//
//
//        session.close();
//    }
//}
