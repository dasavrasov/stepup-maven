package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Student student = Student.of("Vasya");
        student.addGrage(5);
        student.addGrage(2);
        student.addGrage(3);
        System.out.println(student);
        System.out.println(student.getGrades());
    }
}
