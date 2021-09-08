package com.epam.jwd.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private ArrayList<Expression> listExpression;
    private static Client client;
    private static String expr;

    public static Client getInstance(String expr) {
        if (client == null) {
            client = new Client(expr);
        }
        return client;
    }

    private Client() {
    }

    private Client(String expression) {
        this.listExpression = new ArrayList<>();
        parse(expression);
    }

    public void parse(String expression) {
        for (String lexeme : expression.split("\s")) {
            if (lexeme.isEmpty()) {
                continue;
            }

            switch (lexeme) {
                case ">":
                    listExpression.add(new ToTheRight());
                    break;
                case "<":
                    listExpression.add(new ToTheLeft());
                    break;

                case "&":
                    listExpression.add(new AND());
                    break;

                case "|":
                    listExpression.add(new OR());
                    break;

                case "~":
                    listExpression.add(new NOT());
                    break;

                case "^":
                    listExpression.add(new XOR());
                    break;

                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new Value(Integer.parseInt(lexeme)));

                    }

            }

        }


    }

    public Number calculate() {
        ExpressionsStack context = new ExpressionsStack();
        for (Expression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

}


