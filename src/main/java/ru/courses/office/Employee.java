package ru.courses.office;

public class Employee {
    final String name;

    Department department;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public void setDepartment(Department department) {
        if (department!=null && department.boss==this && department!=department)
            throw new IllegalArgumentException("Начальник отдела всегда работает в том отделе, где он начальник");
        this.department = department;
    }

    @Override
    public String toString() {
        String str = name;
        if (department == null)
            return str;
        if (department.boss!=null && department.boss==this) // это начальник
            str+=" начальник отдела "+department.name;
        else
        {
            str+=" работает в отделе "+ department.name;
            if (department.boss!=null)
                str+=" начальник которого "+ department.name;
        }
        return str;
    }
}
