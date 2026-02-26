package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create an abstract base class Shape3D that implements ThreeDimensionalShape interface.
 * Include: name and color as private String properties with getters/setters, constructors,
 * concrete implementations of getVolume() and getSurfaceArea() that call abstract methods,
 * and a toString() method. Add proper JavaDoc documentation and input validation."
 *
 * Manual Modifications:
 * - None required
 *
 * Formula Verification:
 * - N/A (abstract base class, formulas in concrete implementations)
 */

/**
 * Abstract base class for all 3D geometric shapes.
 * Provides common properties and behavior for all shapes.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public abstract class Shape3D implements ThreeDimensionalShape {

    /** The name of the shape */
    private String name;

    /** The color of the shape */
    private String color;

    /**
     * Default constructor.
     * Initializes name and color to "Unnamed" and "Uncolored".
     */
    public Shape3D() {
        this.name = "Unnamed";
        this.color = "Uncolored";
    }

    /**
     * Constructor with name and color.
     *
     * @param name the name of the shape
     * @param color the color of the shape
     * @throws IllegalArgumentException if name or color is null or empty
     */
    public Shape3D(String name, String color) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        this.name = name;
        this.color = color;
    }

    /**
     * Gets the name of the shape.
     *
     * @return the name of the shape
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the shape.
     *
     * @param name the new name for the shape
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    /**
     * Gets the color of the shape.
     *
     * @return the color of the shape
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the shape.
     *
     * @param color the new color for the shape
     * @throws IllegalArgumentException if color is null or empty
     */
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        this.color = color;
    }

    /**
     * Calculates and returns the surface area of the shape.
     * This method calls the abstract calculateSurfaceArea() method.
     *
     * @return the surface area of the shape
     */
    @Override
    public double getSurfaceArea() {
        return calculateSurfaceArea();
    }

    /**
     * Calculates and returns the volume of the shape.
     * This method calls the abstract calculateVolume() method.
     *
     * @return the volume of the shape
     */
    @Override
    public double getVolume() {
        return calculateVolume();
    }

    /**
     * Abstract method to calculate surface area.
     * Must be implemented by concrete shape classes.
     *
     * @return the surface area of the shape
     */
    protected abstract double calculateSurfaceArea();

    /**
     * Abstract method to calculate volume.
     * Must be implemented by concrete shape classes.
     *
     * @return the volume of the shape
     */
    protected abstract double calculateVolume();

    /**
     * Returns a string representation of the shape.
     *
     * @return a formatted string with shape details
     */
    @Override
    public String toString() {
        return String.format("%s {name='%s', color='%s', surfaceArea=%.2f, volume=%.2f}",
                this.getClass().getSimpleName(), name, color, getSurfaceArea(), getVolume());
    }
}
