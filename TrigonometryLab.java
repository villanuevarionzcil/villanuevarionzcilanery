package trigonometry;

import static java.lang.Math.*;
import java.util.Scanner;

public class TrigonometryLab {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
        1. Trigonometric Function Calculator
        2. Angle Quadrant Detector
        3. Right Triangle Solver
        4. Trigonometric Identity Verifier
        5. Wave Properties Analyzer

        Choose a problem to run:
        """);

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> trigonometricFunctionCalculator(sc);
            case 2 -> angleQuadrantDetector(sc);
            case 3 -> rightTriangleSolver(sc);
            case 4 -> trigonometricIdentityVerifier(sc);
            case 5 -> wavePropertiesAnalyzer(sc);
            default -> System.out.println("Invalid choice.");
        }

        sc.close();
    }

    // ============================================================
    // PROBLEM 1: TRIGONOMETRIC FUNCTION CALCULATOR
    // ============================================================
    static void trigonometricFunctionCalculator(Scanner sc) {
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        // Convert degrees to radians because Java's Math functions use radians
        double rad = toRadians(angle);

        System.out.println("Choose function: 1-Sin  2-Cos  3-Tan  4-All");
        int f = sc.nextInt();

        if (f == 1 || f == 4)
            System.out.println("sin = " + sin(rad));

        if (f == 2 || f == 4)
            System.out.println("cos = " + cos(rad));

        if (f == 3 || f == 4) {
            // Tangent is undefined when cos(θ) = 0
            if (abs(cos(rad)) < 1e-10)
                System.out.println("tan = undefined");
            else
                System.out.println("tan = " + tan(rad));
        }

        /*
         * GUIDE QUESTIONS:
         * 1. Why do we need to convert degrees to radians?
         *    → Java's trigonometric methods (sin, cos, tan) require angles in radians.
         *
         * 2. Why is tangent undefined at certain angles?
         *    → tan(θ) = sin(θ) / cos(θ). When cos(θ) = 0, division by zero occurs.
         *
         * 3. How can this program be extended?
         *    → By adding reciprocal functions such as sec, csc, and cot
         *      with proper zero-division checks.
         */
    }

    // ============================================================
    // PROBLEM 2: ANGLE QUADRANT DETECTOR
    // ============================================================
    static void angleQuadrantDetector(Scanner sc) {
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        // Normalize angle to 0°–360°
        angle = angle % 360;
        if (angle < 0) angle += 360;

        if (angle == 0 || angle == 180) {
            System.out.println("On x-axis");
        } else if (angle == 90 || angle == 270) {
            System.out.println("On y-axis");
        } else if (angle < 90) {
            System.out.println("Quadrant I: sin+, cos+, tan+");
        } else if (angle < 180) {
            System.out.println("Quadrant II: sin+, cos-, tan-");
        } else if (angle < 270) {
            System.out.println("Quadrant III: sin-, cos-, tan+");
        } else {
            System.out.println("Quadrant IV: sin-, cos+, tan-");
        }

        /*
         * GUIDE QUESTIONS:
         * 1. Why do we normalize angles?
         *    → To convert any angle (negative or >360°) into the standard range.
         *
         * 2. How do trigonometric signs change by quadrant?
         *    → Using the ASTC rule:
         *      QI: All positive
         *      QII: Sine positive
         *      QIII: Tangent positive
         *      QIV: Cosine positive
         *
         * 3. What happens at axis angles?
         *    → At 0°, 90°, 180°, and 270°, some functions are zero or undefined.
         */
    }

    // ============================================================
    // PROBLEM 3: RIGHT TRIANGLE SOLVER
    // ============================================================
    static void rightTriangleSolver(Scanner sc) {
        System.out.println("1. Two sides\n2. One side + one angle");
        int type = sc.nextInt();

        double a = 0, b = 0, c = 0, A = 0, B = 0;

        switch (type) {
            case 1 -> {
                System.out.print("Enter side a: ");
                a = sc.nextDouble();
                System.out.print("Enter side b: ");
                b = sc.nextDouble();
                // Pythagorean Theorem
                c = sqrt(a * a + b * b);
                // Trigonometric calculation of angles
                A = toDegrees(atan2(a, b));
                B = 90 - A;
            }
            case 2 -> {
                System.out.print("Enter side a: ");
                a = sc.nextDouble();
                System.out.print("Enter angle A (<90): ");
                A = sc.nextDouble();
                if (A <= 0 || A >= 90) {
                    System.out.println("Invalid angle.");
                    return;
                }   double radA = toRadians(A);
                c = a / sin(radA);
                b = c * cos(radA);
                B = 90 - A;
            }
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        double area = 0.5 * a * b;

        System.out.println("Sides: a=" + a + ", b=" + b + ", c=" + c);
        System.out.println("Angles: A=" + A + "°, B=" + B + "°, C=90°");
        System.out.println("Area = " + area);

        /*
         * GUIDE QUESTIONS:
         * 1. Why use the Pythagorean Theorem?
         *    → Because it relates the sides of a right triangle.
         *
         * 2. Why must the angle be less than 90°?
         *    → A right triangle has only one right angle.
         *
         * 3. How can this be expanded?
         *    → By allowing other known sides or solving oblique triangles.
         */
    }

    // ============================================================
    // PROBLEM 4: TRIGONOMETRIC IDENTITY VERIFIER
    // ============================================================
    static void trigonometricIdentityVerifier(Scanner sc) {
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        double rad = toRadians(angle);

        double s = sin(rad);
        double c = cos(rad);

        System.out.println("sin²θ + cos²θ = " + (s * s + c * c));

        if (abs(c) > 1e-10) {
            double t = tan(rad);
            System.out.println("1 + tan²θ = " + (1 + t * t));
            System.out.println("sec²θ = " + (1 / (c * c)));
        } else {
            System.out.println("tan and sec undefined at this angle.");
        }

        System.out.println("sin(2θ) = " + sin(2 * rad));
        System.out.println("2sinθcosθ = " + (2 * s * c));

        /*
         * GUIDE QUESTIONS:
         * 1. Why use a tolerance in comparisons?
         *    → Floating-point values are not perfectly exact.
         *
         * 2. Which identity is most error-prone?
         *    → 1 + tan²θ = sec²θ due to division by cos(θ).
         *
         * 3. How can this tool be improved?
         *    → By adding more identities and symbolic checks.
         */
    }

    // ============================================================
    // PROBLEM 5: WAVE PROPERTIES ANALYZER
    // ============================================================
    static void wavePropertiesAnalyzer(Scanner sc) {
        System.out.print("Amplitude: ");
        double A = sc.nextDouble();
        System.out.print("Frequency: ");
        double f = sc.nextDouble();
        System.out.print("Phase shift (degrees): ");
        double phi = toRadians(sc.nextDouble());
        System.out.print("Time: ");
        double t = sc.nextDouble();

        // Wave equation: y = A sin(2πft + φ)
        double value = A * sin(2 * PI * f * t + phi);
        System.out.println("Wave value = " + value);

        // Compute next peak
        double nextPeak = (PI / 2 - phi) / (2 * PI * f);
        while (nextPeak < t)
            nextPeak += 1 / f;

        System.out.println("Next peak at t ≈ " + nextPeak);

        /*
         * GUIDE QUESTIONS:
         * 1. Why use 2πf in the wave equation?
         *    → One full wave cycle equals 2π radians.
         *
         * 2. What does phase shift do?
         *    → It shifts the wave left or right in time.
         *
         * 3. Why calculate the next peak?
         *    → To predict wave behavior in physics, audio, and electronics.
         */
    }
}
