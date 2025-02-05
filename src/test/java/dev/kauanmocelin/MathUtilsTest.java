package dev.kauanmocelin;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.assertj.core.api.Fail.fail;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayName("When running MathUtils")
class MathUtilsTest {

    private MathUtils mathUtils;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("sum method")
    @Tag("Math")
    class Sum {
        @Test
        @DisplayName("should return five when sum two with three")
        void shouldReturnFiveWhenSumTwoWithThree() {
            // Arrange
            var parameterA = 2;
            var parameterB = 3;
            var expectedResult = 5;
            // Act
            final int result = mathUtils.sum(parameterA, parameterB);
            // Assert
            assertThat(result)
                .as(() -> String.format("%s + %s did not produce %s", parameterA, parameterB, expectedResult))
                .isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("should return minus five when sum minus two with minus three")
        void shouldReturnMinusFiveWhenSumMinusTwoWithMinusThree() {
            final int result = mathUtils.sum(-2, -3);
            assertThat(result).isEqualTo(-5);
        }
    }

    @Test
    @Tag("Math")
    @DisplayName("should return ArithmeticException when divide by zero")
    void shouldReturnArithmeticExceptionWhenDivideByZero() {
        assertThatThrownBy(() -> mathUtils.divide(1, 0))
                .isInstanceOf(ArithmeticException.class);
    }

    @RepeatedTest(3)
    @Tag("Circle")
    @DisplayName("should return three hundred fourteen when calculate circle area")
    void shouldReturnThreeHundredFourteenWhenCalculateCircleArea(RepetitionInfo repetitionInfo) {
//        repetitionInfo.getCurrentRepetition();
        assertThat(mathUtils.calculateCircleArea(10)).isEqualTo(314.1592653589793);
    }

    @Test
    @Tag("Math")
    @DisplayName("should multiply two numbers when successful")
    void shouldMultiplyTwoNumbersWithSuccessful() {
//        System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
//        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
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
    @Disabled
    void testAssumptions() {
        boolean isServerUp = false;
        assumeThat(isServerUp).isTrue();
        // test will be run only if server is up
    }
}