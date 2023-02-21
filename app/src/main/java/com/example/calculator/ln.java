package com.example.calculator;

public class ln implements singleArgOperation{
    @Override
    public String calculate(double argument) {
        return df.format(Math.log(argument));
    }
}
