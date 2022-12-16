package ru.courses;

import ru.courses.office.Department;
import ru.courses.office.Employee;

public class MainApplication {
    public static void main(String[] args) {
        Employee employee=new Employee("Ivanov");
        Department department=new Department("IT");
        employee.setDepartment(department);
        department.setBoss(employee);
        System.out.println(employee);
    }


}
