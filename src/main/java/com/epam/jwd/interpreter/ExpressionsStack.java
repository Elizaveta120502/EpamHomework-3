package com.epam.jwd.interpreter;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionsStack {
    private static final String  BINARY_EXPRESSION_REGEX = "[0-9~&>{2}<{2}(\\^\\|]";
    private static final String  WHITESPACE_REGEX = "\s";


    private static int getResultOfBitOperation(String s,int firstValue ,int secondValue){
        Stack<Expression> stack = new Stack<>();
        s.replaceAll("",WHITESPACE_REGEX);
        String[] tokenArray = s.split(WHITESPACE_REGEX);
        List<Integer> numberArray = new ArrayList<>();
        final Expression expression = null;

        Expression operator;
        for (String str : tokenArray){
            do {
                if (ExpressionUtils.isOperator(s)) {
                    operator = stack.push(ExpressionUtils.getOperator(s, firstValue, secondValue));

                }
                if (ExpressionUtils.isOperand(s)) {

                    int operand = Integer.valueOf(s);
                    numberArray.add(operand);

                }
            }while (numberArray.size() < 2);
            operator = stack.pop();
             (numberArray.get(0),numberArray.get(1)) -> {

            }
            int result =


        }
        return
    }

}
