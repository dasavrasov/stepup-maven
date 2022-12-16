package ru.stepup.payments.mobile;

import java.util.Random;

//Кукушка
public class Cuckoo extends Bird{
    {
        text="ку-ку";
    }

    @Override
    public void sing() {
        for (int i=0;i<=Bird.getRandomNumber(1,10);i++)
            super.sing();
    }
}
