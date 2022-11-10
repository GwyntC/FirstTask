package org.shapes;

public class Cylinder implements Shape {
    private double h;
    private double r;

    public Cylinder(double r,double h) {
        this.r=r;
        this.h=h;
    }

    @Override
    public double getVolume() {
      return  Math.PI*Math.pow(r,2)*h;
    }
}
