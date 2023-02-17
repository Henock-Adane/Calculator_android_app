package com.example.calculator;

/**
 * Perform the Multiply operation.
 */
public class Multiply implements Operation {
    // TODO - add your solution here.



    /**
     * A method for returning the result of multiplied arguments
     * @param arg1: left argument
     * @param arg2: right argument
     * @return: string value of multiplication.
     */
    public String calculate (double arg1, double arg2) {
        return df.format(arg1 * arg2);
    }
}
