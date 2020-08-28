package com.zrx.algorithm.专题;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 中缀表达式求值
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class 中缀表达式求值 {
    private final static Logger LOGGER = LoggerFactory.getLogger(中缀表达式求值.class);

    public int cal(String s) {
        List<Token> tokenList = parse(s);

        Deque<Integer> operandStack = new LinkedList<>();

        Deque<TokenType> operatorStack = new LinkedList<>();

        tokenList.forEach(token -> {
            TokenType type = token.tokenType;
            switch (type) {
                case INT -> operandStack.push((Integer) token.val);
                case LEFT_BRACKET -> operatorStack.push(type);
                case RIGHT_BRACKET -> {
                    while (!operatorStack.peek().equals(TokenType.LEFT_BRACKET)) simplify(operandStack, operatorStack);
                    operatorStack.pop();
                }
                case PLUS, MINUS, MUL, DIV -> {
                    if (!operatorStack.isEmpty() && operatorStack.peek().isBiOp() && operatorStack.peek().priority >= type.priority) {
                        simplify(operandStack, operatorStack);
                    }
                    operatorStack.push(type);
                }
            }
        });
        while (!operatorStack.isEmpty()) simplify(operandStack, operatorStack);
        return operandStack.pop();
    }

    private void simplify(Deque<Integer> operandStack, Deque<TokenType> operatorStack) {
        TokenType type = operatorStack.pop();
        Integer b = operandStack.pop();
        Integer a = operandStack.pop();
        switch (type) {
            case INT -> throw new RuntimeException();
            case PLUS -> operandStack.push(a + b);
            case MINUS -> operandStack.push(a - b);
            case MUL -> operandStack.push(a * b);
            case DIV -> operandStack.push(a / b);
            case LEFT_BRACKET -> throw new RuntimeException();
            case RIGHT_BRACKET -> throw new RuntimeException();
        }
    }

    // 解析
    public List<Token> parse(String s) {
        List<Token> tokenList = new ArrayList<>();

        Integer num = null;

        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                if (num == null) num = ch - '0';
                else num = num * 10 + ch - '0';
            } else if (ch == '(') {
                tokenList.add(new Token(null, TokenType.LEFT_BRACKET));
            } else if (ch == ')') {
                if (num != null) tokenList.add(new Token(num, TokenType.INT));
                num = null;
                tokenList.add(new Token(null, TokenType.RIGHT_BRACKET));
            } else {
                if (num != null) tokenList.add(new Token(num, TokenType.INT));
                num = null;
                switch (ch) {
                    case '+' -> tokenList.add(new Token(null, TokenType.PLUS));
                    case '-' -> tokenList.add(new Token(null, TokenType.MINUS));
                    case '*' -> tokenList.add(new Token(null, TokenType.MUL));
                    case '/' -> tokenList.add(new Token(null, TokenType.DIV));
                }
            }
        }

        if (num != null) tokenList.add(new Token(num, TokenType.INT));

        return tokenList;
    }

    private static class Token {
        Object val;
        TokenType tokenType;

        public Token(Object val, TokenType tokenType) {
            this.val = val;
            this.tokenType = tokenType;
        }

        @Override
        public String toString() {
            if (tokenType.equals(TokenType.INT)) return String.valueOf(val);
            else return tokenType.toString();
        }
    }


    private enum TokenType {
        INT(-1),
        PLUS(1),
        MINUS(1),
        MUL(2),
        DIV(2),
        LEFT_BRACKET(10),
        RIGHT_BRACKET(0);

        // 优先级
        int priority;

        TokenType(int priority) {
            this.priority = priority;
        }

        boolean isBiOp() {
            return equals(PLUS) || equals(MINUS) || equals(MUL) || equals(DIV);
        }

        @Override
        public String toString() {
            return switch (this) {
                case INT -> "int";
                case PLUS -> "+";
                case MINUS -> "-";
                case MUL -> "*";
                case DIV -> "/";
                case LEFT_BRACKET -> "(";
                case RIGHT_BRACKET -> ")";
            };
        }
    }
}
