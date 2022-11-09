package org.shapes;

public class Cube implements IShape {
    private float width;
    @Override
    public double getVolume() {
        return Math.pow(width,3);
    }
}
