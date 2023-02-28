package com.example.calculator;

import java.text.DecimalFormat;

/**
 * an interface
 */

public interface trigOperation {
    DecimalFormat df = new DecimalFormat("#.000000000");

    String calculate(double argument);
    String calculateInverse(double argument);
}
