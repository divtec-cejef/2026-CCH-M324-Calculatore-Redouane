package ch.divtec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void add_TwoPositiveNumbers_ReturnsSum() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void add_FirstNumberNegative_ReturnsCorrectSum() {
        assertEquals(1, calculator.add(-1, 2));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-1, calculator.add(-3, 2));
    }

    @Test
    void add_SecondNumberNegative_ReturnsCorrectSum() {
        assertEquals(-1, calculator.add(1, -2));
        assertEquals(0, calculator.add(2, -2));
        assertEquals(1, calculator.add(3, -2));
    }

    @Test
    void add_BothNumbersNegative_ReturnsSum() {
        assertEquals(-3, calculator.add(-1, -2));
        assertEquals(-4, calculator.add(-2, -2));
        assertEquals(-5, calculator.add(-3, -2));
    }

    @Test
    void subtract_TwoPositiveNumbers_ReturnsDifference() {
        assertEquals(1, calculator.subtract(2, 1));
    }

    @Test
    void subtract_FirstNumberNegative_ReturnsDifference() {
        assertEquals(-3, calculator.subtract(-1, 2));
        assertEquals(-6, calculator.subtract(-1, 5));
    }

    @Test
    void subtract_WithZero_ReturnsSameNumber() {
        assertEquals(2, calculator.subtract(2, 0));
    }

    @Test
    void subtract_LargeNumbers_ReturnsDifference() {
        assertEquals(50000, calculator.subtract(100000, 50000));
    }

    @Test
    void multiply_TwoPositiveNumbers_ReturnsProduct() {
        assertEquals(2, calculator.multiply(1, 2));
    }

    @Test
    void multiply_NegativeNumber_ReturnsProduct() {
        assertEquals(-2, calculator.multiply(-1, 2));
    }

    @Test
    void multiply_WithZero_ReturnsZero() {
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    void multiply_LargeNumbers_ReturnsProduct() {
        assertEquals(50000, calculator.multiply(100, 500));
    }

    @Test
    void multiply_FirstZero_TestTableau() {
        assertEquals(0, calculator.multiply(0, -5649687), 0.0000000000000000000000000000000000001);
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnsQuotient() {
        assertEquals(0.5, calculator.divide(1, 2));
    }

    @Test
    void divide_NegativeNumber_ReturnsQuotient() {
        assertEquals(-0.5, calculator.divide(-1, 2));
    }

    @Test
    void divide_ZeroNumerator_ReturnsZero() {
        assertEquals(0, calculator.divide(0, 2));
    }

    @Test
    void divide_LargeNumbers_ReturnsQuotient() {
        assertEquals(2, calculator.divide(100000, 50000));
    }

    @Test
    void factorial_ZeroNumber_ReturnsOne() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorial_NumberDecimal_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(3.2);
        });

        String expectedMessage = "Number must be an integer.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void factorial_NegativeNumber_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           calculator.factorial(-3);
        });

        String expectedMessage = "Number must be positive.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}