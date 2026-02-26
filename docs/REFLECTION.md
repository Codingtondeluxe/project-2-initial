# Project Reflection: AI-Assisted 3D Geometric Shapes

**Student Name:** Marshall Ruane

**Date:** February 26, 2026  
**Course:** CSC 205AA

---

## Overview

This reflection documents my experience using AI tools (specifically GitHub Copilot) to develop a Java application implementing 3D geometric shapes using inheritance and polymorphism.

---

## 1. AI Effectiveness

### Where AI Tools Excelled

**Code Generation Speed:**
- AI generated complete, compilable Java classes in seconds
- Created comprehensive test suites with 100+ test cases across all classes
- Significantly reduced development time compared to manual coding

**Pattern Implementation:**
- Excellent at implementing inheritance hierarchies
- Properly understood and applied polymorphism concepts
- Consistently applied design patterns across all shape classes

**Documentation Quality:**
- Generated professional JavaDoc comments for all classes and methods
- Included parameter descriptions and return value documentation
- Created clear, readable code with proper commenting

**Input Validation:**
- Included comprehensive validation logic without being asked
- Properly threw IllegalArgumentException for invalid inputs
- Validated null, empty, zero, and negative values appropriately

### Where AI Tools Struggled

**Minor Issues Found:**
- One test had an incorrect expected value for cone surface area (165.35 vs actual 140.88)
- The calculation was wrong in the test, not in the code implementation
- The implementation was correct, only the test assertion needed fixing
- Some test tolerance levels needed adjustment for floating point comparisons
- Type safety testing: Cannot test with String.class because the factory's generic type prevents it (which is beneficial design, not a weakness)

**What Didn't Struggle:**
- No edge cases were missed
- No logical errors in the code implementation
- No syntax errors or compilation issues
- Minimal prompt refinement needed
- Formulas were mathematically correct
- Test categories were comprehensive


---

## 2. Code Quality Comparison

### AI-Generated Code vs Manual Coding

**Advantages of AI-Generated Code:**
- Consistent coding style across all files
- No syntax errors or typos
- Complete error handling from the start
- Professional documentation included
- Faster initial development

**Potential Disadvantages:**
- Mathematical formulas need to be verified independently
- May generate more code than minimally necessary
- Requires understanding to modify and maintain
- Test cases need validation for correctness

**Quality Assessment:**
The AI-generated code appears to be:
- ✅ Well-structured and organized
- ✅ Following Java naming conventions
- ✅ Properly implementing OOP principles
- ✅ Including appropriate error handling
- ⚠️ Requires formula verification
- ⚠️ Requires test validation

---

## 3. Learning Experience

### What I Learned About Inheritance

**Key Concepts Reinforced:**
- Abstract classes provide common functionality while requiring subclasses to implement specific behavior
- The Shape3D base class consolidates shared properties (name, color) and delegates calculations to concrete classes
- Protected abstract methods allow base class to control the interface while subclasses provide implementation

**Polymorphism in Action:**
- The driver class demonstrates polymorphism by storing different shape types in a List<Shape3D>
- Each shape calculates volume/surface area differently, but the interface is uniform
- This allows for flexible code that works with any shape without knowing its specific type

**Design Benefits:**
- Adding a new shape only requires extending Shape3D and implementing two methods
- Code reuse through inheritance reduces duplication
- Consistent interface makes shapes interchangeable

### What I Learned About AI-Assisted Development

**Effective AI Usage:**
- Clear, specific prompts yield better results
- Including requirements (validation, documentation) in prompts is crucial
- AI understands software patterns and can apply them consistently
- Breaking complex tasks into smaller prompts works well

**AI Limitations:**
- AI output requires human verification, especially for mathematical formulas
- Understanding the generated code is essential for maintenance
- Cannot blindly trust AI - must test and validate
- Domain knowledge is still required

**Workflow Insights:**
- AI accelerates routine coding tasks
- More time available for design, testing, and validation
- Still need to understand OOP concepts to use AI effectively
- AI is a tool, not a replacement for learning

---

## 4. Validation Process

### How I Ensured Correctness

**Mathematical Formula Verification:**
1. Cross-referenced all formulas with trusted sources (mathsisfun.com)
2. For each shape, verified:
   - Volume formula against online calculators
   - Surface area formula against geometry references
3. Tested calculations with known values (e.g., sphere with radius 3)
4. Compared results with online geometry calculators

**Code Testing Strategy:**
1. ✅ Compiled all classes to check for syntax errors
2. ✅ Ran the driver class to verify basic functionality
3. ✅ Executed all 156 unit tests using Maven
4. ✅ Tested edge cases and boundary conditions (very small/large values, zero values)
5. ✅ Verified polymorphic behavior works as expected (List<Shape3D> with different shapes)
6. ✅ Verified factory pattern type safety with compile-time generics

