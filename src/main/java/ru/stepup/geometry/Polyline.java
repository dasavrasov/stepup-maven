package ru.stepup.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polyline implements LengthCounter{
    List<Point> points = new ArrayList<Point>();

    public Polyline() {
    }

    public Polyline(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        String str="Линия [";
        if (this.points.isEmpty())
            return null;
        for (int i = 0; i < this.points.size()-1; i++) {
            str+=this.points.get(i)+",";
        }
        str+=this.points.get(this.points.size()-1)+"]";
        return  str;
    }

    public List<Line> getLines(){
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.points.size()-1; i++) {
            lines.add(new Line(this.points.get(i),this.points.get(i+1)));
        }
        return lines;
    }

    public int length(){
        int len=0;
        List<Line> lines = getLines();
        for (Line line : lines) {
            len+= line.length();
        }
        return len;
    }
}
