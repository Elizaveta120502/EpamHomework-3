package com.epam.jwd.interpreter;

@FunctionalInterface
public interface Expression<Integer> {

    int interpret(int firstValue, int secondValue);
}
