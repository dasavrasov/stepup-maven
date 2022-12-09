package ru.stepup.payments.mobile;

public class Route {
    Town dest; //город
    int cost; //стоимость поездки в него

    public Route(Town dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[" + dest.name + ", " + cost + "]";
    }
}
