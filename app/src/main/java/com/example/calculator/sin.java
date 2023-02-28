package com.example.calculator;

/**
 * Perform the Math.sin operation.
 */
public class sin implements trigOperation {
    // TODO - add your solution here.


    /**
     * A method for returning the result of Math sin of the given argument
     * @param argument: left argument
     * @return: string value of sin operation
     */

    @Override
    public String calculate(double argument) {

        double radians = Math.toRadians(argument);

        return df.format(Math.sin(radians));
    }

    /**
     * A method for returning the result of a sin inverse operation
     * @param argument: given argument
     * @return: string value of sin inverse operation
     */
    public String calculateInverse(double argument){
        if(argument == 0){
            return 0 + "";
        }
        return df.format(Math.toDegrees(Math.asin(argument)));
    }
}
