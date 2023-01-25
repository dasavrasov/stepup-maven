package ru.stepup.payments.mobile;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum {
    public static void main(String[] args) throws IllegalAccessException {
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));

        System.out.println(cat);
        nullAllFields(cat);
        System.out.println(cat);

        Dog dog = new Dog("Sharik",5);

        System.out.println(dog);
        nullAllFields(dog);
        System.out.println(dog);


    }

    static void nullAllFields(Object obj) throws IllegalAccessException{
        for (Field field: obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().getName().equals("int") || field.getType().getName().equals("long") || field.getType().getName().equals("double"))
                field.set(obj,0);
            else
                field.set(obj,null);
        }
    }
}
