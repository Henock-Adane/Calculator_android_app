package com.example.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * A calculator class for accepting arguments and an operator
 * and performs operations based on the operator.
 */

public class Calculator {

    protected String operation;
    protected double argument1;
    protected double argument2;


    /**
     * A hashMap for storing an int key and corresponding operation classes.
     */
    public static Map<String, Operation> operationMap = new HashMap<>();


    /**
     * Constructor for the calculator class
     * @param argument1: the left operand
     * @param argument2: the right operand
     * @param operation: the selected operation's String value.
     */
    public Calculator(double argument1, double argument2, String operation) {
        this.argument1 = argument1;
        this.argument2 = argument2;
        this.operation = operation;


        /**
         * filling the operationMap hashMap with keys and values
         */
        operationMap.put("+",new Add());
        operationMap.put("-", new Subtract());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());

    }


    /**
     * A method for calling the selected operations class passing the arguments.
     * @return: A string value received from the selected operation class.
     */
    public String answerMe() {
        /**
         * instantiating the Operation interface.
         */
        Operation operationMapValue = null;


        /**
         * setting the Operation interface instance to the
         * passed operation class which implements it.
         */
        if(operationMap.containsKey(operation)) {
            operationMapValue = operationMap.get(operation);
        }
            String result = operationMapValue.calculate(argument1, argument2);

        if(result.endsWith(".000000000")){
            result = result.replace(".000000000", "");
        }

        return result;
    }
}
