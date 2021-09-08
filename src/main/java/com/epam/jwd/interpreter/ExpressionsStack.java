package com.epam.jwd.interpreter;


import java.util.ArrayDeque;

public class ExpressionsStack {

    private static final String WHITESPACE_REGEX = "\s";


    ArrayDeque<Integer> contextValues = new ArrayDeque<Integer>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}

//    int result = 0;
//    Expression operator = null;
//    Stack<Expression> stack = new Stack<>();
//    List<Integer> numberArray = new ArrayList<>();
//    String[] tokenArray  = new String [SymbolReader.getInstance().parse(text).size()];
//    //SymbolReader.getInstance().parse(text) = ;
//
//
//
//
//    final Expression<Integer> expression;
//
//        for (String str : tokenArray) {
//        //  str.replaceAll("", WHITESPACE_REGEX);
//        do {
//            if (ExpressionUtils.isOperator(str)) {
//                operator = stack.push(ExpressionUtils.getOperator(str,
//                        ExpressionUtils.isOperand(str),
//                        ExpressionUtils.isOperand(str)));
//            }
//
//            operator = stack.pop();
//            result = operator.interpret(numberArray.get(0), numberArray.get(1));
//
//        } while (numberArray.size() < 100);
//
//    }
//
//
//        return result;
//}


