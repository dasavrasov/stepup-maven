package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Figure> figures=new ArrayList<>();
        figures.add(new Circle(new Point(1,3),5));
        figures.add(new Square(new Point(2,2),10));
        figures.add(new Square(new Point(2,2),4));
        figures.add(new Circle(new Point(1,3),3));
        System.out.println("Общая площадь "+totalArea(figures));
    }

    public static double totalArea(List<Figure> figures){
        double res=0;
        for (Figure figure: figures) {
            res+=figure.area();
        }
        return res;
    }

}
