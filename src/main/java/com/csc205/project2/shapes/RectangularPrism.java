package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: GitHub Copilot (GPT-4 based)
 * Generation Date: February 26, 2026
 *
 * Original Prompt:
 * "Create a RectangularPrism class that extends Shape3D with length, width, and height properties.
 * Include constructors with validation (all must be positive), override toString(),
 * and implement volume and surface area calculations. Add JavaDoc documentation."
 *
 * Manual Modifications:
 * - None required
 *
 * Formula Verification:
 * - Volume formula verified against: https://www.mathsisfun.com/geometry/cuboids-rectangular-prisms.html
 *   Volume = length * width * height
 * - Surface area formula verified against: https://www.mathsisfun.com/geometry/cuboids-rectangular-prisms.html
 *   Surface Area = 2 * (lw + lh + wh)
 */

/**
 * Represents a rectangular prism in 3D space.
 * A rectangular prism is defined by its length, width, and height.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
public class RectangularPrism extends Shape3D {

    /** The length of the rectangular prism */
    private double length;

    /** The width of the rectangular prism */
    private double width;

    /** The height of the rectangular prism */
    private double height;

    /**
     * Default constructor.
     * Creates a rectangular prism with dimensions 1.0 x 1.0 x 1.0.
     */
    public RectangularPrism() {
        super();
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    /**
     * Constructor with length, width, and height.
     *
     * @param length the length of the rectangular prism
     * @param width the width of the rectangular prism
     * @param height the height of the rectangular prism
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPrism(double length, double width, double height) {
        super();
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor with name, color, and dimensions.
     *
     * @param name the name of the rectangular prism
     * @param color the color of the rectangular prism
     * @param length the length of the rectangular prism
     * @param width the width of the rectangular prism
     * @param height the height of the rectangular prism
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPrism(String name, String color, double length, double width, double height) {
        super(name, color);
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the length of the rectangular prism.
     *
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the rectangular prism.
     *
     * @param length the new length
     * @throws IllegalArgumentException if length is not positive
     */
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        this.length = length;
    }

    /**
     * Gets the width of the rectangular prism.
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangular prism.
     *
     * @param width the new width
     * @throws IllegalArgumentException if width is not positive
     */
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    /**
     * Gets the height of the rectangular prism.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the rectangular prism.
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
     * Calculates the surface area of the rectangular prism.
     * Formula: 2 * (lw + lh + wh)
     *
     * @return the surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    /**
     * Calculates the volume of the rectangular prism.
     * Formula: length * width * height
     *
     * @return the volume
     */
    @Override
    protected double calculateVolume() {
        return length * width * height;
    }

    /**
     * Returns a string representation of the rectangular prism.
     *
     * @return a formatted string with rectangular prism details
     */
    @Override
    public String toString() {
        return String.format("RectangularPrism {name='%s', color='%s', length=%.2f, width=%.2f, height=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), length, width, height, getSurfaceArea(), getVolume());
    }
}
