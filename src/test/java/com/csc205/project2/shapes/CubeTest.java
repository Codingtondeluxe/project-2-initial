package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for Cube.
 * Tests basic functionality, calculation accuracy, boundary conditions, and polymorphism.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
class CubeTest {

    private Cube cube;

    @BeforeEach
    void setUp() {
        cube = new Cube("Test Cube", "Blue", 4.0);
    }

    // ===== Basic Functionality Tests =====

    @Test
    void testConstructorWithAllParameters() {
        assertEquals("Test Cube", cube.getName());
        assertEquals("Blue", cube.getColor());
        assertEquals(4.0, cube.getSideLength(), 0.001);
    }

    @Test
    void testConstructorWithSideLengthOnly() {
        Cube c = new Cube(3.0);
        assertEquals(3.0, c.getSideLength(), 0.001);
        assertEquals("Unnamed", c.getName());
        assertEquals("Uncolored", c.getColor());
    }

    @Test
    void testDefaultConstructor() {
        Cube c = new Cube();
        assertEquals(1.0, c.getSideLength(), 0.001);
    }

    @Test
    void testGettersAndSetters() {
        cube.setSideLength(10.0);
        assertEquals(10.0, cube.getSideLength(), 0.001);

        cube.setName("New Name");
        assertEquals("New Name", cube.getName());

        cube.setColor("Red");
        assertEquals("Red", cube.getColor());
    }

    // ===== Calculation Accuracy Tests =====

    @Test
    void testVolumeCalculationWithSide2() {
        Cube c = new Cube(2.0);
        // Volume = 2³ = 8
        assertEquals(8.0, c.getVolume(), 0.001);
    }

    @Test
    void testVolumeCalculationWithSide4() {
        // Volume = 4³ = 64
        assertEquals(64.0, cube.getVolume(), 0.001);
    }

    @Test
    void testSurfaceAreaCalculationWithSide2() {
        Cube c = new Cube(2.0);
        // Surface Area = 6 * 2² = 24
        assertEquals(24.0, c.getSurfaceArea(), 0.001);
    }

    @Test
    void testSurfaceAreaCalculationWithSide4() {
        // Surface Area = 6 * 4² = 96
        assertEquals(96.0, cube.getSurfaceArea(), 0.001);
    }

    @Test
    void testVolumeCalculationWithSide5() {
        Cube c = new Cube(5.0);
        // Volume = 5³ = 125
        assertEquals(125.0, c.getVolume(), 0.001);
    }

    // ===== Boundary Testing =====

    @Test
    void testVerySmallSideLength() {
        Cube c = new Cube(0.001);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void testVeryLargeSideLength() {
        Cube c = new Cube(100000.0);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    // ===== Input Validation Tests =====

    @Test
    void testNegativeSideLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cube(-5.0);
        });
    }

    @Test
    void testZeroSideLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cube(0.0);
        });
    }

    @Test
    void testSetNegativeSideLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cube.setSideLength(-1.0);
        });
    }

    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cube(null, "Blue", 5.0);
        });
    }

    @Test
    void testEmptyColorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cube("Test", "", 5.0);
        });
    }

    // ===== Inheritance and Polymorphism Tests =====

    @Test
    void testCubeIsInstanceOfShape3D() {
        assertTrue(cube instanceof Shape3D);
    }

    @Test
    void testCubeImplementsThreeDimensionalShape() {
        assertTrue(cube instanceof ThreeDimensionalShape);
    }

    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Cube("Poly Cube", "Green", 3.0);
        assertEquals(27.0, shape.getVolume(), 0.01);
        assertEquals(54.0, shape.getSurfaceArea(), 0.01);
    }

    @Test
    void testToStringContainsRelevantInfo() {
        String str = cube.toString();
        assertTrue(str.contains("Cube"));
        assertTrue(str.contains("Test Cube"));
        assertTrue(str.contains("Blue"));
    }

    @Test
    void testVolumeToSurfaceAreaRatio() {
        // For a cube with side 4: volume/surface = 64/96 = 0.667
        double ratio = cube.getVolume() / cube.getSurfaceArea();
        assertEquals(0.667, ratio, 0.01);
    }
}
