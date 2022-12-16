package ru.stepup.payments.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Bird sparrow=new Sparrow();
        sparrow.sing();

        System.out.println("---------------------------");

        Bird cuckoo=new Cuckoo();
        cuckoo.sing();

        System.out.println("---------------------------");
        Bird parrot = new Parrot("Попка дурак");
        parrot.sing();
    }

}
