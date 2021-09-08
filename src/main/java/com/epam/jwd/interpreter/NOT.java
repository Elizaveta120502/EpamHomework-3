package com.epam.jwd.interpreter;

public class NOT implements Expression {



    @Override
    public void interpret(ExpressionsStack expressionsStack) {

         expressionsStack.pushValue(~expressionsStack.popValue());
    }


}
