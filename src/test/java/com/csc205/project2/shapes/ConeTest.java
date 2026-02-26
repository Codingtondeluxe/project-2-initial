package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Cone.
 * Tests basic functionality, calculation accuracy, boundary conditions, and polymorphism.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
class ConeTest {

    private Cone cone;

    @BeforeEach
    void setUp() {
        cone = new Cone("Test Cone", "Orange", 2.5, 8.0);
    }

    // ===== Basic Functionality Tests =====

    @Test
    void testConstructorWithAllParameters() {
        assertEquals("Test Cone", cone.getName());
        assertEquals("Orange", cone.getColor());
        assertEquals(2.5, cone.getRadius(), 0.001);
        assertEquals(8.0, cone.getHeight(), 0.001);
    }

    @Test
    void testConstructorWithDimensionsOnly() {
        Cone c = new Cone(3.0, 5.0);
        assertEquals(3.0, c.getRadius(), 0.001);
        assertEquals(5.0, c.getHeight(), 0.001);
        assertEquals("Unnamed", c.getName());
        assertEquals("Uncolored", c.getColor());
    }

    @Test
    void testDefaultConstructor() {
        Cone c = new Cone();
        assertEquals(1.0, c.getRadius(), 0.001);
        assertEquals(1.0, c.getHeight(), 0.001);
    }

    @Test
    void testGettersAndSetters() {
        cone.setRadius(5.0);
        assertEquals(5.0, cone.getRadius(), 0.001);

        cone.setHeight(10.0);
        assertEquals(10.0, cone.getHeight(), 0.001);

        cone.setName("New Name");
        assertEquals("New Name", cone.getName());

        cone.setColor("Purple");
        assertEquals("Purple", cone.getColor());
    }

    @Test
    void testSlantHeightCalculation() {
        // For radius=2.5, height=8.0: slant = √(2.5² + 8²) = √(6.25 + 64) = √70.25 = 8.38...
        assertEquals(8.38, cone.getSlantHeight(), 0.1);
    }

    // ===== Calculation Accuracy Tests =====

    @Test
    void testVolumeCalculationWithRadius3Height4() {
        Cone c = new Cone(3.0, 4.0);
        // Volume = (1/3) * π * 3² * 4 = 37.699...
        assertEquals(37.699, c.getVolume(), 0.01);
    }

    @Test
    void testVolumeCalculationWithRadius2Point5Height8() {
        // Volume = (1/3) * π * 2.5² * 8 = 52.36...
        assertEquals(52.36, cone.getVolume(), 0.1);
    }

    @Test
    void testSurfaceAreaCalculationWithRadius3Height4() {
        Cone c = new Cone(3.0, 4.0);
        // slant = 5, Surface Area = π * 3 * (3 + 5) = 75.398...
        assertEquals(75.398, c.getSurfaceArea(), 0.1);
    }

    @Test
    void testSurfaceAreaCalculationWithRadius2Point5Height8() {
        // slant ≈ 8.38, Surface Area = π * 2.5 * (2.5 + 8.38) ≈ 85.35...
        assertEquals(85.35, cone.getSurfaceArea(), 0.5);
    }

    @Test
    void testPythagoreanTripleSlantHeight() {
        // 3-4-5 triangle
        Cone c = new Cone(3.0, 4.0);
        assertEquals(5.0, c.getSlantHeight(), 0.001);
    }

    // ===== Boundary Testing =====

    @Test
    void testVerySmallDimensions() {
        Cone c = new Cone(0.001, 0.001);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
        assertTrue(c.getSlantHeight() > 0);
    }

    @Test
    void testVeryLargeDimensions() {
        Cone c = new Cone(10000.0, 10000.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void testVeryTallCone() {
        Cone c = new Cone(1.0, 1000.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void testVeryWideCone() {
        Cone c = new Cone(1000.0, 1.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    // ===== Input Validation Tests =====

    @Test
    void testNegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cone(-2.5, 8.0);
        });
    }

    @Test
    void testNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cone(2.5, -8.0);
        });
    }

    @Test
    void testZeroRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cone(0.0, 8.0);
        });
    }

    @Test
    void testZeroHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cone(2.5, 0.0);
        });
    }

    @Test
    void testSetNegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cone.setRadius(-1.0);
        });
    }

    @Test
    void testSetNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cone.setHeight(-1.0);
        });
    }

    @Test
    void testSetZeroRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cone.setRadius(0.0);
        });
    }

    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cone(null, "Orange", 2.5, 8.0);
        });
    }

    @Test
    void testEmptyColorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cone("Test", "", 2.5, 8.0);
        });
    }

    // ===== Inheritance and Polymorphism Tests =====

    @Test
    void testConeIsInstanceOfShape3D() {
        assertTrue(cone instanceof Shape3D);
    }

    @Test
    void testConeImplementsThreeDimensionalShape() {
        assertTrue(cone instanceof ThreeDimensionalShape);
    }

    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Cone("Poly Cone", "Brown", 4.0, 6.0);
        assertEquals(100.53, shape.getVolume(), 0.1);
        // Slant height = √(4² + 6²) = √52 ≈ 7.211
        // Surface Area = π × 4 × (4 + 7.211) ≈ 140.88
        assertEquals(140.88, shape.getSurfaceArea(), 0.5);
    }

    @Test
    void testToStringContainsRelevantInfo() {
        String str = cone.toString();
        assertTrue(str.contains("Cone"));
        assertTrue(str.contains("Test Cone"));
        assertTrue(str.contains("Orange"));
    }

    @Test
    void testConeVolumeIsOneThirdOfCylinder() {
        // A cone's volume is 1/3 of a cylinder with same base and height
        Cone cone = new Cone(5.0, 10.0);
        Cylinder cylinder = new Cylinder(5.0, 10.0);

        assertEquals(cylinder.getVolume() / 3.0, cone.getVolume(), 0.01);
    }
}
