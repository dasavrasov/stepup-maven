package ru.stepup.payments.mobile;

public class AccountNumberGenerator {
    private static int num = 0;

    public static  int getNext(){
        return num++;
    }

    public static int getCurrent(){
        return num;
    }

    public static void reset(){
        num = 0;
    }
}
