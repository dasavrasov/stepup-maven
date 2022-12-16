package ru.stepup.birds;

//Кукушка
public class Cuckoo extends Bird{
    {
        text="ку-ку";
    }

    @Override
    public void sing() {
        for (int i = 0; i<= getRandomNumber(1,10); i++)
            super.sing();
    }
}
