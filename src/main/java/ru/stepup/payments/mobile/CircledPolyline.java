package ru.stepup.payments.mobile;

import java.util.List;

public class CircledPolyline extends Polyline{
    public CircledPolyline(List<Point> points) {
        super(points);
    }

    @Override
    public double len() {
        Line lastLine = new Line(this.points.get(0),this.points.get(points.size()-1)); //линия соединяющая начало и конец
        return super.len()+lastLine.len();
    }
}
