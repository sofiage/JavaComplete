package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DrawingTool drawingTool = new DrawingTool();

        drawingTool.addShape(new Rectangle(5, 15));
        drawingTool.addShape(new Square(4));
        drawingTool.addShape((new Circle(3.8)));
        drawingTool.addShape(new Triangle(4, 5, 10));

        drawingTool.addShape(new Rectangle(10, 6)); //This is a duplicate and will print a message


        drawingTool.displayShapes();
        System.out.println("The total amount of the surface is " + drawingTool.calculateTotalOfSurface());
        System.out.println("The total amount of the perimeter is " + drawingTool.calculateTotalOfPerimeter());

    }
}
