import java.util.Date;

// Abstract class for common shape properties
public abstract class Shape implements Drawable {
    private Date dateCreated;
    private String color;

    public Shape() {
        this.dateCreated = new Date();
        this.color = "undefined";
    }

    public Shape(String color) {
        this.dateCreated = new Date();
        this.color = color;
    }

    public void setDateCreated(Date date) {
        this.dateCreated = date;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Abstract methods to calculate area and perimeter
    public abstract double getArea();

    public abstract double getPerimeter();
}
