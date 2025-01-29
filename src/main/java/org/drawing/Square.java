package org.drawing;

public class Square implements Shapable{
    private double side;

    public Square(double side) {

        this.side = side;
    }

    @Override
    public double calculateSurface() {

        return side * side;
    }

    @Override
    public double calculatePerimeter() {

        return 4 * side;
    }
}
