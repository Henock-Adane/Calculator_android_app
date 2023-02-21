package com.example.calculator;

public class percent implements singleArgOperation{

    @Override
    public String calculate(double argument) {
        return df.format(argument/100);
    }
}
