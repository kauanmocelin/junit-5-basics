package dev.kauanmocelin;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.assertj.core.api.Fail.fail;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayName("When running MathUtils")
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

    @Nested
    @DisplayName("sum method")
    class Sum {
        @Test
        @DisplayName("should sum two positive numbers when successful")
        void shouldSumTwoNumbersWithSuccessful() {
            final int result = mathUtils.sum(2, 3);
            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("should sum two negative numbers when successful")
        void shouldSumTwoNegativeNumbersWithSuccessful() {
            final int result = mathUtils.sum(-2, -3);
            assertThat(result).isEqualTo(-5);
        }
    }

    @Test
    @DisplayName("Should return ArithmeticException when divide by zero")
    void shouldReturnArithmeticExceptionWhenDivideByZero() {
        assertThatThrownBy(() -> mathUtils.divide(1, 0))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("should return right circle area when successful")
    void shouldReturnRightCircleAreaWhenSuccessful() {
        assertThat(mathUtils.calculateCircleArea(10)).isEqualTo(314.1592653589793);
    }

    @Test
    @DisplayName("should multiply two numbers when successful")
    void shouldMultiplyTwoNumbersWithSuccessful() {
        assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(mathUtils.multiply(2, 2)).isEqualTo(4);
                    softAssertions.assertThat(mathUtils.multiply(2, 0)).isEqualTo(0);
                    softAssertions.assertThat(mathUtils.multiply(2, -1)).isEqualTo(-2);
                }
        );
    }

    @Test
    @Disabled
    void testDisabled() {
        fail("This test should be disabled");
    }

    @Test
    void testAssumptions() {
        boolean isServerUp = false;
        assumeThat(isServerUp).isTrue();
        // test will be run only if server is up
    }
}