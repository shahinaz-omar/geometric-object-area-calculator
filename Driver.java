import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Drawable> shapes = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File("input.txt"));
            int n = fileScanner.nextInt(); // read number of shapes

            for (int i = 0; i < n; i++) {
                String type = fileScanner.next();
                double value = fileScanner.nextDouble();

                if (type.equalsIgnoreCase("circle")) {
                    shapes.add(new Circle("red", value));
                } else if (type.equalsIgnoreCase("cube")) {
                    shapes.add(new Cube("blue", value));
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }

        // Calculate sum of areas
        double sumAreas = 0;
        for (Drawable d : shapes) {
            if (d instanceof Shape) {
                sumAreas += ((Shape) d).getArea();
            }
        }

        // Write sum to output file
        try {
            PrintWriter writer = new PrintWriter("sumAreas.txt");
            writer.println("Sum of areas: " + sumAreas);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }

        // Show GUI
        ShapesGUI gui = new ShapesGUI(shapes, sumAreas);
        gui.setVisible(true);

    }
}
