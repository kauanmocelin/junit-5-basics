package dev.kauanmocelin;

public class MathUtils {
    public int sum(int parameterA, int parameterB) {
        return parameterA + parameterB;
    }

    public int subtract(int parameterA, int parameterB) {
        return parameterA - parameterB;
    }

    public int multiply(int parameterA, int parameterB) {
        return parameterA * parameterB;
    }

    public int divide(int parameterA, int parameterB) {
        return parameterA / parameterB;
    }

    public Double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
