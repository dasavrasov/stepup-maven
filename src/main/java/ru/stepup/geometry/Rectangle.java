package ru.stepup.geometry;

public class Rectangle extends Figure{
    int a;

    int b;

    public Rectangle(Point root, int a, int b) {
        this.root=root;
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a*b;
    }
}
