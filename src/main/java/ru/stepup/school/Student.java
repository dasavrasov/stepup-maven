package ru.stepup.school;

import java.util.ArrayList;
import java.util.List;

public final class Student{
    private List grades=new ArrayList<>();
    String name;

    Rule rule;

    public Student(String name, Rule rule) {
        this.name = name;
        this.rule=rule;
    }

    public void addGrade(int grade){
        if(rule.check()) grades.add(grade);
    }

    public String toString() {
        return "Student{" + " grades =" + grades + ", name=" + name + '}';
    }
}