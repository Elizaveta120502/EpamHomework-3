package com.epam.jwd.interpreter;

public class Value implements Expression {

    private final int baseValue;

    public Value(int baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public int interpret(int value, int secondValue) {
        return baseValue;
    }
}
