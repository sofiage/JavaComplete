package org.quiz;

public class Circle implements Shapable {
    private final double radius;

    public Circle(double radius) {

        this.radius = radius;
    }

    @Override
    public double calculateSurface() {

        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {

        return 2 * Math.PI * radius;
    }
}
