package ru.stepup.payments.mobile;

public class Employee {
    private final String name;

    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (this.department!=null && this.department.getBoss()==this && this.department!=department)
            throw new IllegalArgumentException("Начальник отдела всегда работает в том отделе, где он начальник");
        this.department = department;
    }

    @Override
    public String toString() {
        String str = name;
        if (department == null)
            return str;
        if (department.getBoss()!=null && department.getBoss()==this) // это начальник
            str+=" начальник отдела "+department.getName();
        else
        {
            str+=" работает в отделе "+ department.getName();
            if (department.getBoss()!=null)
                str+=" начальник которого "+ this.department.getBoss().name;
        }
        return str;
    }
}