**Test Results:**
- Total tests: 156 ✅
- Passing: 156 ✅✅✅
- Failing: 0
- Errors: 0
- Build Status: SUCCESS ✅
- Execution Time: ~2.8 seconds

**Issues found and fixed:**
1. **ConeTest.testPolymorphicBehavior() - Incorrect Expected Value (RESOLVED):**
   - **Issue:** Test expected surface area of 165.35 for cone with radius 4.0, height 6.0
   - **Actual Result:** 140.88 (correct calculation)
   - **Calculation Verification:**
     - Slant height = √(4² + 6²) = √52 ≈ 7.211
     - Surface Area = π × r × (r + slant height) = π × 4 × 11.211 ≈ 140.88
   - **Root Cause:** AI-generated test had incorrect expected value
   - **Resolution:** Updated test assertion to expect 140.88 instead of 165.35
   - **Learning Point:** Even AI-generated tests need verification - mathematical formulas must be double-checked
   - **Result:** All tests now pass ✅

**Testing Issues Encountered and Resolved:**

1. **ShapeFactoryTest Compilation Error (Type Safety):**
   - **Issue:** Initial test attempted to pass `String.class` to `ShapeFactory.create()` to test invalid shape class handling
   - **Error Message:** `incompatible types: java.lang.Class<java.lang.String> cannot be converted to java.lang.Class<? extends com.csc205.project2.shapes.Shape3D>`
   - **Root Cause:** The factory method signature uses generics `Class<? extends Shape3D>` which enforces type safety at compile time
   - **Solution:** Removed the invalid test because Java's type system automatically prevents non-Shape3D classes from being passed
   - **Learning Point:** This demonstrates a key OOP principle - the factory pattern uses generics to ensure type safety at compile time, making runtime type checking unnecessary for this specific validation
   - **Test Modified:** Changed `testCreateWithInvalidShapeClass()` to a comment-only test explaining why it's not needed
   - **Lesson:** Good design (using generics) can eliminate entire categories of tests by preventing invalid states at compile time

**Input Validation Testing:**
- Verified that negative values throw exceptions
- Confirmed zero values are rejected
- Tested null and empty strings for name/color
- Checked very large and very small values
- Validated that factory dimension requirements are enforced (e.g., Sphere requires 1 dimension, Cylinder requires 2, etc.)
- Confirmed that invalid shape classes are prevented by Java's type system (compile-time safety)

---

## 5. Future Applications

### How I Will Use AI Tools in Future Projects

**Best Practices I Will Follow:**
1. **Start with Clear Requirements:** Define what I need before prompting AI
2. **Verify Everything:** Never assume AI output is correct without testing
3. **Understand the Code:** Read and comprehend all generated code
4. **Iterate Prompts:** Refine prompts if initial output isn't quite right
5. **Document AI Usage:** Keep track of what was AI-generated vs. modified

**Appropriate Use Cases:**
- Boilerplate code generation (getters, setters, constructors)
- Test case generation as a starting point
- Documentation template creation
- Implementing well-known design patterns
- Code following established conventions

**Where I'll Be Cautious:**
- Complex algorithms requiring deep understanding
- Performance-critical code
- Security-sensitive implementations
- Novel problem-solving requiring creativity

**Integration with Learning:**
- Use AI to handle routine tasks while focusing on learning concepts
- Ask AI to explain code it generates
- Use AI-generated code as study material
- Compare AI solutions with my own approaches

---

## 6. Overall Assessment

### Project Success

**Technical Goals Achieved:**
- ✅ Implemented inheritance hierarchy with abstract base class
- ✅ Created five concrete shape classes
- ✅ Demonstrated polymorphism in driver class
- ✅ Generated comprehensive test suites
- ✅ Included input validation and error handling
- ✅ Professional documentation throughout

**Learning Objectives Met:**
- ✅ Deepened understanding of inheritance and polymorphism
- ✅ Learned effective AI collaboration workflows
- ✅ Practiced code validation and quality assurance
- ✅ Experienced modern documentation practices

### Personal Takeaways

**Most Valuable Insight:**
AI is most powerful as a collaborative tool. It excelled at generating code, implementing patterns, and creating test templates. The real value came from understanding, validating, and improving that code. Using generics in the factory pattern prevented problems before they happened. Developers who effectively use AI will be much more productive.

**Biggest Challenge:**
Resisting the urge to trust AI output without verification. When the ConeTest failed, I initially thought the code was wrong, but it was actually the test expected value that was incorrect. This taught me to verify everything, especially mathematical calculations. The String.class compilation error showed me that Java's type system prevents bugs before runtime.

**What I Would Do Differently:**
1. Create a validation checklist from the start and verify formulas against multiple sources
2. Run tests incrementally during development instead of all at once
3. Add comments explaining prompt reasoning directly in the code during generation
4. Ask AI to explain its reasoning for design choices rather than just accepting the code
5. Spend more time understanding why AI made certain decisions before moving forward

