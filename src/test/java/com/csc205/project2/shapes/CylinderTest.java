package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Cylinder.
 * Tests basic functionality, calculation accuracy, boundary conditions, and polymorphism.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
class CylinderTest {

    private Cylinder cylinder;

    @BeforeEach
    void setUp() {
        cylinder = new Cylinder("Test Cylinder", "Green", 3.0, 7.0);
    }

    // ===== Basic Functionality Tests =====

    @Test
    void testConstructorWithAllParameters() {
        assertEquals("Test Cylinder", cylinder.getName());
        assertEquals("Green", cylinder.getColor());
        assertEquals(3.0, cylinder.getRadius(), 0.001);
        assertEquals(7.0, cylinder.getHeight(), 0.001);
    }

    @Test
    void testConstructorWithDimensionsOnly() {
        Cylinder c = new Cylinder(2.0, 5.0);
        assertEquals(2.0, c.getRadius(), 0.001);
        assertEquals(5.0, c.getHeight(), 0.001);
        assertEquals("Unnamed", c.getName());
        assertEquals("Uncolored", c.getColor());
    }

    @Test
    void testDefaultConstructor() {
        Cylinder c = new Cylinder();
        assertEquals(1.0, c.getRadius(), 0.001);
        assertEquals(1.0, c.getHeight(), 0.001);
    }

    @Test
    void testGettersAndSetters() {
        cylinder.setRadius(5.0);
        assertEquals(5.0, cylinder.getRadius(), 0.001);

        cylinder.setHeight(10.0);
        assertEquals(10.0, cylinder.getHeight(), 0.001);

        cylinder.setName("New Name");
        assertEquals("New Name", cylinder.getName());

        cylinder.setColor("Yellow");
        assertEquals("Yellow", cylinder.getColor());
    }

    // ===== Calculation Accuracy Tests =====

    @Test
    void testVolumeCalculationWithRadius2Height5() {
        Cylinder c = new Cylinder(2.0, 5.0);
        // Volume = π * 2² * 5 = 62.832...
        assertEquals(62.832, c.getVolume(), 0.01);
    }

    @Test
    void testVolumeCalculationWithRadius3Height7() {
        // Volume = π * 3² * 7 = 197.92...
        assertEquals(197.92, cylinder.getVolume(), 0.1);
    }

    @Test
    void testSurfaceAreaCalculationWithRadius2Height5() {
        Cylinder c = new Cylinder(2.0, 5.0);
        // Surface Area = 2 * π * 2 * (2 + 5) = 87.96...
        assertEquals(87.96, c.getSurfaceArea(), 0.1);
    }

    @Test
    void testSurfaceAreaCalculationWithRadius3Height7() {
        // Surface Area = 2 * π * 3 * (3 + 7) = 188.5...
        assertEquals(188.5, cylinder.getSurfaceArea(), 0.1);
    }

    @Test
    void testVolumeWithEqualRadiusAndHeight() {
        Cylinder c = new Cylinder(4.0, 4.0);
        // Volume = π * 4² * 4 = 201.06...
        assertEquals(201.06, c.getVolume(), 0.1);
    }

    // ===== Boundary Testing =====

    @Test
    void testVerySmallDimensions() {
        Cylinder c = new Cylinder(0.001, 0.001);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void testVeryLargeDimensions() {
        Cylinder c = new Cylinder(10000.0, 10000.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void testVeryTallCylinder() {
        Cylinder c = new Cylinder(1.0, 1000.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void testVeryWideCylinder() {
        Cylinder c = new Cylinder(1000.0, 1.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    // ===== Input Validation Tests =====

    @Test
    void testNegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cylinder(-2.0, 5.0);
        });
    }

    @Test
    void testNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cylinder(2.0, -5.0);
        });
    }

    @Test
    void testZeroRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cylinder(0.0, 5.0);
        });
    }

    @Test
    void testZeroHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cylinder(2.0, 0.0);
        });
    }

    @Test
    void testSetNegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cylinder.setRadius(-1.0);
        });
    }

    @Test
    void testSetNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cylinder.setHeight(-1.0);
        });
    }

    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cylinder(null, "Green", 3.0, 7.0);
        });
    }

    // ===== Inheritance and Polymorphism Tests =====

    @Test
    void testCylinderIsInstanceOfShape3D() {
        assertTrue(cylinder instanceof Shape3D);
    }

    @Test
    void testCylinderImplementsThreeDimensionalShape() {
        assertTrue(cylinder instanceof ThreeDimensionalShape);
    }

    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Cylinder("Poly Cylinder", "Purple", 2.5, 6.0);
        assertEquals(117.81, shape.getVolume(), 0.1);
        assertEquals(133.52, shape.getSurfaceArea(), 0.1);
    }

    @Test
    void testToStringContainsRelevantInfo() {
        String str = cylinder.toString();
        assertTrue(str.contains("Cylinder"));
        assertTrue(str.contains("Test Cylinder"));
        assertTrue(str.contains("Green"));
    }
}
