package ru.stepup.payments.mobile;

import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");
        Town e = new Town("E");
        Town f = new Town("F");
        a.addRoute(b,5);
        a.addRoute(d,6);
        a.addRoute(f,1);

        b.addRoute(a,5);
        b.addRoute(c,3);

        c.addRoute(b,3);
        c.addRoute(d,4);

        d.addRoute(a,6);
        d.addRoute(e,2);
        d.addRoute(c,4);

        e.addRoute(d,2);
        e.addRoute(f,2);

        f.addRoute(e,2);
        f.addRoute(b,1);

        System.out.println("Задача 1: Если передано число 1, результат должен быть либо A, либо С");
        System.out.println("Ответ:");
        System.out.println(b.travel(1));
        System.out.println("=====================================================================");
        System.out.println("Задача 2: Если передано число 2, результат должен быть либо B, либо D, либо F");
        System.out.println("Ответ:");
        System.out.println(b.travel(2));
        System.out.println("=====================================================================");
        System.out.println("Задача 3: Если передано число 3, результат может быть любом городом в зависимости от порядка следования путей в списках таковых у городов");
        System.out.println("Ответ:");
        System.out.println(b.travel(3));

        System.out.println("Задача 4: Настройте объекты городов так, чтобы при передаче числа 3 последним городом оказался город A");
        d.delRoute(e); //убрали маршрут B-C-D-E
        b.delRoute(a); //убрали маршрут B-A-D-C
        c.delRoute(b); //убрали маршрут B-C-B-C
        System.out.println("Ответ:");
        System.out.println(b.travel(3));

    }
}
