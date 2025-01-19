package org.example;

public class Triangle implements Shapable {
    double x;
    double y;
    double z;
    double base;
    double height;

    public Triangle(double x, double y, double z, double base, double height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return x+y+x;
    }

    @Override
    public double calculateSurface() {
       return 0.5 * base * height;
    }
}
