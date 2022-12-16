package ru.stepup.payments.mobile;

import java.util.List;

public class SmartPoint implements Point{
    Point point;
    List props;

    public SmartPoint(Point point, List props) {
        this.point = point;
        this.props = props;
    }
}
