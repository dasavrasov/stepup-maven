package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication{
    public static void main(String[] args)  throws Exception {
        Sauce sauce1=new Sauce("Heinz",Spicy.HIGH);
        System.out.println(sauce1);
        Sauce sauce2=new Sauce("Baltimor",Spicy.MEDIUM);
        System.out.println(sauce2);
        Sauce sauce3=new Sauce("Tkemali",Spicy.LOW);
        System.out.println(sauce3);
    }
}
