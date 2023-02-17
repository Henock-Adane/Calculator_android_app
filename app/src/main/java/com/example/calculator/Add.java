package com.example.calculator;

/**
 * Perform the Add operation.
 */
public class Add implements Operation {
    // TODO - add your solution here.



    /**
     * A method for returning the result of added arguments
     * @param arg1: left argument
     * @param arg2: right argument
     * @return: string value of addition
     */
    public String calculate(double arg1, double arg2) {
        return df.format(arg1 + arg2);
    }
}
