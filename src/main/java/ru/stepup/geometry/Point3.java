package ru.stepup.geometry;

public class Point3 extends Point{
    private int z;

    public Point3(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }
}
