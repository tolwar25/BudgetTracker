package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Хеллоу Ворлд");
        Student s1 = new Student("Petya");
        Student s2 = new Student("Sanya");
        Student.study();
        System.out.println(s1.greeting());
        System.out.println(s2.greeting());
    }

}