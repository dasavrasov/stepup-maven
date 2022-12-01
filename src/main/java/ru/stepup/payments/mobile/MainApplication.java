package ru.stepup.payments.mobile;

import java.io.File;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        int num=0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists || isDirectory) {
                System.out.println("Файл не существует либо указан путь к папке, а не к файлу");
                continue;
            }
            System.out.println("Путь указан верно");
            num++;
            System.out.println("Это файл номер "+num);
        }
    }

    public static int abs(int x){
        return x>0?x:-x;
    };

    public static int safeDiv(int x, int y){
        if (y==0)
            return 0;
        return x/y;
    }

    public static int max(int x, int y){
        return x>y?x:y;
    }

    public static String makeDecision(int x, int y){
        if (x>y)
            return x+" > "+y;
        else if (x<y)
            return x+" < "+y;
        else
            return x+" == "+y;
    }

    public static int max3(int x, int y, int z){
        if (x>y && x>z)
            return x;
        else if (y>z)
            return y;
        return z;
    }

    public static boolean sum3(int x, int y, int z){
        if (x+y==z)
            return true;
        if (x+z==y)
            return true;
        if (y+z==x)
            return true;
        return false;
    }

    public static int sum2(int x, int y){
        if (x+y>=10 && x+y<=19)
            return 20;
        return x+y;
    }

    public static boolean is35(int x){
        if (x%3 == 0 || x%5 == 0)
            return true;
        return false;
    }

    public static boolean magic6(int x, int y){
        if (x==6 || y==6 || x+y==6 || x-y==6)
            return true;
        return false;
    }

    public static String age(int x){
        if (x%10 ==1 && x%100!=11)
            return x+" год";
        if (x%10 >=2 && x%10 <=4 && !(x%100>=12  && x%100<=14))
            return x+" года";
        return x+" лет";
    }

    public static String day(int x){
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default:return "это не день недели";
        }
    }

    public static void printDays(String x){
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                return;
            default:System.out.println("это не день недели");
        }
    }

    public static String listNums(int x){
        String s="";
        for (int i=0;i<=x;i++)
            if (i<x)
                s=s+i+" ";
            else
                s=s+i;
        return s;
    }

    public static String reverseListNums(int x){
        String s="";
        for (int i=x;i>=0;i--)
            if (i>0)
                s=s+i+" ";
            else
                s=s+i;
        return s;
    }

    public static String chet(int x){
        String s="";
        for (int i=0;i<=x;i+=2)
            if (i<x)
                s=s+i+" ";
            else
                s=s+i;
        return s;
    }

    public static int pow(int x, int y){
        int r=1;
        for(int i=1;i<=y;i++) {
            r = r * x;
        }
        return r;
    }

    public static int numLen(long x){
        int num=1;
        for(int i=10;x!=x%i;i*=10)
            num++;
        return num;
    }

    public static boolean equalNum(int x){
        int first=x%10; // первая цифра
        for(int i=10;x%(i*10)/i>0;i*=10)
            if (x%(i*10)/i!=first)
                return false;
        return true;
    }

    public static void square(int x){
        for(int j=0;j<x;j++) {
            for (int i = 0; i < x; i++)
                System.out.print("*");
            System.out.println("");
        }
    }

    public static void leftTriangle(int x){
        for(int j=1;j<=x;j++) {
            for (int i = 0; i < j; i++)
                System.out.print("*");
            System.out.println("");
        }
    }

    public static void rightTriangle(int x) {
        for (int j = 1; j <= x; j++) {
            for (int k = 0; k <= x-j; k++)
                System.out.print(" ");
            for (int i = 0; i < j; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void guessGame() {
        int randomNum = 3;
        boolean flag=true;
        int tryNnumber=0;

        while (flag) {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.println("What number am I thinking (0 to 9)? :");
            int x = sc.nextInt();
            if (x != randomNum) {
                System.out.println("No, try again");
            } else {
                System.out.println("Yes, it`s " + randomNum);
                flag=false;
            }
            tryNnumber++;
        }
        System.out.println("Кол-во попыток:"+tryNnumber);
    }
}
