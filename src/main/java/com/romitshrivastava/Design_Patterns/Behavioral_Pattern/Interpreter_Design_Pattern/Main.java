package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Interpreter_Design_Pattern;



// Abstract Expression
 interface Expression {
    int interpret();
}

// Terminal Expression - representing numbers
 class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

// Non-terminal Expression - Addition
 class Addition implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Addition(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

// Non-terminal Expression - Subtraction
 class Subtraction implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Subtraction(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}




// Client - The Interpreter that evaluates the expressions
 class InterpreterClient {
    public static void main(String[] args) {
        // (5 + 10) - 3
        Expression five = new Number(5);
        Expression ten = new Number(10);
        Expression three = new Number(3);

        // Create a compound expression
        Expression add = new Addition(five, ten);
        Expression subtract = new Subtraction(add, three);

        // Interpret the final result
        System.out.println("Result: " + subtract.interpret());  // Output: Result: 12
    }
}