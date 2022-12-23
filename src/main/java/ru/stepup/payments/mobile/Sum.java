package ru.stepup.payments.mobile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        try {
            System.out.println("Результат: " + divide("./src/main/resources/info.txt"));
        } catch (OperationAttemptException e) {
            System.out.println("Результат: 0");
        }
    }

    public static int divide(String fileName) throws OperationAttemptException {
        int result=0;
        File f = new File(fileName);

        try (Scanner sc = new Scanner(f)) {
            try {
                int i1=sc.nextInt();
                int i2 =sc.nextInt();
                result = i1/i2;
                return result;
            } catch (InputMismatchException e1) {
                throw new OperationAttemptException("вместо чисел в файле строки");
            } catch (NoSuchElementException e3) {
                throw new OperationAttemptException("файле менее двух чисел");
            } catch (ArithmeticException e4) {
                throw new OperationAttemptException("второе число нуль");
            }
        } catch (FileNotFoundException e) {
            throw new OperationAttemptException("файл не найден");
        }
    }
}
