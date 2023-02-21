package com.example.calculator;

/**
 * Perform the Math.sin operation.
 */
public class sin implements singleArgOperation {
    // TODO - add your solution here.


    /**
     * A method for returning the result of Math sin of the given argument
     * @param argument: left argument
     * @return: string value of addition
     */

    @Override
    public String calculate(double argument) {

        double radians = Math.toRadians(argument);

        return df.format(Math.sin(radians));
    }
}
