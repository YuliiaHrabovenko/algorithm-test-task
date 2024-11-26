package com.test.task;

import java.math.BigInteger;

public class SumOfDigitsInFactorial {

    // Calculate the factorial of a given number using recursion
    public static BigInteger calculateFactorial(int n) {
        // Base case
        if (n == 0) {
            return BigInteger.ONE;
        }
        // Recursive case
        return calculateFactorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    public static int sumOfDigitsInFactorial(int n) {
        // Compute the factorial of the input number
        BigInteger factorial = calculateFactorial(n);

        int digitSum = 0;

        // Convert the factorial result to a string to iterate through its digits
        String factorialStr = factorial.toString();

        // Sum the numeric value of each digit in the factorial
        for (char ch : factorialStr.toCharArray()) {
            digitSum += Character.getNumericValue(ch);
        }

        return digitSum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigitsInFactorial(100));
    }
}
