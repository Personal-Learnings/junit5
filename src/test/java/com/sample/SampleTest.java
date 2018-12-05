package com.sample;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Sample Class Test Case")
class SampleTest {

    private static Sample sample;

    @BeforeAll
    static void startup() {
        sample = new Sample();
    }

    @DisplayName("Usual Test Case for Display Method")
    @RepeatedTest(2)
    @Tag("Development")
    void testDisplay() {
        assertEquals("Hello", sample.display());
    }

    @ParameterizedTest
    @DisplayName("Parameterized Test Case for Display Method")
    @ValueSource(strings = "Hello")
    @Tag("Development")
    void testDisplay(String value) {
        assertEquals(value, sample.display());
    }

    @ParameterizedTest
    @MethodSource("sourceGiveBack")
    @DisplayName("Test Case for Give Back Method")
    void testGiveBack(String value) {
        assertEquals(value, sample.giveBack(value));
    }

    @ParameterizedTest
    @ValueSource(strings = "Exceeds Array Maximum Size")
    void testThrowBack(String arg) {
        Throwable throwable = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
           sample.throwBack();
        });
        assertEquals(arg, throwable.getMessage());
    }

    static Stream<String> sourceGiveBack() {
        return Stream.of("Hello", "Madan", "Ranjith");
    }

    @AfterAll
    static void tearDown() {
        sample = null;
    }
}