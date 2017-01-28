// Open closed principle: good example
// Shape.java
public interface Shape {
    double getArea(); 
}
// Rectangle.java
public class Rectangle implements Shape{
    private double length;
    private double height; 
    // getters/setters ... 
    @Override
    public double getArea() {
        return (length * height);
    }
}
// Circle.java
public class Circle implements Shape{
    private double radius; 
    // getters/setters ...
   @Override
    public double getArea() {
        return (radius * radius * Math.PI);
    }
}
// AreaFactory.java
public class AreaFactory {
    public double calculateArea(ArrayList<Shape>... shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }
        return area;
    }
}