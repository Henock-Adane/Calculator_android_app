package com.example.calculator;

/**
 * Perform the Divide operation.
 */
public class Divide implements Operation{
    // TODO - add your solution here.



    /**
     * A method for returning the result of division of two arguments.
     * @param arg1: left argument
     * @param arg2: right argument
     * @return: string value of division.
     */
    @Override
    public String calculate(double arg1, double arg2) {
        try {
            return (df.format(arg1/arg2));
        }
        catch (ArithmeticException e) {
            return ("Second argument can't be zero on division!");
        }

    }

}
