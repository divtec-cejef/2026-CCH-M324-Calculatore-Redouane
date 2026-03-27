package ch.divtec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddNombresPositif() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void testAddPremierNombreNegatif() {
        assertEquals(1, calculator.add(-1, 2));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-1, calculator.add(-3, 2));
    }

    @Test
    void testAddDeuxiemeNombreNegatif() {
        assertEquals(-1, calculator.add(1, -2));
        assertEquals(0, calculator.add(2, -2));
        assertEquals(1, calculator.add(3, -2));
    }

    @Test
    void testAddNombresNegatif() {
        assertEquals(-3, calculator.add(-1, -2));
        assertEquals(-4, calculator.add(-2, -2));
        assertEquals(-5, calculator.add(-3, -2));
    }
}