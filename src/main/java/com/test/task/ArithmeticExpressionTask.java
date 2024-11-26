package com.test.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpressionTask {

    public static int countValidSubexpressions(String expression, int N) {
        List<String> validSubexpressions = new ArrayList<>();

        // Iterate through the string to extract all substrings
        for (int start = 0; start < expression.length() - 2 * N + 1; start++) {
            String subexpression = expression.substring(start, start + 2 * N);

            // Check if the substring is valid and not already added to the list
            if (!subexpression.isEmpty() && isBalancedParentheses(subexpression) && !validSubexpressions.contains(subexpression)) {
                validSubexpressions.add(subexpression);
            }
        }

        // Return the count of valid substrings
        return validSubexpressions.size();
    }

    public static boolean isBalancedParentheses(String subexpression) {
        Stack<Character> stack = new Stack<>();

        // Validate if the subexpression has balanced parentheses
        for (Character ch : subexpression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                // If a closing parenthesis appears without a matching opening, return false
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        // Ensure no unmatched opening parentheses remain
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the arithmetic expression:");
        // Remove all characters except parentheses from the input string
        String parenthesesOnlyExpression = scanner.nextLine().replaceAll("[^()]", "");

        System.out.println("Enter the value of N (number of pairs):");
        int N = scanner.nextInt();

        System.out.println(countValidSubexpressions(parenthesesOnlyExpression, N));
    }
}

