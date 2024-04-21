//*************************************************************************
// Title : A Java program to demonstrate Single Responsibility Principle.
// Author: Audity Saha, Undergraduate student, Khulna University.
//*************************************************************************

/**
 * This class represents a simple Circle.
 */
class Circle {
    private double radius;

    /**
     * Constructs a new Circle object with the given radius.
     *
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Retrieves the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }
}

/**
 * This class represents a simple Triangle.
 */
class Triangle {
    private double base;
    private double height;

    /**
     * Constructs a new Triangle object with the given base and height.
     *
     * @param base   The base of the triangle.
     * @param height The height of the triangle.
     */
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * Retrieves the base of the triangle.
     *
     * @return The base of the triangle.
     */
    public double getBase() {
        return base;
    }

    /**
     * Retrieves the height of the triangle.
     *
     * @return The height of the triangle.
     */
    public double getHeight() {
        return height;
    }
}

/**
 * This class represents a simple Rectangle.
 */
class Rectangle {
    private double length;
    private double width;

    /**
     * Constructs a new Rectangle object with the given length and width.
     *
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Retrieves the length of the rectangle.
     *
     * @return The length of the rectangle.
     */
    public double getLength() {
        return length;
    }

    /**
     * Retrieves the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }
}

/**
 * This class represents a simple ShapePrinter.
 */
class ShapePrinter {

    /**
     * Prints the details of a circle.
     *
     * @param circle The circle whose details to print.
     */
    public void printCircleDetails(Circle circle) {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + circle.getRadius());
    }

    /**
     * Prints the details of a triangle.
     *
     * @param triangle The triangle whose details to print.
     */
    public void printTriangleDetails(Triangle triangle) {
        System.out.println("Triangle Details:");
        System.out.println("Base: " + triangle.getBase());
        System.out.println("Height: " + triangle.getHeight());
    }

    /**
     * Prints the details of a rectangle.
     *
     * @param rectangle The rectangle whose details to print.
     */
    public void printRectangleDetails(Rectangle rectangle) {
        System.out.println("Rectangle Details:");
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Width: " + rectangle.getWidth());
    }
}

/**
 * This class demonstrates the usage of Circle, Triangle, Rectangle, and ShapePrinter classes.
 */
class ShapeDemo {
    public static void main(String[] args) {
        // Create a circle, triangle, and rectangle
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(4, 3);
        Rectangle rectangle = new Rectangle(4, 6);

        // Create a ShapePrinter
        ShapePrinter shapePrinter = new ShapePrinter();

        // Print details of the shapes
        shapePrinter.printCircleDetails(circle);
        shapePrinter.printTriangleDetails(triangle);
        shapePrinter.printRectangleDetails(rectangle);
    }
}

/**
 * In the above program, each class has a single responsibility:
 * - Circle, Triangle, and Rectangle classes store the attributes of their respective shapes.
 * - ShapePrinter class handles the responsibility of printing the details of different shapes.
 * The Single Responsibility Principle is maintained by separating these responsibilities into different classes.
 */
