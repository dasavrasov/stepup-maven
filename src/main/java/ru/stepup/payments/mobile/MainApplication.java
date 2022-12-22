package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication{
    public static void main(String[] args)  throws Exception {
        Fraction fr1 = Fraction.of(3,4);
        Fraction fr2 = Fraction.of(3,4);
        System.out.println(fr1==fr2);
        System.out.println(fr1.equals(fr2));

        Fraction fr3=fr1.clone();
        System.out.println(fr3);
        System.out.println("==========================================");

        Point point1 = new Point(3,4);
        Point point2 = new Point(3,4);
        System.out.println(point2.equals(point1));
        Point point3 = point1.clone();
        System.out.println(point3);
    }
}
