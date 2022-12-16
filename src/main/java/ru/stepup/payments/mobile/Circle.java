package ru.stepup.payments.mobile;

public class Circle extends Figure{
    int radius;

    public Circle(Point root, int radius) {
        this.radius = radius;
    }

    @Override
    public double Area() {
        return Math.PI*radius*radius;
    }
}
