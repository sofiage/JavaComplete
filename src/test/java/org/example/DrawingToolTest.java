package org.example;

import junit.framework.TestCase;

public class DrawingToolTest extends TestCase {

    public void testAddUniqueShape() {
        DrawingTool drawingTool = new DrawingTool();

        Shapable rectangle = new Rectangle(10, 15);
        Shapable circle = new Circle(7.9);
        Shapable square = new Square(10);
        Shapable triangle = new Triangle(1, 6, 9);


        assertEquals(true, drawingTool.addShape(rectangle));
        assertEquals(true, drawingTool.addShape(circle));
        assertEquals(true, drawingTool.addShape(square));
        assertEquals(true, drawingTool.addShape(triangle));

    }

    public void testAddDuplicatedShape(){
        DrawingTool drawingTool = new DrawingTool();
        Shapable rectangle1 = new Rectangle(10, 15);
        Shapable rectangle2 = new Rectangle(10, 18);

        assertEquals(true, drawingTool.addShape(rectangle1));
        assertEquals(false,drawingTool.addShape(rectangle2));
    }

    public void testCalculateTotalOfSurface() {
        DrawingTool drawingTool = new DrawingTool();

        Shapable rectangle = new Rectangle(10, 15);
        Shapable square = new Square(10);
        Shapable triangle = new Triangle(1, 6, 9);

        drawingTool.addShape(rectangle);
        drawingTool.addShape(triangle);
        drawingTool.addShape(square);

        double totalExpectedSurface = 456.831;
        assertEquals(totalExpectedSurface, drawingTool.calculateTotalOfSurface(), 0.01);
    }

    public void testCalculateTotalOfPerimeter() {
        DrawingTool drawingTool = new DrawingTool();

        Shapable rectangle = new Rectangle(10, 15);
        Shapable square = new Square(10);
        Shapable triangle = new Triangle(1, 6, 9);

        drawingTool.addShape(rectangle);
        drawingTool.addShape(triangle);
        drawingTool.addShape(square);

        double totalExpectedPerimeter = 50 + 49.6 + 40 + 16;
        assertEquals(totalExpectedPerimeter, drawingTool.calculateTotalOfPerimeter(), 0.01);
    }

    public void invalidInput(){

    }
}