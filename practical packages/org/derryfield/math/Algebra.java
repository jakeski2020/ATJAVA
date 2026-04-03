package org.derryfield.math;
public class Algebra {
    public static double harmonicMean(double x, double y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Both numbers must be positive.");
        }
        if ((x + y) == 0) {
            throw new IllegalArgumentException("Sum of numbers must not be zero.");
        }
        return (2 * x * y) / (x + y);
    }
}