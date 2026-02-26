package com.csc205.project2;

import com.csc205.project2.shapes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class to demonstrate 3D shape inheritance and polymorphism.
 * Creates various shapes, displays their properties, and performs comparative analysis.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class ShapeDriver {

    public static void main(String[] args) {
        System.out.println("=== 3D Shape Analysis System ===\n");

        // Create a list of shapes (demonstrating polymorphism)
        List<Shape3D> shapes = new ArrayList<>();

        // Add various shapes to the list
        shapes.add(new Sphere("Red Ball", "Red", 5.0));
        shapes.add(new Cube("Blue Box", "Blue", 4.0));
        shapes.add(new Cylinder("Green Can", "Green", 3.0, 7.0));
        shapes.add(new RectangularPrism("Yellow Package", "Yellow", 5.0, 3.0, 2.0));
        shapes.add(new Cone("Orange Traffic Cone", "Orange", 2.5, 8.0));

        // Display all shapes
        System.out.println("Created Shapes:");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i));
        }

        // Perform comparative analysis
        performAnalysis(shapes);

        // Interactive feature - allow user to create custom shapes
        interactiveMode();

        System.out.println("\n=== Program Complete ===");
    }

    /**
     * Performs comparative analysis on a list of shapes.
     *
     * @param shapes the list of shapes to analyze
     */
    private static void performAnalysis(List<Shape3D> shapes) {
        System.out.println("\n=== Analysis Results ===");

        if (shapes.isEmpty()) {
            System.out.println("No shapes to analyze.");
            return;
        }

        // Find shape with largest volume
        Shape3D largestVolume = shapes.get(0);
        for (Shape3D shape : shapes) {
            if (shape.getVolume() > largestVolume.getVolume()) {
                largestVolume = shape;
            }
        }

        // Find shape with largest surface area
        Shape3D largestSurfaceArea = shapes.get(0);
        for (Shape3D shape : shapes) {
            if (shape.getSurfaceArea() > largestSurfaceArea.getSurfaceArea()) {
                largestSurfaceArea = shape;
            }
        }

        // Find most efficient shape (highest volume to surface area ratio)
        Shape3D mostEfficient = shapes.get(0);
        double maxRatio = shapes.get(0).getVolume() / shapes.get(0).getSurfaceArea();
        for (Shape3D shape : shapes) {
            double ratio = shape.getVolume() / shape.getSurfaceArea();
            if (ratio > maxRatio) {
                maxRatio = ratio;
                mostEfficient = shape;
            }
        }

        System.out.printf("- Largest Volume: %s (%.2f cubic units)%n",
                largestVolume.getName(), largestVolume.getVolume());
        System.out.printf("- Largest Surface Area: %s (%.2f square units)%n",
                largestSurfaceArea.getName(), largestSurfaceArea.getSurfaceArea());
        System.out.printf("- Most Efficient (Volume/Surface): %s (%.4f)%n",
                mostEfficient.getName(), maxRatio);
    }

    /**
     * Interactive mode allowing user to create custom shapes.
     */
    private static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Interactive Shape Creator ===");
        System.out.println("Create your own custom shape!");
        System.out.println("Available shapes:");
        System.out.println("1. Sphere");
        System.out.println("2. Cube");
        System.out.println("3. Cylinder");
        System.out.println("4. Rectangular Prism");
        System.out.println("5. Cone");
        System.out.println("0. Skip");

        System.out.print("\nEnter shape number: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Skipping interactive mode.");
                return;
            }

            System.out.print("Enter shape name: ");
            String name = scanner.nextLine();

            System.out.print("Enter shape color: ");
            String color = scanner.nextLine();

            Shape3D customShape = null;

            switch (choice) {
                case 1: // Sphere
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    customShape = new Sphere(name, color, radius);
                    break;

                case 2: // Cube
                    System.out.print("Enter side length: ");
                    double sideLength = scanner.nextDouble();
                    customShape = new Cube(name, color, sideLength);
                    break;

                case 3: // Cylinder
                    System.out.print("Enter radius: ");
                    double cylRadius = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double cylHeight = scanner.nextDouble();
                    customShape = new Cylinder(name, color, cylRadius, cylHeight);
                    break;

                case 4: // Rectangular Prism
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double prismHeight = scanner.nextDouble();
                    customShape = new RectangularPrism(name, color, length, width, prismHeight);
                    break;

                case 5: // Cone
                    System.out.print("Enter radius: ");
                    double coneRadius = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double coneHeight = scanner.nextDouble();
                    customShape = new Cone(name, color, coneRadius, coneHeight);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            if (customShape != null) {
                System.out.println("\n=== Your Custom Shape ===");
                System.out.println(customShape);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
