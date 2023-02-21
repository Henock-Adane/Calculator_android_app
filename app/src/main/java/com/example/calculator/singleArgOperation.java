package com.example.calculator;


import java.text.DecimalFormat;

/**
 * an interface
 */


public interface singleArgOperation {
    DecimalFormat df = new DecimalFormat("#.000000000");

    String calculate(double argument);
}
