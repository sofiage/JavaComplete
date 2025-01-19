package org.example;

public class Rectangle implements Shapable{
    public double length;
    public double width;

    public Rectangle(double length, double width) {
        this.length = (length > 0) ? length : 0;
        this.width = (width > 0) ? width : 0;
    }

    @Override
    public double calculateSurface(){

        return length * width;
    }

    @Override
    public double calculatePerimeter() {

        return 2 * (length + width);
    }
}
