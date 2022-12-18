package ru.stepup.payments.mobile;

public class Square {
    private Point leftUpCorner;
    private int side;

    public Square(Point leftUpCorner, int side) {
        checkSide(side);
        this.leftUpCorner = leftUpCorner;
        this.side = side;
    }

    public Point getLeftUpCorner() {
        return leftUpCorner;
    }

    public int getSide() {
        return side;
    }

    public void setLeftUpCorner(Point leftUpCorner) {
        this.leftUpCorner = leftUpCorner;
    }

    public void setSide(int side) {
        checkSide(side);
        this.side = side;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + this.leftUpCorner + " со стороной " + side;
    }

    private void checkSide(int side) throws IllegalArgumentException{
        if (side<=0)
            throw new IllegalArgumentException("Длина стороны обязана быть всегда положительной");
    }
}
