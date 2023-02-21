package com.example.calculator;

public class cos implements singleArgOperation{
    @Override
    public String calculate(double argument) {
        double radians = Math.toRadians(argument);

        return df.format(Math.cos(radians));
    }
}
