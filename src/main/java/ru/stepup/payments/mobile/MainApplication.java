package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        MyString myString=new MyString("Hello World");
        List<LengthCounter> list=new ArrayList<>();
        list.add(myString);
        System.out.println("Результат "+getLength(list));

    }

    public static int getLength(List<LengthCounter> objList) {
        int len=0;
        for (LengthCounter obj : objList) {
            len+= obj.length();
        }
        return len;
    }
}
