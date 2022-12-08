package ru.stepup.payments.mobile;

public class Line {
    Point p1;
    Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.p1.x=x1;
        this.p1.y=y1;
        this.p2.x=x2;
        this.p2.y=y2;
    }

    @Override
    public String toString() {
        return "Линия от " + p1 + " до " + p2;
    }

    public double len()
    {
        return Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
    }

}
