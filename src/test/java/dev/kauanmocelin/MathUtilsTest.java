package dev.kauanmocelin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MathUtilsTest {

    @Test
    void shouldReturnSumFromTwoNumbersWithSuccessful() {
        final MathUtils mathUtils = new MathUtils();
        final int result = mathUtils.sum(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void shouldReturnArithmeticExceptionWhenDivideByZero() {
        final MathUtils mathUtils = new MathUtils();
        assertThatThrownBy(() -> mathUtils.divide(1, 0))
                .isInstanceOf(ArithmeticException.class);
    }
}