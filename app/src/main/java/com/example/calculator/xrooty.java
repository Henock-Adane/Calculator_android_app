package com.example.calculator;

public class xrooty implements Operation{
    @Override
    public String calculate(double arg1, double arg2) {
        return df.format(Math.pow(arg2,(1/arg1)));
    }
}
