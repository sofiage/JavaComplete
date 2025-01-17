package org.example;

public class Triangle implements Shapable {
    double x;
    double y;
    double z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double calculatePerimeter() {

        return x+y+x;
    }

    @Override
    public double calculateSurface() {
        double surface = (x+y+x)/2;
        return Math.sqrt(surface*(surface-x)) * (surface-y)  * (surface-z);
    }
}
