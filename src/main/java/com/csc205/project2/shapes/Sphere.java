package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create a Sphere class that extends Shape3D with a radius property.
 * Include constructors with validation (radius must be positive), override toString(),
 * and implement volume and surface area calculations. Add JavaDoc documentation."
 *
 * Manual Modifications:
 * - None required
 *
 * Formula Verification:
 * - Volume formula verified against: https://www.mathsisfun.com/geometry/sphere.html
 *   Volume = (4/3) * π * r³
 * - Surface area formula verified against: https://www.mathsisfun.com/geometry/sphere.html
 *   Surface Area = 4 * π * r²
 */

/**
 * Represents a sphere in 3D space.
 * A sphere is defined by its radius.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class Sphere extends Shape3D {

    /** The radius of the sphere */
    private double radius;

    /**
     * Default constructor.
     * Creates a sphere with radius 1.0.
     */
    public Sphere() {
        super();
        this.radius = 1.0;
    }

    /**
     * Constructor with radius only.
     *
     * @param radius the radius of the sphere
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(double radius) {
        super();
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    /**
     * Constructor with name, color, and radius.
     *
     * @param name the name of the sphere
     * @param color the color of the sphere
     * @param radius the radius of the sphere
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(String name, String color, double radius) {
        super(name, color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    /**
     * Gets the radius of the sphere.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the sphere.
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
     * Calculates the surface area of the sphere.
     * Formula: 4 * π * r²
     *
     * @return the surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    /**
     * Calculates the volume of the sphere.
     * Formula: (4/3) * π * r³
     *
     * @return the volume
     */
    @Override
    protected double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Returns a string representation of the sphere.
     *
     * @return a formatted string with sphere details
     */
    @Override
    public String toString() {
        return String.format("Sphere {name='%s', color='%s', radius=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), radius, getSurfaceArea(), getVolume());
    }
}
