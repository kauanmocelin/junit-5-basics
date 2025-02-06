package dev.kauanmocelin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @AfterAll
    static void afterAllInit() {
        System.out.println("This needs to run after all");
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
        @DisplayName("Test integer addition [addendA, addendB, expectedResult]")
        @ParameterizedTest
        @MethodSource
        void integerAddition(int addendA, int addendB, int expectedResult) {
            final int result = mathUtils.sum(addendA, addendB);
            assertThat(result)
                .as(() -> String.format("%s + %s did not produce %s", addendA, addendB, expectedResult))
                .isEqualTo(expectedResult);
        }
        private static Stream<Arguments> integerAddition() {
            return Stream.of(
                Arguments.of(2,3,5),
                Arguments.of(15,5,20),
                Arguments.of(50,100,150)
            );
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
    @DisplayName("should return ArithmeticException when divided by zero")
    void shouldReturnArithmeticExceptionWhenDividedByZero() {
        assertThatThrownBy(() -> mathUtils.divide(1, 0))
            .as("division by zero should have throw an ArithmeticException")
            .isInstanceOf(ArithmeticException.class)
            .as("unexpected exception message")
            .hasMessage("/ by zero");

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