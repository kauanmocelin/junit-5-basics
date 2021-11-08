package dev.kauanmocelin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MathUtilsTest {

    @Test
    void shouldReturnSumFromTwoNumbersWithSuccessful() {
        final MathUtils mathUtils = new MathUtils();

        final Double result = mathUtils.sum(2.0, 3.0);

        assertThat(result).isEqualTo(5.0);
    }
}