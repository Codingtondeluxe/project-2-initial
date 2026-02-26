package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create a Cone class that extends Shape3D with radius and height properties.
 * Include constructors with validation (both must be positive), override toString(),
 * and implement volume and surface area calculations. Add JavaDoc documentation."
 *
 * Manual Modifications:
 * - None required
 *
 * Formula Verification:
 * - Volume formula verified against: https://www.mathsisfun.com/geometry/cone.html
 *   Volume = (1/3) * π * r² * h
 * - Surface area formula verified against: https://www.mathsisfun.com/geometry/cone.html
 *   Surface Area = π * r * (r + slant height) where slant height = √(r² + h²)
 */

/**
 * Represents a cone in 3D space.
 * A cone is defined by its base radius and height.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class Cone extends Shape3D {

    /** The radius of the cone's base */
    private double radius;

    /** The height of the cone */
    private double height;

    /**
     * Default constructor.
     * Creates a cone with radius 1.0 and height 1.0.
     */
    public Cone() {
        super();
        this.radius = 1.0;
        this.height = 1.0;
    }

    /**
     * Constructor with radius and height.
     *
     * @param radius the radius of the cone's base
     * @param height the height of the cone
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cone(double radius, double height) {
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
     * @param name the name of the cone
     * @param color the color of the cone
     * @param radius the radius of the cone's base
     * @param height the height of the cone
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cone(String name, String color, double radius, double height) {
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
     * Gets the radius of the cone's base.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the cone's base.
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
     * Gets the height of the cone.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the cone.
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
     * Calculates the slant height of the cone.
     * Formula: √(r² + h²)
     *
     * @return the slant height
     */
    public double getSlantHeight() {
        return Math.sqrt(radius * radius + height * height);
    }

    /**
     * Calculates the surface area of the cone.
     * Formula: π * r * (r + slant height)
     *
     * @return the surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        double slantHeight = getSlantHeight();
        return Math.PI * radius * (radius + slantHeight);
    }

    /**
     * Calculates the volume of the cone.
     * Formula: (1/3) * π * r² * h
     *
     * @return the volume
     */
    @Override
    protected double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    /**
     * Returns a string representation of the cone.
     *
     * @return a formatted string with cone details
     */
    @Override
    public String toString() {
        return String.format("Cone {name='%s', color='%s', radius=%.2f, height=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), radius, height, getSurfaceArea(), getVolume());
    }
}
