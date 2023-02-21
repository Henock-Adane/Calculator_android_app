package com.example.calculator;

public class tan implements singleArgOperation{
    @Override
    public String calculate(double argument) {
        double radians = Math.toRadians(argument);

        return df.format(Math.tan(radians));
    }
}
