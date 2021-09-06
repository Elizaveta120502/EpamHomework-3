package com.epam.jwd.interpreter;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionsStack {

    private static final String WHITESPACE_REGEX = "\s";


    public static int getResultOfBitOperation(String s, int firstValue, int secondValue) {
        int result = 0;
        Expression operator;

        Stack<Expression> stack = new Stack<>();
        List<Integer> numberArray = new ArrayList<>();

        s.replaceAll("", WHITESPACE_REGEX);
        String[] tokenArray = s.split(WHITESPACE_REGEX);

        final Expression<Integer> expression;

        for (String str : tokenArray) {
            do {
                if (ExpressionUtils.isOperator(str)) {
                    operator = stack.push(ExpressionUtils.getOperator(s, firstValue, secondValue));

                }
                if (ExpressionUtils.isOperand(str)) {

                    int operand = Integer.valueOf(str);
                    numberArray.add(operand);

                }
                operator = stack.pop();
                result = operator.interpret(numberArray.get(0), numberArray.get(1));

            } while (numberArray.size() < 2);

        }


        return result;
    }

}


