package com.epam.jwd.interpreter;

public class ToTheRight implements Expression {
    private final int value;
    private final int amount;

    public ToTheRight(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public int interpret(int value,int amount) {
        return value >> amount;
    }
}
