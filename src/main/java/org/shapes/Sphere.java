package org.shapes;

public class Sphere implements Shape {
    private double r;

    public Sphere(double r) {
        this.r=r;
    }

    @Override
    public double getVolume() {
        return 4/3*Math.PI*Math.pow(r,3);
    }
}
