package com.example.calculator;

public class tan implements trigOperation{
    @Override
    public String calculate(double argument) {
        double radians = Math.toRadians(argument);

        return df.format(Math.tan(radians));
    }


    /**
     * A method for returning the result of a tan inverse operation
     * @param argument: given argument
     * @return: string value of tan inverse operation
     */
    public String calculateInverse(double argument){
        if(argument == 0){
            return 0 + "";
        }
        return df.format(Math.toDegrees(Math.atan(argument)));

    }
}
