package org.shapes;

import java.util.Comparator;

public class SortByVolume implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {

        return Double.compare(o1.getVolume(),o2.getVolume());
    }
}
