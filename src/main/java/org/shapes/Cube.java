package org.shapes;

public class Cube implements Shape {
    private double width;

    public Cube(double width) {
        this.width=width;
    }

    @Override
    public double getVolume() {
        return Math.pow(width,3);
    }
}
