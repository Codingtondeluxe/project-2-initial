package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Sphere.
 * Tests basic functionality, calculation accuracy, boundary conditions, and polymorphism.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
class SphereTest {

    private Sphere sphere;

    @BeforeEach
    void setUp() {
        sphere = new Sphere("Test Sphere", "Red", 5.0);
    }

    // ===== Basic Functionality Tests =====

    @Test
    void testConstructorWithAllParameters() {
        assertEquals("Test Sphere", sphere.getName());
        assertEquals("Red", sphere.getColor());
        assertEquals(5.0, sphere.getRadius(), 0.001);
    }

    @Test
    void testConstructorWithRadiusOnly() {
        Sphere s = new Sphere(3.0);
        assertEquals(3.0, s.getRadius(), 0.001);
        assertEquals("Unnamed", s.getName());
        assertEquals("Uncolored", s.getColor());
    }

    @Test
    void testDefaultConstructor() {
        Sphere s = new Sphere();
        assertEquals(1.0, s.getRadius(), 0.001);
    }

    @Test
    void testGettersAndSetters() {
        sphere.setRadius(10.0);
        assertEquals(10.0, sphere.getRadius(), 0.001);

        sphere.setName("New Name");
        assertEquals("New Name", sphere.getName());

        sphere.setColor("Blue");
        assertEquals("Blue", sphere.getColor());
    }

    // ===== Calculation Accuracy Tests =====

    @Test
    void testVolumeCalculationWithRadius3() {
        Sphere s = new Sphere(3.0);
        // Volume = (4/3) * π * 3³ = 113.097...
        assertEquals(113.097, s.getVolume(), 0.01);
    }

    @Test
    void testVolumeCalculationWithRadius5() {
        // Volume = (4/3) * π * 5³ = 523.599...
        assertEquals(523.599, sphere.getVolume(), 0.01);
    }

    @Test
    void testSurfaceAreaCalculationWithRadius3() {
        Sphere s = new Sphere(3.0);
        // Surface Area = 4 * π * 3² = 113.097...
        assertEquals(113.097, s.getSurfaceArea(), 0.01);
    }

    @Test
    void testSurfaceAreaCalculationWithRadius5() {
        // Surface Area = 4 * π * 5² = 314.159...
        assertEquals(314.159, sphere.getSurfaceArea(), 0.01);
    }

    // ===== Boundary Testing =====

    @Test
    void testVerySmallRadius() {
        Sphere s = new Sphere(0.001);
        assertTrue(s.getVolume() > 0);
        assertTrue(s.getSurfaceArea() > 0);
    }

    @Test
    void testVeryLargeRadius() {
        Sphere s = new Sphere(1000000.0);
        assertTrue(s.getVolume() > 0);
        assertTrue(s.getSurfaceArea() > 0);
        assertFalse(Double.isInfinite(s.getVolume()));
        assertFalse(Double.isInfinite(s.getSurfaceArea()));
    }

    // ===== Input Validation Tests =====

    @Test
    void testNegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sphere(-5.0);
        });
    }

    @Test
    void testZeroRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sphere(0.0);
        });
    }

    @Test
    void testSetNegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            sphere.setRadius(-1.0);
        });
    }

    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sphere(null, "Red", 5.0);
        });
    }

    @Test
    void testEmptyNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sphere("", "Red", 5.0);
        });
    }

    @Test
    void testNullColorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sphere("Test", null, 5.0);
        });
    }

    // ===== Inheritance and Polymorphism Tests =====

    @Test
    void testSphereIsInstanceOfShape3D() {
        assertTrue(sphere instanceof Shape3D);
    }

    @Test
    void testSphereImplementsThreeDimensionalShape() {
        assertTrue(sphere instanceof ThreeDimensionalShape);
    }

    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Sphere("Poly Sphere", "Blue", 4.0);
        assertEquals(268.08, shape.getVolume(), 0.1);
        assertEquals(201.06, shape.getSurfaceArea(), 0.1);
    }

    @Test
    void testToStringContainsRelevantInfo() {
        String str = sphere.toString();
        assertTrue(str.contains("Sphere"));
        assertTrue(str.contains("Test Sphere"));
        assertTrue(str.contains("Red"));
    }
}
