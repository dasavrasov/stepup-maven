package ru.stepup.payments.mobile;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Bird> birds = new ArrayList<>();
        birds.add(new Sparrow());
        birds.add(new Cuckoo());
        birds.add(new Cuckoo());
        birds.add(new Sparrow());
        birds.add(new Parrot("Попка дурак"));
        birds.add(new Sparrow());
        birds.add(new Parrot("Жираф большой ему видней"));

        BirdsInTheForest(birds);
    }

    public static void BirdsInTheForest(List<Bird> birds){
        for (Bird bird: birds) {
            bird.sing();
        }
    }

}
