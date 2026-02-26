package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create a Cylinder class that extends Shape3D with radius and height properties.
 * Include constructors with validation (both must be positive), override toString(),
 * and implement volume and surface area calculations. Add JavaDoc documentation."
 *
 * Manual Modifications:
 * - None required
 *
 * Formula Verification:
 * - Volume formula verified against: https://www.mathsisfun.com/geometry/cylinder.html
 *   Volume = π * r² * h
 * - Surface area formula verified against: https://www.mathsisfun.com/geometry/cylinder.html
 *   Surface Area = 2 * π * r * (r + h)
 */

/**
 * Represents a cylinder in 3D space.
 * A cylinder is defined by its radius and height.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class Cylinder extends Shape3D {

    /** The radius of the cylinder's base */
    private double radius;

    /** The height of the cylinder */
    private double height;

    /**
     * Default constructor.
     * Creates a cylinder with radius 1.0 and height 1.0.
     */
    public Cylinder() {
        super();
        this.radius = 1.0;
        this.height = 1.0;
    }

    /**
     * Constructor with radius and height.
     *
     * @param radius the radius of the cylinder
     * @param height the height of the cylinder
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(double radius, double height) {
        super();
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.radius = radius;
        this.height = height;
    }

    /**
     * Constructor with name, color, radius, and height.
     *
     * @param name the name of the cylinder
     * @param color the color of the cylinder
     * @param radius the radius of the cylinder
     * @param height the height of the cylinder
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(String name, String color, double radius, double height) {
        super(name, color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.radius = radius;
        this.height = height;
    }

    /**
     * Gets the radius of the cylinder.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the cylinder.
     *
     * @param radius the new radius
     * @throws IllegalArgumentException if radius is not positive
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    /**
     * Gets the height of the cylinder.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the cylinder.
     *
     * @param height the new height
     * @throws IllegalArgumentException if height is not positive
     */
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }

    /**
     * Calculates the surface area of the cylinder.
     * Formula: 2 * π * r * (r + h)
     *
     * @return the surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    /**
     * Calculates the volume of the cylinder.
     * Formula: π * r² * h
     *
     * @return the volume
     */
    @Override
    protected double calculateVolume() {
        return Math.PI * radius * radius * height;
    }

    /**
     * Returns a string representation of the cylinder.
     *
     * @return a formatted string with cylinder details
     */
    @Override
    public String toString() {
        return String.format("Cylinder {name='%s', color='%s', radius=%.2f, height=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), radius, height, getSurfaceArea(), getVolume());
    }
}
