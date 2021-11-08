package dev.kauanmocelin;

public class MathUtils {
    public Double sum(double parameterA, double parameterB) {
        return parameterA + parameterB;
    }

    public Double subtract(double parameterA, double parameterB) {
        return parameterA - parameterB;
    }

    public Double multiply(double parameterA, double parameterB) {
        return parameterA * parameterB;
    }

    public Double divide(double parameterA, double parameterB) {
        return parameterA / parameterB;
    }

    public Double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
