// violation of Open closed principle
// Rectangle.java
public class Rectangle {
    private double length;
    private double height; 
    // getters/setters ... 
}
// Circle.java
public class Circle {
    private double radius; 
    // getters/setters ...
}
// AreaFactory.java
public class AreaFactory {
    public double calculateArea(ArrayList<Object>... shapes) {
        double area = 0;
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rect = (Rectangle)shape;
                area += (rect.getLength() * rect.getHeight());                
            } else if (shape instanceof Circle) {
                Circle circle = (Circle)shape;
                area += 
                (circle.getRadius() * cirlce.getRadius() * Math.PI);
            } else {
                throw new RuntimeException("Shape not supported");
            }            
        }
        return area;
    }
}