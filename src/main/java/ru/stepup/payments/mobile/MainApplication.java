package ru.stepup.payments.mobile;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Point point1=new Point1(3);
        List props1=new ArrayList<>();
        props1.add(new Color(255,0,0)); //Red
        Point smartPoint1 = new SmartPoint(point1,props1); //Точка в координате 3, красного цвета

        Point point2=new Point3(4,2,5);
        List props2=new ArrayList<>();
        props1.add(LocalTime.of(11,0)); //Red
        Point smartPoint2 = new SmartPoint(point2,props2); // Точка в координате {4,2,5} в 11:00

        Point point3=new Point2(7,7);
        List props3=new ArrayList<>();
        props3.add(LocalTime.of(15,35)); //
        props3.add(new Color(250,250,55)); //Yellow
        Point smartPoint3 = new SmartPoint(point3,props2); //Точка в координате {7,7} в 15:35, желтого цвета
    }
}
