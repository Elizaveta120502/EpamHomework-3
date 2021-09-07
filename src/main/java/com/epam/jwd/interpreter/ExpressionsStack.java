package com.epam.jwd.interpreter;


import com.epam.jwd.parser.SymbolReader;
import com.epam.jwd.reader.ReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionsStack {

    private static final String WHITESPACE_REGEX = "\s";


    public static int getResultOfBitOperation(String text) throws IOException {
        int result = 0;
        Expression operator = null;
        Stack<Expression> stack = new Stack<>();
        List<Integer> numberArray = new ArrayList<>();
        SymbolReader.getInstance().parse(text);

        String[] tokenArray = text.split(WHITESPACE_REGEX);

        final Expression<Integer> expression;

        for (String str : tokenArray) {
          //  str.replaceAll("", WHITESPACE_REGEX);
            do {
                if (ExpressionUtils.isOperator(str)) {
                    operator = stack.push(ExpressionUtils.getOperator(str,
                            ExpressionUtils.isOperand(str),
                            ExpressionUtils.isOperand(str)));
                }

                operator = stack.pop();
                result = operator.interpret(numberArray.get(0), numberArray.get(1));

            } while (numberArray.size() < 100);

        }


        return result;
    }

}


