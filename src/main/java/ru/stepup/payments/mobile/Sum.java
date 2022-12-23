package ru.stepup.payments.mobile;

public class Sum {
    public static void main(String[] args)  throws Exception {
        double sum=0;
        double par=0;
        for (String arg:args) {
            try {
                par=Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                par=0;
            }
            sum+=par;
        }
        System.out.println("Результат: "+sum);
    }
}
