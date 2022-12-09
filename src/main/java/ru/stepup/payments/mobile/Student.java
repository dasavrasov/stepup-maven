package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades=new ArrayList<>();

    private Student(String name) {
        this.name = name;
    }

    private Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public static Student of(String name){
        return new Student(name);
    }
    public static Student of(String name, List<Integer> grades){
        return new Student(name,grades);
    }

    @Override
    public String toString() {
        return name + " " + Arrays.toString(grades.toArray());
    }

    public String getName() {
        return name;
    }

    public void addGrage(int grade){
        if (grade<1 || grade>5)
            throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");
        this.grades.add(grade);
    }

    public List<Integer> getGrades() {
        return grades;
    }
}
