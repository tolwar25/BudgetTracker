package org.example;

public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String greeting() {
        return "Hello, I am " + name;
    }

    public static void study() {
        System.out.println("Я учусь");
    }
}