---

## 7. Bonus: Factory Pattern Implementation (+15 points)

### What I Learned About Factory Pattern

**Purpose and Benefits:**
- The factory pattern centralizes object creation logic in one place
- Reduces coupling between client code and concrete shape classes
- Makes it easy to add new shapes without changing client code
- Provides a uniform interface for creating different shape types
- Encapsulates shape-specific logic (parameter validation, constructor calls)

**How It Simplifies Object Creation:**
Instead of:
```java
// Old way - client knows about all shapes
if (shapeType.equals("Sphere")) {
    shape = new Sphere(name, color, radius);
} else if (shapeType.equals("Cube")) {
    shape = new Cube(name, color, sideLength);
}
// ... more conditions
```

We now use:
```java
// New way - factory handles it
Shape3D shape = ShapeFactory.create(Sphere.class, name, color, radius);
```

**When to Use Factory Pattern:**
- When you have multiple classes with common interface
- When you want to encapsulate creation logic
- When object creation is complex or context-dependent
- When you want to reduce client code complexity

### Implementation Details

**How the Factory Works:**
1. Client calls `ShapeFactory.create()` with:
   - Shape class (Sphere.class, Cube.class, etc.)
   - Name and color (common to all shapes)
   - Variable dimensions (using varargs: `double...`)

2. Factory validates inputs:
   - Checks for null/empty name and color
   - Delegates to shape-specific helper method

3. Shape-specific helper methods:
   - Validate that correct number of dimensions provided
   - Create and return appropriate shape instance
   - Throw `IllegalArgumentException` if validation fails

**How It Handles Different Shape Types:**
- Sphere: 1 dimension (radius)
- Cube: 1 dimension (sideLength)
- Cylinder: 2 dimensions (radius, height)
- RectangularPrism: 3 dimensions (length, width, height)
- Cone: 2 dimensions (radius, height)

**Error Handling Approach:**
- `IllegalArgumentException` for invalid inputs
- Clear error messages indicating what went wrong
- Validates class type, name, color, and dimension counts
- Prevents creation of invalid shapes

**Example Usage:**
```java
// Create a red sphere with radius 5
Shape3D sphere = ShapeFactory.create(Sphere.class, "Red Ball", "Red", 5.0);

// Create a blue cube with side length 4
Shape3D cube = ShapeFactory.create(Cube.class, "Blue Box", "Blue", 4.0);

// Create a cylinder with radius 3 and height 7
Shape3D cylinder = ShapeFactory.create(Cylinder.class, "Green Can", "Green", 3.0, 7.0);
```

### Additional Factory Features

**Dimension Description Helper:**
The factory includes `getDimensionDescription()` method that returns a human-readable string describing what dimensions each shape requires:
- Useful for user interfaces or error messages
- Helps guide users on what parameters to provide

**Test Coverage:**
Created comprehensive test suite (ShapeFactoryTest.java) including:
- ✅ Tests for creating each shape type
- ✅ Validation that wrong dimensions throw exceptions
- ✅ Input validation for null/empty values
- ✅ Polymorphic behavior verification
- ✅ Independent instance creation
- ✅ Negative/zero dimension rejection

### Design Pattern Benefits Demonstrated

**Loose Coupling:**
- Client code doesn't depend on concrete shape classes
- Can add new shapes without modifying client code

**Encapsulation:**
- Shape creation logic centralized in one place
- Easier to modify how shapes are created
- Reduces duplication

**Maintainability:**
- If shape constructors change, only factory needs updating
- New shapes can be added by extending factory
- Clear, organized code structure

### Real-World Applications

**Where Factory Pattern is Used:**
- Database connection pooling
- UI framework components (buttons, text fields, etc.)
- Graphics rendering engines
- Document format conversion (PDF, XML, JSON)
- Plugin systems

**How This Relates to Project:**
- Demonstrates advanced OOP concepts beyond basic inheritance
- Shows how design patterns solve real code organization problems
- Prepares for larger software projects using established patterns

---

## Conclusion

This project showed that good OOP design and effective AI usage work together. AI accelerated development significantly but still required critical thinking and verification. The key lesson is that AI enhances productivity when used thoughtfully.

**Final Thoughts:**
Working on this project changed how I think about software development. I came in thinking AI would just generate code for me to submit, but I learned that effective AI usage is a skill in itself. It requires knowing what to ask clearly, understanding the output to critique and improve it, maintaining skepticism about correctness, testing and validating rigorously, and documenting decisions.

The fact that we achieved 156/156 tests passing with only one minor test value error shows that AI-generated code can be production-quality. That only happened because I invested time in understanding, validating, and fixing issues.

I'm excited about using AI in future projects - not to avoid learning, but to accelerate routine parts so I can focus more on architecture, complex algorithms, and problem-solving. AI and human expertise work best together.

---
