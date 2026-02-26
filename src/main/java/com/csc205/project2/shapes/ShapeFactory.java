package com.csc205.project2.shapes;


/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create a ShapeFactory class that implements the factory pattern to create 3D shapes dynamically.
 * It should have a static create() method that takes a shape class, name, color, and variable dimensions.
 * Handle different shape types (Sphere, Cube, Cylinder, RectangularPrism, Cone) with appropriate
 * parameter validation and error handling. Include JavaDoc and throw IllegalArgumentException for invalid inputs."
 *
 * Manual Modifications:
 * - None required
 *
 * Pattern Explanation:
 * - Factory Pattern creates objects without specifying exact classes
 * - Reduces coupling between client code and shape classes
 * - Centralizes shape creation logic
 */

/**
 * Factory class for creating 3D shapes dynamically.
 * Uses the Factory Pattern to centralize shape creation logic and reduce coupling.
 *
 * The factory handles different shapes and their specific constructor parameters,
 * providing a unified interface for shape creation.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class ShapeFactory {

    /**
     * Creates a 3D shape based on the provided class and parameters.
     *
     * @param shapeClass the Class of the shape to create (e.g., Sphere.class)
     * @param name the name of the shape
     * @param color the color of the shape
     * @param dimensions variable length array of dimensions (number and meaning depends on shape type)
     * @return a new Shape3D instance of the specified type
     * @throws IllegalArgumentException if parameters are invalid for the shape type
     * @throws IllegalArgumentException if shapeClass is not a valid shape type
     */
    public static Shape3D create(Class<? extends Shape3D> shapeClass, String name, String color, double... dimensions) {
        if (shapeClass == null) {
            throw new IllegalArgumentException("Shape class cannot be null");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Shape name cannot be null or empty");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Shape color cannot be null or empty");
        }

        // Create shapes based on their class type
        if (shapeClass == Sphere.class) {
            return createSphere(name, color, dimensions);
        } else if (shapeClass == Cube.class) {
            return createCube(name, color, dimensions);
        } else if (shapeClass == Cylinder.class) {
            return createCylinder(name, color, dimensions);
        } else if (shapeClass == RectangularPrism.class) {
            return createRectangularPrism(name, color, dimensions);
        } else if (shapeClass == Cone.class) {
            return createCone(name, color, dimensions);
        } else {
            throw new IllegalArgumentException("Unknown shape class: " + shapeClass.getName());
        }
    }

    /**
     * Creates a Sphere with the given parameters.
     *
     * @param name the name of the sphere
     * @param color the color of the sphere
     * @param dimensions array containing: [radius]
     * @return a new Sphere instance
     * @throws IllegalArgumentException if dimensions array is incorrect size or invalid
     */
    private static Sphere createSphere(String name, String color, double... dimensions) {
        if (dimensions.length != 1) {
            throw new IllegalArgumentException("Sphere requires exactly 1 dimension: radius");
        }
        return new Sphere(name, color, dimensions[0]);
    }

    /**
     * Creates a Cube with the given parameters.
     *
     * @param name the name of the cube
     * @param color the color of the cube
     * @param dimensions array containing: [sideLength]
     * @return a new Cube instance
     * @throws IllegalArgumentException if dimensions array is incorrect size or invalid
     */
    private static Cube createCube(String name, String color, double... dimensions) {
        if (dimensions.length != 1) {
            throw new IllegalArgumentException("Cube requires exactly 1 dimension: sideLength");
        }
        return new Cube(name, color, dimensions[0]);
    }

    /**
     * Creates a Cylinder with the given parameters.
     *
     * @param name the name of the cylinder
     * @param color the color of the cylinder
     * @param dimensions array containing: [radius, height]
     * @return a new Cylinder instance
     * @throws IllegalArgumentException if dimensions array is incorrect size or invalid
     */
    private static Cylinder createCylinder(String name, String color, double... dimensions) {
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Cylinder requires exactly 2 dimensions: radius, height");
        }
        return new Cylinder(name, color, dimensions[0], dimensions[1]);
    }

    /**
     * Creates a RectangularPrism with the given parameters.
     *
     * @param name the name of the prism
     * @param color the color of the prism
     * @param dimensions array containing: [length, width, height]
     * @return a new RectangularPrism instance
     * @throws IllegalArgumentException if dimensions array is incorrect size or invalid
     */
    private static RectangularPrism createRectangularPrism(String name, String color, double... dimensions) {
        if (dimensions.length != 3) {
            throw new IllegalArgumentException("RectangularPrism requires exactly 3 dimensions: length, width, height");
        }
        return new RectangularPrism(name, color, dimensions[0], dimensions[1], dimensions[2]);
    }

    /**
     * Creates a Cone with the given parameters.
     *
     * @param name the name of the cone
     * @param color the color of the cone
     * @param dimensions array containing: [radius, height]
     * @return a new Cone instance
     * @throws IllegalArgumentException if dimensions array is incorrect size or invalid
     */
    private static Cone createCone(String name, String color, double... dimensions) {
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Cone requires exactly 2 dimensions: radius, height");
        }
        return new Cone(name, color, dimensions[0], dimensions[1]);
    }

    /**
     * Gets a string description of the required dimensions for a shape type.
     * Useful for providing user guidance.
     *
     * @param shapeClass the shape class
     * @return a string describing required dimensions
     */
    public static String getDimensionDescription(Class<? extends Shape3D> shapeClass) {
        if (shapeClass == Sphere.class) {
            return "radius";
        } else if (shapeClass == Cube.class) {
            return "sideLength";
        } else if (shapeClass == Cylinder.class) {
            return "radius, height";
        } else if (shapeClass == RectangularPrism.class) {
            return "length, width, height";
        } else if (shapeClass == Cone.class) {
            return "radius, height";
        } else {
            return "unknown";
        }
    }
}
