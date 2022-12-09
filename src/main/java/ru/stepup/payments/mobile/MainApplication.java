package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ivanov");
        Employee emp2 = new Employee("Petrov");
        Employee emp3 = new Employee("Sidorov");
        Department dep1 = new Department("IT");
        Department dep2 = new Department("Finance");
        Department dep3 = new Department("Market");
        emp1.setDepartment(dep1);
        emp2.setDepartment(dep1);
        emp3.setDepartment(dep1);
        dep1.setBoss(emp1);
//        dep2.setBoss(emp3);
        emp2.setDepartment(dep2);
        System.out.println(dep1);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
    }
}
