package ru.courses.main;

import java.util.Scanner;
import static java.lang.Math.*;
import static java.lang.Integer.*;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Результат: "+pow2(args[0],args[1]));
    }

    public static double pow2(String x, String y){
        return pow(parseInt(x),parseInt(y));
    }
}
