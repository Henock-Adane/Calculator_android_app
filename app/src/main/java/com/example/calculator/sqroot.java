package com.example.calculator;

public class sqroot implements singleArgOperation{
    @Override
    public String calculate(double argument) {
        return df.format(Math.sqrt(argument));
    }
}
