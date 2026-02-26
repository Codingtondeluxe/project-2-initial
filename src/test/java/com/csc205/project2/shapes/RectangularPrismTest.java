package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for RectangularPrism.
 * Tests basic functionality, calculation accuracy, boundary conditions, and polymorphism.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
class RectangularPrismTest {

    private RectangularPrism prism;

    @BeforeEach
    void setUp() {
        prism = new RectangularPrism("Test Prism", "Yellow", 5.0, 3.0, 2.0);
    }

    // ===== Basic Functionality Tests =====

    @Test
    void testConstructorWithAllParameters() {
        assertEquals("Test Prism", prism.getName());
        assertEquals("Yellow", prism.getColor());
        assertEquals(5.0, prism.getLength(), 0.001);
        assertEquals(3.0, prism.getWidth(), 0.001);
        assertEquals(2.0, prism.getHeight(), 0.001);
    }

    @Test
    void testConstructorWithDimensionsOnly() {
        RectangularPrism p = new RectangularPrism(4.0, 3.0, 2.0);
        assertEquals(4.0, p.getLength(), 0.001);
        assertEquals(3.0, p.getWidth(), 0.001);
        assertEquals(2.0, p.getHeight(), 0.001);
        assertEquals("Unnamed", p.getName());
        assertEquals("Uncolored", p.getColor());
    }

    @Test
    void testDefaultConstructor() {
        RectangularPrism p = new RectangularPrism();
        assertEquals(1.0, p.getLength(), 0.001);
        assertEquals(1.0, p.getWidth(), 0.001);
        assertEquals(1.0, p.getHeight(), 0.001);
    }

    @Test
    void testGettersAndSetters() {
        prism.setLength(10.0);
        assertEquals(10.0, prism.getLength(), 0.001);

        prism.setWidth(8.0);
        assertEquals(8.0, prism.getWidth(), 0.001);

        prism.setHeight(6.0);
        assertEquals(6.0, prism.getHeight(), 0.001);

        prism.setName("New Name");
        assertEquals("New Name", prism.getName());

        prism.setColor("Orange");
        assertEquals("Orange", prism.getColor());
    }

    // ===== Calculation Accuracy Tests =====

    @Test
    void testVolumeCalculationWithDimensions5x3x2() {
        // Volume = 5 * 3 * 2 = 30
        assertEquals(30.0, prism.getVolume(), 0.001);
    }

    @Test
    void testVolumeCalculationWithDimensions4x3x2() {
        RectangularPrism p = new RectangularPrism(4.0, 3.0, 2.0);
        // Volume = 4 * 3 * 2 = 24
        assertEquals(24.0, p.getVolume(), 0.001);
    }

    @Test
    void testSurfaceAreaCalculationWithDimensions5x3x2() {
        // Surface Area = 2 * (5*3 + 5*2 + 3*2) = 2 * (15 + 10 + 6) = 62
        assertEquals(62.0, prism.getSurfaceArea(), 0.001);
    }

    @Test
    void testSurfaceAreaCalculationWithDimensions4x3x2() {
        RectangularPrism p = new RectangularPrism(4.0, 3.0, 2.0);
        // Surface Area = 2 * (4*3 + 4*2 + 3*2) = 2 * (12 + 8 + 6) = 52
        assertEquals(52.0, p.getSurfaceArea(), 0.001);
    }

    @Test
    void testCubeAsRectangularPrism() {
        // A cube is a special case of rectangular prism
        RectangularPrism p = new RectangularPrism(3.0, 3.0, 3.0);
        // Volume = 3³ = 27
        assertEquals(27.0, p.getVolume(), 0.001);
        // Surface Area = 6 * 3² = 54
        assertEquals(54.0, p.getSurfaceArea(), 0.001);
    }

    // ===== Boundary Testing =====

    @Test
    void testVerySmallDimensions() {
        RectangularPrism p = new RectangularPrism(0.001, 0.001, 0.001);
        assertTrue(p.getVolume() > 0);
        assertTrue(p.getSurfaceArea() > 0);
    }

    @Test
    void testVeryLargeDimensions() {
        RectangularPrism p = new RectangularPrism(10000.0, 10000.0, 10000.0);
        assertTrue(p.getVolume() > 0);
        assertTrue(p.getSurfaceArea() > 0);
    }

    @Test
    void testVeryFlatPrism() {
        RectangularPrism p = new RectangularPrism(100.0, 100.0, 0.1);
        assertTrue(p.getVolume() > 0);
        assertTrue(p.getSurfaceArea() > 0);
    }

    @Test
    void testVeryTallPrism() {
        RectangularPrism p = new RectangularPrism(1.0, 1.0, 100.0);
        assertTrue(p.getVolume() > 0);
        assertTrue(p.getSurfaceArea() > 0);
    }

    // ===== Input Validation Tests =====

    @Test
    void testNegativeLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(-5.0, 3.0, 2.0);
        });
    }

    @Test
    void testNegativeWidthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(5.0, -3.0, 2.0);
        });
    }

    @Test
    void testNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(5.0, 3.0, -2.0);
        });
    }

    @Test
    void testZeroLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(0.0, 3.0, 2.0);
        });
    }

    @Test
    void testZeroWidthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(5.0, 0.0, 2.0);
        });
    }

    @Test
    void testZeroHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(5.0, 3.0, 0.0);
        });
    }

    @Test
    void testSetNegativeLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            prism.setLength(-1.0);
        });
    }

    @Test
    void testSetNegativeWidthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            prism.setWidth(-1.0);
        });
    }

    @Test
    void testSetNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            prism.setHeight(-1.0);
        });
    }

    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism(null, "Yellow", 5.0, 3.0, 2.0);
        });
    }

    @Test
    void testEmptyColorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RectangularPrism("Test", "   ", 5.0, 3.0, 2.0);
        });
    }

    // ===== Inheritance and Polymorphism Tests =====

    @Test
    void testPrismIsInstanceOfShape3D() {
        assertTrue(prism instanceof Shape3D);
    }

    @Test
    void testPrismImplementsThreeDimensionalShape() {
        assertTrue(prism instanceof ThreeDimensionalShape);
    }

    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new RectangularPrism("Poly Prism", "Pink", 6.0, 4.0, 3.0);
        assertEquals(72.0, shape.getVolume(), 0.01);
        assertEquals(108.0, shape.getSurfaceArea(), 0.01);
    }

    @Test
    void testToStringContainsRelevantInfo() {
        String str = prism.toString();
        assertTrue(str.contains("RectangularPrism"));
        assertTrue(str.contains("Test Prism"));
        assertTrue(str.contains("Yellow"));
    }
}
