package ru.stepup.payments.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Number> list1=new ArrayList<>();
        list1.add(2);
        list1.add(Fraction.of(3,5));
        list1.add(2.3);
        System.out.println("Результат сложения:"+summa(list1));

        System.out.println("========================================");
        list1.clear();
        list1.add(3.6);
        list1.add(Fraction.of(49,12));
        list1.add(3);
        list1.add(Fraction.of(3,2));
        System.out.println("Результат сложения:"+summa(list1));
        System.out.println("========================================");
        list1.clear();
        list1.add(Fraction.of(1,3));
        list1.add(1);
        System.out.println("Результат сложения:"+summa(list1));

    }

    public static double getLength(List<LengthCounter> objList) {
        double len=0;
        for (LengthCounter obj : objList) {
            len+= obj.length();
        }
        return len;
    }

    public static Double summa(List<Number> numbers){
        Double res=new Double(0);
        for (Number num: numbers) {
            res+=num.doubleValue();
        }
        return res;
    }
}
