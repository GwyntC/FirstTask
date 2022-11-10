package org.shapes;

public class Cube implements IShape {
    double width;
    public Cube(double width)
    {
        this.width=width;
    }
    @Override
    public double getVolume() {
        return Math.pow(width,3);
    }
}
