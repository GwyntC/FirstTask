package org.shapes;

public class Sphere implements IShape{
    double r;
    double pi=3.14;
    public Sphere(double r){
        this.r=r;
    }
    @Override
    public double getVolume() {
        return 4/3*pi*Math.pow(r,3);
    }
}
