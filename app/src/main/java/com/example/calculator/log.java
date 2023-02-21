package com.example.calculator;

public class log implements singleArgOperation{
    @Override
    public String calculate(double argument) {
        return df.format(Math.log10(argument));
    }
}
