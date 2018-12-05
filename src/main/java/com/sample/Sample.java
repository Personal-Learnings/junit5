package com.sample;

public class Sample {
    public String display() {
        return "Hello";
    }

    public String giveBack(String input) {
        return input;
    }

    public void throwBack() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException("Exceeds Array Maximum Size");
    }
}
