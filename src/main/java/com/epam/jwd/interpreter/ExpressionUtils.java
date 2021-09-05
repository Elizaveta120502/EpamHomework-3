package com.epam.jwd.interpreter;

public class ExpressionUtils {
    public static boolean isOperator(String s) {
        if (s.equals(">>") || s.equals("<<") || s.equals("&")
                || s.equals("|") || s.equals("~") || s.equals("^")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOperand(String s) {
        if (s.equals("\\d")) {
            return true;
        } else {
            return false;
        }
    }

    public static Expression getOperator(String s, int firstValue, int secondValue) {
        switch (s) {
            case ">>":
                return new ToTheRight(firstValue, secondValue);
            case "<<":
                return new ToTheLeft(firstValue, secondValue);

            case "&":
                return new AND(firstValue, secondValue);

            case "|":
                return new OR(firstValue, secondValue);

            case "~":
                return new NOT(firstValue);

            case "^":
                return new XOR(firstValue, secondValue);
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
    }

}



