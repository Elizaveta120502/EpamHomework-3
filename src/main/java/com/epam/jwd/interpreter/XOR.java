package com.epam.jwd.interpreter;

public class XOR implements Expression {

    private final int firstValue;
    private final int secondValue;

    public XOR(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public int interpret(int value, int secondValue) {
        return firstValue ^ secondValue;
    }
}
