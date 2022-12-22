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

        System.out.println("==========================================");

        Line line1 = new Line(point1,point2);
        Line line2 = new Line(point2,point1);
        //        Line line2 = new Line(point1.clone(),point2.clone());
        System.out.println(line2.equals(line1));
        Line line3=line1.clone();
        System.out.println(line3.equals(line1));

        System.out.println("==========================================");

        int[] arr={1,2,3,4};

        Point[] points1= {new Point(1,5),new Point(2,8),new Point(5,3),new Point(8,9)};
        Point[] points2= {new Point(8,9), new Point(1,5),new Point(2,8),new Point(5,3)};
        Polyline polyline1=new Polyline(points1);
        Polyline polyline2=new Polyline(points2);

        System.out.println(polyline1.equals(polyline2));

    }
}
