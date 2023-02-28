package com.example.calculator;

public class cos implements trigOperation{
    @Override
    public String calculate(double argument) {
        double radians = Math.toRadians(argument);

        return df.format(Math.cos(radians));
    }


    /**
     * A method for returning the result of a cos inverse operation
     * @param argument: given argument
     * @return: string value of cos inverse operation
     */
    public String calculateInverse(double argument){
        if(argument == 1){
            return 0 + "";
        }
        return df.format(Math.toDegrees(Math.acos(argument)));

    }
}
