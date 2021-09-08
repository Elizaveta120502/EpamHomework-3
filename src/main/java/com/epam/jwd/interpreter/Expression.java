package com.epam.jwd.interpreter;

@FunctionalInterface
public interface Expression<Integer> {

    void interpret(ExpressionsStack expressionsStack);
}
