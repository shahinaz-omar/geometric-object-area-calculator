import javax.swing.*;
import java.awt.*;
import java.util.List;

// GUI to draw shapes with their area
public class ShapesGUI extends JFrame {
    private List<Drawable> shapes;
    private double sumAreas;

    public ShapesGUI(List<Drawable> shapes, double sumAreas) {
        this.shapes = shapes;
        this.sumAreas = sumAreas;

        setTitle("Shapes GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new ShapesPanel());
    }

    class ShapesPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 50;
            int y = 50;
            int gap = 150; // space between shapes

            for (Drawable d : shapes) {
                g.setColor(Color.BLACK); // default color
                String areaText = "";

                if (d instanceof Circle) {
                    Circle c = (Circle) d;
                    g.setColor(Color.RED);
                    int diameter = (int) c.getRadius() * 2;
                    g.drawOval(x + 50, y, diameter, diameter);
                    areaText = String.format("Circle area = %.2f", c.getArea());
                    // draw text just above the circle
                    g.setColor(Color.BLACK);
                    g.drawString(areaText, x + 25, y - 5);

                } else if (d instanceof Cube) {
                    Cube c = (Cube) d;
                    g.setColor(Color.BLUE);
                    int s = (int) c.getSide();

                    int xCube = x + 140;
                    int yCube = y + 15;

                    // Draw 3D-like cube (simple isometric)
                    g.drawRect(xCube, yCube, s, s);
                    g.drawLine(xCube, yCube, xCube + s / 2, yCube - s / 2);
                    g.drawLine(xCube + s, yCube, xCube + s + s / 2, yCube - s / 2);
                    g.drawLine(xCube + s / 2, yCube - s / 2, xCube + s + s / 2, yCube - s / 2);
                    g.drawLine(xCube + s + s / 2, yCube - s / 2, xCube + s + s / 2, yCube - s / 2 + s);
                    g.drawLine(xCube + s + s / 2, yCube - s / 2 + s, xCube + s, yCube + s);

                    areaText = String.format("Cube area = %.2f", c.getArea());
                    g.setColor(Color.BLACK);
                    g.drawString(areaText, x + 100, y - 5);
                }

                // move x slightly for next shape
                x += gap;
            }

            // Draw sum of areas at the bottom
            g.setColor(Color.BLACK);
            g.drawString(String.format("Sum of areas = %.2f", sumAreas), 200, getHeight() - 400);
        }
    }
}
