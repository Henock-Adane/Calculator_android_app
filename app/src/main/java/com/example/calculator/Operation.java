package com.example.calculator;

import java.text.DecimalFormat;

/**
 * an interface
 */


public interface Operation {

    DecimalFormat df = new DecimalFormat("#.000000000");

    String calculate(double arg1, double arg2);

}
