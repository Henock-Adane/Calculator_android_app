package com.example.calculator;

public class power implements Operation{

    @Override
    public String calculate(double arg1, double arg2) {
        return df.format(Math.pow(arg1, arg2));
    }
}
