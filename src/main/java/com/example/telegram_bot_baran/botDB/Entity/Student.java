//package com.example.telegram_bot_baran.botDB.Entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "students")
//@Getter
//@Setter
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "student_name", unique = true, nullable = false)
//    private String name;
//
//    @Column(name = "student_age")
//    private Integer age;
//
//    public Student() {}
//
//    public Student(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
