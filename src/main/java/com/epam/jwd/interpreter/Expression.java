package com.epam.jwd.interpreter;

@FunctionalInterface
public interface Expression<Integer> {

     Integer interpret(int firstValue, int secondValue);
}
