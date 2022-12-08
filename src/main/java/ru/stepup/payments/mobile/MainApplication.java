package ru.stepup.payments.mobile;

import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(1,3),new Point(5,8));
        Line line2 = new Line(new Point(10,11),new Point(15,19));
        Line line3 = new Line(line1.p2, line2.p1);
        System.out.println(line3);

        line3.p1.x=line3.p1.x+1;
        line3.p1.y=line3.p1.y+1;
        line3.p2.x=line3.p2.x+1;
        line3.p2.y=line3.p2.y+1;

        System.out.println(line3);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line1.len()+ line2.len()+line3.len());
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
        if ((x%3 == 0 || x%5 == 0) && (x%15!=0))
            return true;
        return false;
    }

    public static boolean magic6(int x, int y){
        if (x==6 || y==6 || x+y==6 || x-y==6 || y-x==6)
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
        for(int i=10;abs(x%(i*10)/i)>0;i*=10)
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

    public static int findFirst(int[] arr, int x){
        for(int i=0;i<arr.length-1;i++)
            if (arr[i]==x)
                return i;
        return -1;
    }

    public static int findLast(int[] arr, int x){
        for(int i=arr.length-1;i>=0;i--)
            if (arr[i]==x)
                return i;
        return -1;
    }

    public static int maxAbs(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length-1;i++)
            if (abs(arr[i])>abs(max))
                max=arr[i];
        return max;
    }

    public static int countPositive(int[] arr){
        int cnt=0;
        for(int i=0;i<=arr.length-1;i++)
            if (arr[i]>0)
                cnt++;
        return cnt;
    }

    public static boolean palindrom(int[] arr){
        for(int i=0;i<=arr.length-1;i++)
           if (arr[i]!=arr[arr.length-1-i])
              return false;
        return true;
    }

//    public static void reverse(int[] arr){
//        for(int i=arr.length-1;i>0;i--)
//            System.out.print(arr[i]+" ");
//        System.out.println(arr[0]);
//    }

    public static void reverse(int[] arr){
        int[] arr2=new int[arr.length];
        for(int i=0;i<=arr.length-1;i++)
            arr2[i]=arr[arr.length-1-i];
        arr=arr2;
        System.out.println(Arrays.toString(arr));
    }
    public static int[] reverseBack(int[] arr){
        int[] arr2=new int[arr.length];
        for(int i=0;i<=arr.length-1;i++)
            arr2[i]=arr[arr.length-1-i];
        return arr2;
    }

    public static int[] concat(int[] arr1, int[] arr2){
        int[] arr3=new int[arr1.length+arr2.length];
        for(int i=0;i<=arr1.length-1;i++)
            arr3[i]=arr1[i];
        for(int i=0;i<=arr2.length-1;i++)
            arr3[i+arr1.length]=arr2[i];
        return arr3;
    }

    public static int[] findAll(int[] arr, int x){
        int[] arr2=new int[arr.length];
        int j=0;
        for(int i=0;i<=arr.length-1;i++)
            if (arr[i]==x) {
                arr2[j]=i;
                j++;
            }
        int[] arr3=new int[j];
        for(int i=0;i<j;i++)
            arr3[i]=arr2[i];
        return arr3;
    }

    public static int[] deleteNegative(int[] arr){
        int[] arr2=new int[arr.length];
        int j=0;
        for(int i=0;i<=arr.length-1;i++)
            if (arr[i]>=0) {
                arr2[j]=arr[i];
                j++;
            }
        int[] arr3=new int[j];
        for(int i=0;i<j;i++)
            arr3[i]=arr2[i];
        return arr3;
    }

    public static int[] add(int[] arr, int x, int pos){
        int[] arr2=new int[arr.length+1];
        for(int i=0;i<=arr.length-1;i++)
            if (i<pos)
                arr2[i]=arr[i];
            else if (i==pos)
                arr2[i]=x;
            else if (i>pos)
                arr2[i]=arr[i-1];
            arr2[arr.length]=arr[arr.length-1];
        return arr2;
    }

    public static int[] add(int[] arr, int[] ins, int pos){
        int[] arr2=new int[arr.length+ins.length];
        for(int i=0;i<=arr.length-1;i++)
            if (i<pos)
                arr2[i]=arr[i];
        for(int i=0;i<=ins.length-1;i++)
            arr2[i+pos]=ins[i];
        for(int i=pos;i<=arr.length-1;i++)
            arr2[pos+ins.length]=arr[i-1];
        arr2[arr.length+ins.length-1]=arr[arr.length-1];
        return arr2;
    }
}
