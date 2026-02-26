package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create a Cube class that extends Shape3D with a sideLength property.
 * Include constructors with validation (sideLength must be positive), override toString(),
 * and implement volume and surface area calculations. Add JavaDoc documentation."
 *
 * Manual Modifications:
 * - None required
 *
 * Formula Verification:
 * - Volume formula verified against: https://www.mathsisfun.com/geometry/cube.html
 *   Volume = s³
 * - Surface area formula verified against: https://www.mathsisfun.com/geometry/cube.html
 *   Surface Area = 6 * s²
 */

/**
 * Represents a cube in 3D space.
 * A cube is defined by its side length.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class Cube extends Shape3D {

    /** The side length of the cube */
    private double sideLength;

    /**
     * Default constructor.
     * Creates a cube with side length 1.0.
     */
    public Cube() {
        super();
        this.sideLength = 1.0;
    }

    /**
     * Constructor with side length only.
     *
     * @param sideLength the side length of the cube
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public Cube(double sideLength) {
        super();
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.sideLength = sideLength;
    }

    /**
     * Constructor with name, color, and side length.
     *
     * @param name the name of the cube
     * @param color the color of the cube
     * @param sideLength the side length of the cube
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public Cube(String name, String color, double sideLength) {
        super(name, color);
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.sideLength = sideLength;
    }

    /**
     * Gets the side length of the cube.
     *
     * @return the side length
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Sets the side length of the cube.
     *
     * @param sideLength the new side length
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.sideLength = sideLength;
    }

    /**
     * Calculates the surface area of the cube.
     * Formula: 6 * s²
     *
     * @return the surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 6 * sideLength * sideLength;
    }

    /**
     * Calculates the volume of the cube.
     * Formula: s³
     *
     * @return the volume
     */
    @Override
    protected double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    /**
     * Returns a string representation of the cube.
     *
     * @return a formatted string with cube details
     */
    @Override
    public String toString() {
        return String.format("Cube {name='%s', color='%s', sideLength=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), sideLength, getSurfaceArea(), getVolume());
    }
}
