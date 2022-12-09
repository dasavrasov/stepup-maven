package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        // Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}
        Polyline polyline=new Polyline(Arrays.asList(new Point(1,5),new Point(2,8),new Point(5,3),new Point(8,9)));
        System.out.println(polyline);
        // Рассчитать длину Ломаной
        double polylen=polyline.len();
        System.out.println("Длина ломаной: "+polylen);
        //Получить у Ломаной массив Линий
        List<Line> lines=polyline.getLines();
        //Рассчитать длину массива Линий
        double length=0;
        for (Line line: lines) {
            length+=line.len();
        }
        System.out.println("Длина массива линий: "+length);

        //Сравнить длину Ломаной и массива Линий: они должны совпасть
        System.out.println("Результат сравнения длины массива линий и длины ломаной: ");
        System.out.println(length== polylen);
        //Сдвинуть координату Точки {2,8} таким образом, чтобы она стала иметь значение {12,8}.
        // Если изменения отразились в данной точке, в Ломаной и в двух Линиях массива (из пункта 3), то задача решена верно
        polyline.points.get(1).x=12;
        System.out.println(polyline);

    }
}
