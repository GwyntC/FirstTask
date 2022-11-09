package org.shapes;

import java.util.Comparator;

public class SortByVolume implements Comparator<IShape> {
    @Override
    public int compare(IShape o1, IShape o2) {
      return Double.compare(o1.getVolume(),o2.getVolume());
    }
}
