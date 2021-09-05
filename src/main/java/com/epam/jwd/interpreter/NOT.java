package com.epam.jwd.interpreter;

public class NOT implements Expression{

    private final int value;



    public NOT(int value) {
        this.value = value;
    }

    @Override
    public int interpret(int value,int secondValue) {
        return ~value;
    }


}
