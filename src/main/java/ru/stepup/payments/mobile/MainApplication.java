package ru.stepup.payments.mobile;

public class MainApplication{
    public static void main(String[] args)  throws Exception {
        System.out.println(ArithmeticOper.ADD.op(1,2));
        System.out.println(ArithmeticOper.SUBTRACT.op(5,2));
        System.out.println(ArithmeticOper.MULTIPLY.op(5,2));
        System.out.println(ArithmeticOper.DIVIDE.op(6,2));
    }
}
