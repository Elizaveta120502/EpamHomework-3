package com.epam.jwd.interpreter;

public class ToTheLeft implements Expression{

    private final int value;
    private final int amount;

    public ToTheLeft(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public int interpret(int value,int secondValue) {
        return value << amount;
    }
}


