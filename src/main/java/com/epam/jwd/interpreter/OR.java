package com.epam.jwd.interpreter;

public class OR  implements Expression{
    private final int firstValue;
    private final int secondValue;

    public OR(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public int interpret(int firstValue,int secondValue) {
        return firstValue | secondValue;
    }
}




