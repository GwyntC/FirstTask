package org.shapes;

public class Cylinder implements IShape{
    double h;
    double r;
    double pi=3.14;
    public Cylinder(double r,double h){
        this.r=r;
        this.h=h;
    }
    @Override
    public double getVolume() {
      return  pi*Math.pow(r,2)*h;
    }
}
