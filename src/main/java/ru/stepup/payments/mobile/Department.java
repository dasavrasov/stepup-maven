package ru.stepup.payments.mobile;

public class Department {
    private final String name;
    private Employee boss;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        if (boss.getDepartment()!=this)
            throw new IllegalArgumentException("Начальник отдела всегда работает в том отделе, где он начальник");
        this.boss = boss;
    }
}
