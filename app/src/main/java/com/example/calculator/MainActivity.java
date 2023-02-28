package com.example.calculator;

import static com.example.calculator.Calculator.operationMap;
import static com.example.calculator.Calculator.singleOperationMap;
import static com.example.calculator.Calculator.trigOperationMap;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 *Main class
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * A string representing the button pressed
     */
    String buttonText;

    /**
     * tag for logging
     */
    String Tag = "Exception: ";

    /**
     * Decimal formatting variable
     */
    DecimalFormat df = new DecimalFormat("#.000000000");

    /**
     * Double variable assigned to the Calculator object anserMe() method result
     */
    Double answer;

    /**
     * String variable for storing the current value on solution EditText
     */
    String fullArgument = "";

    /**
     * String for storing the displayed numbers
     */
    String displayedArgument = null;

    /**
     * Calculator object for accessing the calculating operations
     */
    Calculator calculator;

    /**
     * UI components of the app
     */
    EditText resultet, solutionet;
    ScrollView scroller;
    Button sin, cos, tan, pi, factorial, lan, log, exponent, power, sqroot, xrooty, percent,
    clear, clearAll, seven, eight, nine, divide, shift, four, five, six, multiply, brace, one, two,
    three, subtract, zero, dot, add, equalButton;

    /**
     * An int representing the current cursor position on the solution edittext
     */
    int currentCursorPosition = 0;


    /**
     * the onCreate hook method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }


    /**
     * initializing the UI
     */
    public void initializeUI(){
        scroller = findViewById(R.id.scroller);
        solutionet = findViewById(R.id.displayEt);
        resultet = findViewById(R.id.result);
        resultet.setEnabled(false);
        sin = findViewById(R.id.sin);
        sin.setOnClickListener(this);
        cos = findViewById(R.id.cos);
        cos.setOnClickListener(this);
        tan = findViewById(R.id.tan);
        tan.setOnClickListener(this);
        pi = findViewById(R.id.pi);
        pi.setOnClickListener(this);
        factorial = findViewById(R.id.factorial);
        factorial.setOnClickListener(this);
        lan = findViewById(R.id.lan);
        lan.setOnClickListener(this);
        log = findViewById(R.id.log);
        log.setOnClickListener(this);
        exponent = findViewById(R.id.exponent);
        exponent.setOnClickListener(this);
        power = findViewById(R.id.power);
        power.setOnClickListener(this);
        sqroot = findViewById(R.id.sqroot);
        sqroot.setOnClickListener(this);
        xrooty = findViewById(R.id.xrooty);
        xrooty.setOnClickListener(this);
        percent = findViewById(R.id.percent);
        percent.setOnClickListener(this);
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);
        clearAll = findViewById(R.id.clearall);
        clearAll.setOnClickListener(this);
        seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);
        eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);
        nine = findViewById(R.id.nine);
        nine.setOnClickListener(this);
        divide = findViewById(R.id.divide);
        divide.setOnClickListener(this);
        shift = findViewById(R.id.shift);
        shift.setOnClickListener(this);
        four = findViewById(R.id.four);
        four.setOnClickListener(this);
        five = findViewById(R.id.five);
        five.setOnClickListener(this);
        six = findViewById(R.id.six);
        six.setOnClickListener(this);
        multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(this);
        brace = findViewById(R.id.brace);
        brace.setOnClickListener(this);
        one = findViewById(R.id.one);
        one.setOnClickListener(this);
        two = findViewById(R.id.two);
        two.setOnClickListener(this);
        three = findViewById(R.id.three);
        three.setOnClickListener(this);
        subtract = findViewById(R.id.subtract);
        subtract.setOnClickListener(this);
        zero = findViewById(R.id.zero);
        zero.setOnClickListener(this);
        dot = findViewById(R.id.dot);
        dot.setOnClickListener(this);
        add = findViewById(R.id.addition);
        add.setOnClickListener(this);
        equalButton = findViewById(R.id.equal);
        equalButton.setOnClickListener(this);
        solutionet.setShowSoftInputOnFocus(false);

    }


    /**
     * A method for setting the cursor to the end of every input
     */
    public void replaceCursor(){
        solutionet.setSelection(solutionet.getText().length());
    }


    /**
     * A method for keeping the cursor on the current position after deleting a char from the
     * full argument.
     * @param position: current position of the cursor
     */
    public void keepCursorAtposition(int position){
        try {
            solutionet.setSelection(position-1);
        }catch (Exception e){
            Log.d(Tag, e+"");
        }
    }


    /**
     * handling clicking of all the buttons
     * @param v: clicked view object
     */
    @Override
    public void onClick(View v) {
    Button button = (Button) v;
    buttonText = button.getText().toString();
    displayedArgument = solutionet.getText().toString();

    if(!displayedArgument.contains("e") && !displayedArgument.contains("π")){
        fullArgument = displayedArgument;
    }

  /*  if(buttonText.equals("AC")){

        solutionet.setText("");
        replaceCursor();
        resultet.setText("");
        displayedArgument = fullArgument = null;
        return;

    }
    else if(buttonText.equals("shift")){

        // change buttons layout here
        if(sin.getText().equals("sin") && cos.getText().equals("cos") && tan.getText().equals("tan")) {
            sin.setText("sin⁻¹");
            cos.setText("cos⁻¹");
            tan.setText("tan⁻¹");
        } else{
            sin.setText("sin");
            cos.setText("cos");
            tan.setText("tan");
        }

    }
    else if(buttonText.equals("=")){

        if(fullArgument.contains("sin") || fullArgument.contains("cos") || fullArgument.contains("tan") ||
                fullArgument.contains("ln") || fullArgument.contains("log") || fullArgument.contains("√x") ||
                fullArgument.contains("sin⁻¹") || fullArgument.contains("cos⁻¹") ||
                fullArgument.contains("tan⁻¹") || fullArgument.contains("^") ||
                fullArgument.contains("√")){
            if(!fullArgument.contains("^") && !fullArgument.contains("√")) {
                solutionet.setText(displayedArgument + ")");
                replaceCursor();
            }
            updateResultSingleArg(fullArgument);

        } else if(displayedArgument.equals("π")){
            resultet.setText(fullArgument);
        }else if(displayedArgument.equals("e")){
            resultet.setText(fullArgument);
        }
        else{
            updateResult(fullArgument);
        }
        scrollDown();
        return;
    }
    else if(buttonText.equals("C")){

        int cursorPosition = solutionet.getSelectionStart();

        if(fullArgument.length()!= 0) {
            //fullArgument = fullArgument.substring(0, fullArgument.length()-1 );
            fullArgument = fullArgument.replace(fullArgument.charAt(cursorPosition - 1) + "",
                    "");
            displayedArgument = displayedArgument.replace(displayedArgument.charAt(cursorPosition - 1) + "",
                    "");
            Toast.makeText(this, solutionet.getSelectionStart()+"", Toast.LENGTH_SHORT).show();
            currentCursorPosition = solutionet.getSelectionStart();
            solutionet.setText(displayedArgument);

            Toast.makeText(this, solutionet.getSelectionStart()+"", Toast.LENGTH_SHORT).show();


        }
        else
            return;
    }
    else if(buttonText.equals("sin") || buttonText.equals("cos") || buttonText.equals("tan") ||
            buttonText.equals("ln") || buttonText.equals("log") || buttonText.equals("√x") ||
            buttonText.equals("sin⁻¹") || buttonText.equals("cos⁻¹") || buttonText.equals("tan⁻¹")){
        fullArgument = fullArgument + buttonText + "(";
        displayedArgument = displayedArgument + buttonText + "(";
    }

    else if(buttonText.equals("e") ){

        if(Objects.equals(fullArgument, "")){
            fullArgument = String.valueOf(Math.E);
        } else{
            fullArgument = String.valueOf(Double.parseDouble("0" + fullArgument) * Math.E);
        }
        displayedArgument = displayedArgument + "e";
        solutionet.setText(displayedArgument);
        replaceCursor();

    }

    else if(buttonText.equals("π")){

        if(Objects.equals(fullArgument, "")){
            fullArgument = String.valueOf(Math.PI);
        } else{
            fullArgument = String.valueOf(Double.parseDouble("0" + fullArgument) * Math.PI);
        }

        displayedArgument = displayedArgument + "π";
        solutionet.setText(displayedArgument);
        replaceCursor();

    }

    else if(buttonText.equals("%")){

        fullArgument = fullArgument + "%0";
        displayedArgument = displayedArgument + "%0";
        updateResultSingleArg(fullArgument);

    }
    else if(buttonText.equals("x√y")){

        if(Objects.equals(fullArgument, "")){
            fullArgument = "√";
        } else{
            fullArgument = fullArgument + "√";
        }
        displayedArgument = displayedArgument + "√";
        solutionet.setText(displayedArgument);
        replaceCursor();

    }

    else {
        //if there is an operation being selected for the second time
        //the result of the previous statement will be displayed
        if(operationMap.containsKey(buttonText)){
            calculator.operation = buttonText;
            updateResult(fullArgument);
        }else if(singleOperationMap.containsKey(buttonText)||
                trigOperationMap.containsKey(buttonText)){
            calculator.operation = buttonText;
            updateResultSingleArg(fullArgument);
        }

        fullArgument = fullArgument + buttonText;
        displayedArgument = displayedArgument + buttonText;

    }*/
        buttonChecker(buttonText);

        scrollDown();
        if(displayedArgument.contains("e") || displayedArgument.contains("π")){
            solutionet.setText(displayedArgument);
            replaceCursor();
        } else{
            solutionet.setText(fullArgument);

            if(buttonText.equals("C"))
                keepCursorAtposition(currentCursorPosition);
            else
            replaceCursor();

        }


    }

    /**
     * A method to automate scrolling in the solution edit text area
     */
    public void scrollDown() {
        scroller.smoothScrollTo(0, solutionet.getBottom());

    }

    /**
     * A method for identifying arguments and perform the calculation
     */
    public void updateResult(String fullArgument){

        try {
            infixToPostfix infixElement = new infixToPostfix();
            List<String> postFixString = infixElement.getPostFixString(fullArgument);
            answer = infixElement.calculatePostFix(postFixString);
            resultet.setText(formatAnswer(answer));
        } catch (Exception e){
            Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();

            Log.d(Tag, e + "");
        }
        if(displayedArgument.contains("e") || displayedArgument.contains("π")){
            solutionet.setText(displayedArgument);
        } else{
            solutionet.setText(fullArgument);

        }
        replaceCursor();

    }


    /**
     * A method for handling trigonometric and single argument operations
     */
    public void updateResultSingleArg(String fullArgument){
        if(fullArgument.split("\\(").length == 2){

            String[] number = fullArgument.split("\\(");
            if(Objects.equals(number[0], "sin") || Objects.equals(number[0], "cos") ||
                    Objects.equals(number[0], "tan") || Objects.equals(number[0], "log") ||
                    Objects.equals(number[0], "ln") || Objects.equals(number[0], "√x") ||
                    Objects.equals(number[0], "sin⁻¹") || Objects.equals(number[0], "cos⁻¹") ||
                    Objects.equals(number[0], "tan⁻¹")){
                try {
                    String[] num = number[1].split("\\)");
                    if(num.length == 2){
                        number[1] = num[0];
                        calculator = new Calculator((number[0]), Double.parseDouble(number[1]));
                        answer = Double.parseDouble(calculator.answerMe());
                        fullArgument = answer+num[1];
                        updateResult(fullArgument);
                    } else if (num.length == 1){
                        calculator = new Calculator((number[0]), Double.parseDouble(num[0]));
                        answer = Double.parseDouble(calculator.answerMe());
                    }

                    displayedArgument = displayedArgument + getString(R.string.closing_bracket);
                    solutionet.setText(displayedArgument);
                    replaceCursor();
                    resultet.setText(formatAnswer(answer));
                } catch (Exception e){
                    Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if(fullArgument.split("[%]").length == 2){
            String number[] = fullArgument.split("[%]");
            try {
                calculator = new Calculator("%", Double.parseDouble(number[0]));
                answer = Double.parseDouble(calculator.answerMe());
                fullArgument = formatAnswer(answer);
                resultet.setText(fullArgument);
            } catch (Exception e){
                Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
            }
        }
        else if(fullArgument.split("\\^").length == 2){
            String number[] = fullArgument.split("\\^");
            try {
                calculator = new Calculator(Double.parseDouble(number[0]), Double.parseDouble(number[1]),
                        "^");
                answer = Double.parseDouble(calculator.answerMe());
                resultet.setText(formatAnswer(answer));
            } catch (Exception e){
                Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
            }
        }
        else if(fullArgument.split("[√]").length == 2){
            String number[] = fullArgument.split("[√]");
            try {
                calculator = new Calculator(Double.parseDouble(number[0]), Double.parseDouble(number[1]),
                        "√");
                answer = Double.parseDouble(calculator.answerMe());
                resultet.setText(formatAnswer(answer));
            } catch (Exception e){
                Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     * A method for formatting the answer to be displayed in the result edit
     * text area
     * @param answer
     * @return
     */
    public String formatAnswer(double answer){

        if(answer == (long) answer)
            return String.format(Locale.US,"%f", answer);
        else
            return String.format("%s", answer);
    }


    /**
     * A method for checking a button and perform as per the passed button.
     * @param buttonText
     */
    public void buttonChecker(String buttonText){

        switch (buttonText) {
            case "AC":
                resetDisplay();
                break;

            case "shift":
                shiftButton();
                break;

            case "=":
                if (fullArgument.contains("sin") || fullArgument.contains("cos") ||
                        fullArgument.contains("tan") || fullArgument.contains("ln") ||
                        fullArgument.contains("log") || fullArgument.contains("√x") ||
                        fullArgument.contains("sin⁻¹") || fullArgument.contains("cos⁻¹") ||
                        fullArgument.contains("tan⁻¹") || fullArgument.contains("^") ||
                        fullArgument.contains("√")) {
                        replaceCursor();
                        updateResultSingleArg(fullArgument);
                } else if (displayedArgument.equals("π")) {
                    resultet.setText(fullArgument);
                } else if (displayedArgument.equals("e")) {
                    resultet.setText(fullArgument);
                } else {
                    updateResult(fullArgument);
                }
                scrollDown();
                break;

            case "C":
                int cursorPosition = solutionet.getSelectionStart();

                if (fullArgument.length() != 0) {

                    fullArgument = fullArgument.replace(fullArgument.charAt(cursorPosition - 1)
                                    + "", "");

                    displayedArgument = displayedArgument
                                        .replace(displayedArgument.charAt(cursorPosition - 1)
                                                        + "", "");

                    currentCursorPosition = solutionet.getSelectionStart();
                    solutionet.setText(displayedArgument);

                }
                break;

            case "sin":
            case "cos":
            case "tan":
            case "ln":
            case "log":
            case "√x":
            case "sin⁻¹":
            case "cos⁻¹":
            case "tan⁻¹":
                fullArgument = fullArgument + buttonText + "(";
                displayedArgument = displayedArgument + buttonText + "(";
                break;

            case "e":

                if (Objects.equals(fullArgument, "")) {
                    fullArgument = String.valueOf(Math.E);
                } else {
                    fullArgument = String.valueOf(Double.parseDouble("0" + fullArgument) * Math.E);
                }
                displayedArgument = displayedArgument + "e";
                solutionet.setText(displayedArgument);
                replaceCursor();

                break;
            case "π":

                if (Objects.equals(fullArgument, "")) {
                    fullArgument = String.valueOf(Math.PI);
                } else {
                    fullArgument = String.valueOf(Double.parseDouble("0" + fullArgument) * Math.PI);
                }

                displayedArgument = displayedArgument + "π";
                solutionet.setText(displayedArgument);
                replaceCursor();

                break;
            case "%":

                fullArgument = fullArgument + "%0";
                displayedArgument = displayedArgument + "%0";
                updateResultSingleArg(fullArgument);

                break;
            case "x√y":

                if (Objects.equals(fullArgument, "")) {
                    fullArgument = "√";
                } else {
                    fullArgument = fullArgument + "√";
                }
                displayedArgument = displayedArgument + "√";
                solutionet.setText(displayedArgument);
                replaceCursor();

                break;
            default:
                //if there is an operation being selected for the second time
                //the result of the previous statement will be displayed
                if (operationMap.containsKey(buttonText)) {
                    calculator.operation = buttonText;
                    updateResult(fullArgument);
                } else if (singleOperationMap.containsKey(buttonText) ||
                        trigOperationMap.containsKey(buttonText)) {
                    calculator.operation = buttonText;
                    updateResultSingleArg(fullArgument);
                }

                fullArgument = fullArgument + buttonText;
                displayedArgument = displayedArgument + buttonText;

                break;
        }
    }
    public  void resetDisplay(){
        //resetting the display
        resultet.setText("");
        solutionet.setText("");
        replaceCursor();
        displayedArgument = fullArgument = "";
    }

    public void shiftButton(){
        // change buttons layout here
        if (sin.getText().equals("sin") && cos.getText().equals("cos") && tan.getText().equals("tan")) {
            sin.setText("sin⁻¹");
            cos.setText("cos⁻¹");
            tan.setText("tan⁻¹");
        } else {
            sin.setText("sin");
            cos.setText("cos");
            tan.setText("tan");
        }
    }

}