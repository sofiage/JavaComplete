package org.quiz;


import java.util.HashSet;
import java.util.Set;

public class DrawingTool {
    private Set<String> addedTypes = new HashSet<>();
    Set<Shapable> shapes = new HashSet<>();


    public boolean addShape(Shapable shape) {
        if (addedTypes.contains((shape.getClass().getSimpleName()))) {
            System.out.println("Duplicate shape type!!! " + shape.getClass().getSimpleName() + " is already added");
            return false;
        } else {
            addedTypes.add(shape.getClass().getSimpleName());
            shapes.add(shape);
            return true;
        }
    }

    public double calculateTotalOfSurface() {
        double totalSurface = 1;
        for(Shapable shape: shapes){
            totalSurface *= shape.calculateSurface();
        }
        return totalSurface;
    }

    public double calculateTotalOfPerimeter() {
        double totalPerimeter = 0;
        for(Shapable shape: shapes){
            totalPerimeter += shape.calculatePerimeter();
        }
        return totalPerimeter;
    }

    public void displayShapes() {
        for (Shapable shape: shapes){
            System.out.println(shape.getClass().getSimpleName() + " Surface: " + shape.calculateSurface() + " Perimeter: "  + shape.calculatePerimeter());
        }
    }
}
