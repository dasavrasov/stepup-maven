package ru.stepup;

import ru.stepup.school.Student;

public class MainApplication {
    public static void main(String[] args) {
        Student student=new Student("Ivanov", grade -> {
            if (grade>=1 && grade<=100000 && grade%2==0)
                return true;
            return false;
        });
    }


}
