package dev.kauanmocelin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    void shouldReturnSumFromTwoNumbersWithSuccessful() {
        final int result = mathUtils.sum(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void shouldReturnArithmeticExceptionWhenDivideByZero() {
        assertThatThrownBy(() -> mathUtils.divide(1, 0))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void shouldReturnRightCircleAreaWhenSuccessful() {
        assertThat(mathUtils.calculateCircleArea(10)).isEqualTo(314.1592653589793);
    }
}