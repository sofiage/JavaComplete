package org.drawing;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawingToolTest {
    @Test
    public void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle(10.5, 12);
        assertEquals(45, rectangle.calculatePerimeter(), 0.01);
    }
    @Test
    public void testSquarePerimeter() {
        Square square = new Square(6.7);
        assertEquals(26.8, square.calculatePerimeter(), 0.01);
    }
    @Test
    public void testTrianglePerimeter() {
        Triangle triangle = new Triangle(2, 4, 8, 9.1, 15.1);
        assertEquals(8.0, triangle.calculatePerimeter(), 0.01);
    }
    @Test
    public void testCirclePerimeter() {
        Circle circle = new Circle(12.8);
        assertEquals(80.42, circle.calculatePerimeter(), 0.01);
    }
    @Test
    //Surface Calculation Tests for each shape
    public void testRectangleSurface() {
        Rectangle rectangle = new Rectangle(12.3, 15.8);
        assertEquals(194.34, rectangle.calculateSurface(), 0.01);
    }
    @Test
    public void testSquareSurface() {
        Square square = new Square(10.4);
        assertEquals(108.16, square.calculateSurface(), 0.01);
    }
    @Test
    public void testTriangleSurface() {
        Triangle triangle = new Triangle(2, 4, 8, 9.1, 15.1);
        assertEquals(68.70, triangle.calculateSurface(), 0.01);
    }
    @Test
    public void testCircleSurface() {
        Circle circle = new Circle(10.14);
        assertEquals(323.01, circle.calculateSurface(), 0.01);
    }

    //Test unique and duplicate values // THESE ARE NOT REQUIRED WHEN USING HASHSETS SINCE SETS DO NOT ACCEPT DUPLICATES BUT ARE WRITTEN TO COMPLY WITH THE REQUIREMENT
    @Test
    public void testAddUniqueShape() {
        DrawingTool drawingTool = new DrawingTool();

        Shapable rectangle = new Rectangle(10, 15);
        Shapable circle = new Circle(7.9);
        Shapable square = new Square(10);
        Shapable triangle = new Triangle(1, 6, 9, 11, 12);


        assertEquals(true, drawingTool.addShape(rectangle));
        assertEquals(true, drawingTool.addShape(circle));
        assertEquals(true, drawingTool.addShape(square));
        assertEquals(true, drawingTool.addShape(triangle));
        assertEquals(4, drawingTool.shapes.size());

    }

    @Test
    public void testAddDuplicateShape() {
        DrawingTool drawingTool = new DrawingTool();
        Shapable rectangle1 = new Rectangle(10, 15);
        Shapable rectangle2 = new Rectangle(10, 18);

        assertEquals(true, drawingTool.addShape(rectangle1));
        assertEquals(false, drawingTool.addShape(rectangle2));
    }

    @Test
    public void testCalculateTotalOfSurface() {
        DrawingTool drawingTool = new DrawingTool();

        Shapable rectangle = new Rectangle(10, 15);
        Shapable square = new Square(10);
        Shapable triangle = new Triangle(1, 6, 9, 11, 12);
        Shapable circle = new Circle(5);

        drawingTool.addShape(rectangle);
        drawingTool.addShape(triangle);
        drawingTool.addShape(square);
        drawingTool.addShape(circle);

        double totalExpectedSurface = 7.775441817634739E7;
        assertEquals(totalExpectedSurface, drawingTool.calculateTotalOfSurface(), 0.01);
    }

    @Test
    public void testCalculateTotalOfPerimeter() {
        DrawingTool drawingTool = new DrawingTool();

        Shapable rectangle = new Rectangle(10, 15);
        Shapable square = new Square(10);
        Shapable triangle = new Triangle(1, 6, 9, 11, 12);
        Shapable circle = new Circle(9.3);

        drawingTool.addShape(rectangle);
        drawingTool.addShape(triangle);
        drawingTool.addShape(square);
        drawingTool.addShape(circle);

        double totalExpectedPerimeter = 156.43;
        assertEquals(totalExpectedPerimeter, drawingTool.calculateTotalOfPerimeter(), 0.01);
    }

    @Test
    public void testZeroInputForPerimeter(){
        Circle circle = new Circle(0);
        double perimeter = circle.calculatePerimeter();
        assertEquals(0.0,perimeter, 0.01);
    }

    @Test
    public void testNegativeInputForSurface(){
        Rectangle rectangle = new Rectangle(-1.0, 15.0);
        double surface = rectangle.calculateSurface();
        assertEquals(0.0, surface, 0.01);
    }
}
