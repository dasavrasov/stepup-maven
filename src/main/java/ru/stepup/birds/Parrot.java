package ru.stepup.birds;

public class Parrot extends Bird{
    public Parrot(String text) {
        super.setText(text);
    }

    @Override
    public void sing() {
        //путаем буквы
        int ind1= getRandomNumber(0,text.length()-1);
        int ind2= getRandomNumber(0,text.length()-1);
        char letter1 = text.charAt(ind1);
        char letter2 = text.charAt(ind2);
        char[] textArr=text.toCharArray();
        textArr[ind1]=letter2;
        textArr[ind2]=letter1;
        text=String.valueOf(textArr);
        super.sing();
    }
}
