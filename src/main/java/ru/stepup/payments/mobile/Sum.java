package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.List;

public class Sum {
    public static void main(String[] args){
    }

    public static void reverse(ArrayList<Integer> intList) {
        int n = intList.size() - 1;
        for (int i = 0; i < intList.size() / 2; i++) {
            int temp = intList.get(i);
            intList.set(i,intList.get(n - i));
            intList.set(n - i,temp);
        }
    }
    public static void bubbleSort(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j]=intArray[j + 1];
                    intArray[j + 1]= temp;
                }
            }
        }
    }

    public static void task1() {
        int N=20;
        int j;
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<N;i++)
            list.add(i);

        for(int i=0;i<N;i+=2){
            j=list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1,j);
        }

        System.out.println(list);
    }
}
