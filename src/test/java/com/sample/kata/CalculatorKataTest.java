package com.sample.kata;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator Kata Test")
public class CalculatorKataTest {

    private static CalculatorKata calculator;

    @BeforeAll
    static void setUp() {
        calculator = new CalculatorKata();
    }

    @DisplayName("Empty String")
    @Test
    void testCalculate() {
        assertEquals(0, calculator.calculate(""));
    }

    @DisplayName("Single Number")
    @Test
    void testCalculate_1() {
        assertEquals(1, calculator.calculate("1"));
    }

    @DisplayName("Two Numbers with Comma Delimited")
    @Test
    void testCalculate_2() {
        assertEquals((2 + 3), calculator.calculate("2,3"));
    }

    @DisplayName("Two Numbers with New Line Delimited")
    @Test
    void testCalculate_3() {
        assertEquals((2 + 3), calculator.calculate("2\n3"));
    }

    @DisplayName("Three Numbers with Comma Delimited")
    @Test
    void testCalculate_4() {
        assertEquals((2 + 3 + 5), calculator.calculate("2,3,5"));
    }

    @DisplayName("Three Numbers with New Line Delimited")
    @Test
    void testCalculate_5() {
        assertEquals((2 + 3 + 5), calculator.calculate("2\n3\n5"));
    }

    @DisplayName("Three Numbers with Command or New Line Delimited")
    @Test
    void testCalculate_6() {
        assertEquals((2 + 3 + 5), calculator.calculate("2\n3,5"));
    }

    @DisplayName("Negative Numbers Throws an Exception")
    @Test
    void testCalculate_7() {
        Throwable throwable = assertThrows(NumberFormatException.class, () -> calculator.calculate("-5,-4,-4"));
        assertEquals("Cannot Calculate Negative Numbers", throwable.getMessage());
    }

    @DisplayName("Numbers Greater than 1000 are ignored")
    @Test
    void testCalculate_8() {
        assertEquals((5 + 3), calculator.calculate("1001,5,3"));
    }

    @DisplayName("A single char delimiter can be defined on the first line (e.g. //# for a ‘#’ as the delimiter)")
    @Test
    void testCalculate_9() {
        assertEquals((5 + 3 + 10), calculator.calculate("//#5#3#10"));
    }

    @DisplayName("A multi char delimiter can be defined on the first line (e.g. //[###] for ‘###’ as the delimiter)")
    @Test
    void testCalculate_10() {
        assertEquals((5 + 3 + 10), calculator.calculate("//##5##3##10"));
    }

    @AfterAll
    static void tearDown() {
        calculator = null;
    }
}