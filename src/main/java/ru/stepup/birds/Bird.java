package ru.stepup.birds;

public abstract class Bird {
    String text;

    public void sing(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
