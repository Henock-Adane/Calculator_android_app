package com.example.calculator;

import static com.example.calculator.Calculator.operationMap;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 *Main class
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    String fullArgument;

    /**
     * Calculator object for accessing the calculating operationdccccccv
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
        solutionet.setEnabled(false);
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
    }

    /**
     * handling clicking of all the buttons
     * @param v
     */
    @Override
    public void onClick(View v) {
    Button button = (Button) v;
    String buttonText = button.getText().toString();
    fullArgument = solutionet.getText().toString();

    if(buttonText.equals("AC")){
        solutionet.setText("");
        resultet.setText("0");
        return;
    } else if(buttonText.equals("shift")){
        // change buttons layout here
    } else if(buttonText.equals("=")){
        updateResult();
        if(!resultet.getText().equals("0")){
            solutionet.setText(resultet.getText());
            scrollDown();
        }
        return;
    } else if(buttonText.equals("C")){
        updateResult();
        if(fullArgument.length()!= 0)
          fullArgument = fullArgument.substring(0, fullArgument.length()-1 );
        else
            return;
    } else {
        //if there is an operation being selected for the second time
        //the result of the previous statement will be displayed
        if(operationMap.containsKey(buttonText)){
            calculator.operation = buttonText;
            updateResult();
        }
        fullArgument = fullArgument + buttonText;

    }

        /*if(fullArgument.length() >= 15){
            scrollDown();
            solutionet.setText(fullArgument);
        } else
            solutionet.setText(fullArgument);*/
        scrollDown();
        solutionet.setText(fullArgument);
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
    public void updateResult(){

        Toast.makeText(this, "argument= "+ fullArgument, Toast.LENGTH_SHORT).show();

    if(fullArgument.split("\\*").length == 2){

        String number[] = fullArgument.split("\\*");
        try {
            calculator = new Calculator(Double.parseDouble(number[0]), Double.parseDouble(number[1]),
                    "*");
            answer = Double.parseDouble(calculator.answerMe());
            resultet.setText(formatAnswer(answer));

        } catch (Exception e){
            Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
        }

    }

    else if(fullArgument.split("/").length == 2){

        String number[] = fullArgument.split("/");
        try {
            calculator = new Calculator(Double.parseDouble(number[0]), Double.parseDouble(number[1]),
                    "/");
            answer = Double.parseDouble(calculator.answerMe());
            resultet.setText(formatAnswer(answer));

        } catch (Exception e){
            Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
        }
    }

    else if(fullArgument.split("-").length == 2){

        String number[] = fullArgument.split("-");
        try {
            calculator = new Calculator(Double.parseDouble(number[0]), Double.parseDouble(number[1]),
                    "-");
            answer = Double.parseDouble(calculator.answerMe());
            resultet.setText(formatAnswer(answer));
        } catch (Exception e){
            Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
        }
    }

    else if(fullArgument.split("\\+").length == 2){

        String number[] = fullArgument.split("\\+");
        try {
            calculator = new Calculator(Double.parseDouble(number[0]), Double.parseDouble(number[1]),
                    "+");
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
}