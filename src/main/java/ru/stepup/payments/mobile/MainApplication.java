package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        //f1 это одна треть, f2 две пятых, а f3 это семь восьмых
        Fraction f1=Fraction.of(1,3);
        Fraction f2=Fraction.of(2,5);
        Fraction f3=Fraction.of(7,8);

        //Посчитать f1.sum(f2).sum(f3).minus(5)
        System.out.println("Результат: "+f1.sum(f2).sum(f3).minus(5));
    }
}
