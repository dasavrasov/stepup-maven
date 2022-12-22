package ru.stepup.payments.mobile;

import java.util.Arrays;
import java.util.List;

public class Polyline {
    Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    public double length(){
        double sum=0,len1,len2;
        for (int i = 0; i < points.length-1; i++) {
            len1=points[i].x-points[i+1].x;
            len2=points[i].y-points[i+1].y;
            sum+=Math.sqrt(len1*len1+len2*len2);
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polyline polyline = (Polyline) o;
        List<Point> points1=Arrays.asList(points); //this
        List<Point> points2=Arrays.asList(polyline.points); //o
        //проверить что все точки первой линии есть у второй
        for (Point point:points1) {
            if (!points2.contains(point)) {
                return false;
            }
        }
        //проверить что все точки второй линии есть у первой
        for (Point point:points2) {
            if (!points1.contains(point))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }
}
