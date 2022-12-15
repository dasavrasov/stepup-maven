package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        // Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}
        Polyline polyline=new Polyline(Arrays.asList(new Point(1,5),new Point(2,8),new Point(5,3),new Point(8,9)));
        //System.out.println(polyline.len());
        List<LengthCounter> listPoly = new ArrayList<>();
        listPoly.add(polyline);
        System.out.println("Длина простой ломаной "+getLength(listPoly));
        CircledPolyline circledPolyline=new CircledPolyline(Arrays.asList(new Point(1,5),new Point(2,8),new Point(5,3),new Point(8,9)));
        List<LengthCounter> circledlistPoly = new ArrayList<>();
        circledlistPoly.add(circledPolyline);
        System.out.println("Длина замкнутой ломаной "+getLength(circledlistPoly));
    }

    public static double getLength(List<LengthCounter> objList) {
        double len=0;
        for (LengthCounter obj : objList) {
            len+= obj.len();
        }
        return len;
    }
}
