// Circle class extends Shape and implements Drawable
public class Circle extends Shape {
    private double radius;

    public Circle() {
        super();
        this.radius = 0.0;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String howToDraw() {
        return "Draw a circle with radius " + radius;
    }

    @Override
    public String toString() {
        return "Circle[color=" + super.getDateCreated() + ", radius=" + radius + "]";
    }
}
