package ru.stepup.payments.mobile;

public class MyString implements LengthCounter {
    private String value;

    public MyString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int length() {
        return value.length();
    }

    public void setValue(String value) {
        this.value = value;
    }
}
