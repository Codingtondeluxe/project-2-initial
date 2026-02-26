package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for ShapeFactory.
 * Tests factory pattern implementation including shape creation, validation, and error handling.
 *
 * @author AI-Generated with GitHub Copilot
 * @version 1.0
 */
class ShapeFactoryTest {

    // ===== Sphere Creation Tests =====

    @Test
    void testCreateSphere() {
        Shape3D sphere = ShapeFactory.create(Sphere.class, "Test Sphere", "Red", 5.0);

        assertNotNull(sphere);
        assertTrue(sphere instanceof Sphere);
        assertEquals("Test Sphere", sphere.getName());
        assertEquals("Red", sphere.getColor());
        assertEquals(523.599, sphere.getVolume(), 0.1);
    }

    @Test
    void testCreateSphereWithDifferentRadius() {
        Shape3D sphere = ShapeFactory.create(Sphere.class, "Small Sphere", "Blue", 2.0);

        assertEquals(33.51, sphere.getVolume(), 0.1);
        assertEquals(50.27, sphere.getSurfaceArea(), 0.1);
    }

    @Test
    void testCreateSphereWithInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "Sphere", "Red", 5.0, 10.0);
        }, "Sphere should require exactly 1 dimension");
    }

    @Test
    void testCreateSphereWithNoDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "Sphere", "Red");
        }, "Sphere should require exactly 1 dimension");
    }

    // ===== Cube Creation Tests =====

    @Test
    void testCreateCube() {
        Shape3D cube = ShapeFactory.create(Cube.class, "Test Cube", "Blue", 4.0);

        assertNotNull(cube);
        assertTrue(cube instanceof Cube);
        assertEquals("Test Cube", cube.getName());
        assertEquals("Blue", cube.getColor());
        assertEquals(64.0, cube.getVolume(), 0.01);
    }

    @Test
    void testCreateCubeWithDifferentSide() {
        Shape3D cube = ShapeFactory.create(Cube.class, "Small Cube", "Green", 2.0);

        assertEquals(8.0, cube.getVolume(), 0.01);
        assertEquals(24.0, cube.getSurfaceArea(), 0.01);
    }

    @Test
    void testCreateCubeWithInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Cube.class, "Cube", "Blue", 4.0, 5.0);
        }, "Cube should require exactly 1 dimension");
    }

    // ===== Cylinder Creation Tests =====

    @Test
    void testCreateCylinder() {
        Shape3D cylinder = ShapeFactory.create(Cylinder.class, "Test Cylinder", "Green", 3.0, 7.0);

        assertNotNull(cylinder);
        assertTrue(cylinder instanceof Cylinder);
        assertEquals("Test Cylinder", cylinder.getName());
        assertEquals("Green", cylinder.getColor());
        assertEquals(197.92, cylinder.getVolume(), 0.1);
    }

    @Test
    void testCreateCylinderWithDifferentDimensions() {
        Shape3D cylinder = ShapeFactory.create(Cylinder.class, "Tall Cylinder", "Yellow", 2.0, 10.0);

        assertEquals(125.66, cylinder.getVolume(), 0.1);
    }

    @Test
    void testCreateCylinderWithInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Cylinder.class, "Cylinder", "Green", 3.0);
        }, "Cylinder should require exactly 2 dimensions");
    }

    @Test
    void testCreateCylinderWithTooManyDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Cylinder.class, "Cylinder", "Green", 3.0, 7.0, 2.0);
        }, "Cylinder should require exactly 2 dimensions");
    }

    // ===== RectangularPrism Creation Tests =====

    @Test
    void testCreateRectangularPrism() {
        Shape3D prism = ShapeFactory.create(RectangularPrism.class, "Test Prism", "Yellow", 5.0, 3.0, 2.0);

        assertNotNull(prism);
        assertTrue(prism instanceof RectangularPrism);
        assertEquals("Test Prism", prism.getName());
        assertEquals("Yellow", prism.getColor());
        assertEquals(30.0, prism.getVolume(), 0.01);
    }

    @Test
    void testCreateRectangularPrismWithDifferentDimensions() {
        Shape3D prism = ShapeFactory.create(RectangularPrism.class, "Large Prism", "Orange", 10.0, 8.0, 6.0);

        assertEquals(480.0, prism.getVolume(), 0.01);
        assertEquals(376.0, prism.getSurfaceArea(), 0.01);
    }

    @Test
    void testCreateRectangularPrismWithInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(RectangularPrism.class, "Prism", "Yellow", 5.0, 3.0);
        }, "RectangularPrism should require exactly 3 dimensions");
    }

    @Test
    void testCreateRectangularPrismAsCube() {
        Shape3D prism = ShapeFactory.create(RectangularPrism.class, "Cube-like", "Purple", 3.0, 3.0, 3.0);

        assertEquals(27.0, prism.getVolume(), 0.01);
        assertEquals(54.0, prism.getSurfaceArea(), 0.01);
    }

    // ===== Cone Creation Tests =====

    @Test
    void testCreateCone() {
        Shape3D cone = ShapeFactory.create(Cone.class, "Test Cone", "Orange", 2.5, 8.0);

        assertNotNull(cone);
        assertTrue(cone instanceof Cone);
        assertEquals("Test Cone", cone.getName());
        assertEquals("Orange", cone.getColor());
        assertEquals(52.36, cone.getVolume(), 0.1);
    }

    @Test
    void testCreateConeWithDifferentDimensions() {
        Shape3D cone = ShapeFactory.create(Cone.class, "Tall Cone", "Red", 3.0, 10.0);

        assertEquals(94.25, cone.getVolume(), 0.1);
    }

    @Test
    void testCreateConeWithInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Cone.class, "Cone", "Orange", 2.5, 8.0, 5.0);
        }, "Cone should require exactly 2 dimensions");
    }

    // ===== Input Validation Tests =====

    @Test
    void testCreateWithNullClass() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(null, "Shape", "Red", 5.0);
        }, "Shape class cannot be null");
    }

    @Test
    void testCreateWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, null, "Red", 5.0);
        }, "Shape name cannot be null");
    }

    @Test
    void testCreateWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "", "Red", 5.0);
        }, "Shape name cannot be empty");
    }

    @Test
    void testCreateWithWhitespaceName() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "   ", "Red", 5.0);
        }, "Shape name cannot be whitespace");
    }

    @Test
    void testCreateWithNullColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "Sphere", null, 5.0);
        }, "Shape color cannot be null");
    }

    @Test
    void testCreateWithEmptyColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "Sphere", "", 5.0);
        }, "Shape color cannot be empty");
    }

    @Test
    void testCreateWithInvalidShapeClass() {
        // Note: Can't test with String.class as it won't compile (not a Shape3D subclass)
        // Factory pattern ensures type safety at compile time, so this test is not needed
        // The factory method signature prevents non-Shape3D classes from being passed
    }

    // ===== Factory Pattern Validation Tests =====

    @Test
    void testFactoryPolymorphism() {
        Shape3D sphere = ShapeFactory.create(Sphere.class, "Sphere", "Red", 5.0);
        Shape3D cube = ShapeFactory.create(Cube.class, "Cube", "Blue", 4.0);
        Shape3D cylinder = ShapeFactory.create(Cylinder.class, "Cylinder", "Green", 3.0, 7.0);

        // All should be Shape3D instances
        assertTrue(sphere instanceof Shape3D);
        assertTrue(cube instanceof Shape3D);
        assertTrue(cylinder instanceof Shape3D);

        // All should be callable through Shape3D interface
        assertNotNull(sphere.getVolume());
        assertNotNull(cube.getVolume());
        assertNotNull(cylinder.getVolume());
    }

    @Test
    void testFactoryCreatesIndependentInstances() {
        Shape3D sphere1 = ShapeFactory.create(Sphere.class, "Sphere 1", "Red", 5.0);
        Shape3D sphere2 = ShapeFactory.create(Sphere.class, "Sphere 2", "Blue", 3.0);

        assertNotEquals(sphere1.getName(), sphere2.getName());
        assertNotEquals(sphere1.getColor(), sphere2.getColor());
        assertNotEquals(sphere1.getVolume(), sphere2.getVolume(), 0.01);
    }

    // ===== Dimension Description Tests =====

    @Test
    void testGetDimensionDescriptionForSphere() {
        String desc = ShapeFactory.getDimensionDescription(Sphere.class);
        assertEquals("radius", desc);
    }

    @Test
    void testGetDimensionDescriptionForCube() {
        String desc = ShapeFactory.getDimensionDescription(Cube.class);
        assertEquals("sideLength", desc);
    }

    @Test
    void testGetDimensionDescriptionForCylinder() {
        String desc = ShapeFactory.getDimensionDescription(Cylinder.class);
        assertEquals("radius, height", desc);
    }

    @Test
    void testGetDimensionDescriptionForRectangularPrism() {
        String desc = ShapeFactory.getDimensionDescription(RectangularPrism.class);
        assertEquals("length, width, height", desc);
    }

    @Test
    void testGetDimensionDescriptionForCone() {
        String desc = ShapeFactory.getDimensionDescription(Cone.class);
        assertEquals("radius, height", desc);
    }

    // Note: Can't test with String.class as it won't compile - the factory method signature
    // only accepts Class<? extends Shape3D>, so non-Shape3D classes are prevented at compile time
    // @Test
    // void testGetDimensionDescriptionForUnknownClass() {
    //     String desc = ShapeFactory.getDimensionDescription(String.class);
    //     assertEquals("unknown", desc);
    // }

    // ===== Negative Dimension Tests =====

    @Test
    void testCreateShapeWithNegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "Bad Sphere", "Red", -5.0);
        }, "Should reject negative radius");
    }

    @Test
    void testCreateShapeWithZeroDimension() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Cube.class, "Bad Cube", "Blue", 0.0);
        }, "Should reject zero dimension");
    }

    @Test
    void testCreateShapeWithNegativeWidth() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(RectangularPrism.class, "Bad Prism", "Yellow", 5.0, -3.0, 2.0);
        }, "Should reject negative width");
    }
}
