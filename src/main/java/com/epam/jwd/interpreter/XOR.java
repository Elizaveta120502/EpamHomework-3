package com.epam.jwd.interpreter;

public class XOR implements Expression {

    @Override
    public void interpret(ExpressionsStack expressionsStack)
    {
         expressionsStack.pushValue(expressionsStack.popValue()^ expressionsStack.popValue());
    }
}
