package ru.courses.office;

public class Department {
    final String name;
    Employee boss;

    public Department(String name) {
        this.name = name;
    }

    public void setBoss(Employee boss) {
        if (boss.department!=this)
            throw new IllegalArgumentException("Начальник отдела всегда работает в том отделе, где он начальник");
        this.boss = boss;
    }
}
