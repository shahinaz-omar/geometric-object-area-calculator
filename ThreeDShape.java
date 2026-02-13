// Abstract class for 3D shapes
public abstract class ThreeDShape extends Shape {
    public ThreeDShape() {
        super();
    }

    public ThreeDShape(String color) {
        super(color);
    }

    // Abstract method to calculate volume
    public abstract double getVolume();
}
