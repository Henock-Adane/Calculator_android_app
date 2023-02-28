package com.example.calculator;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import java.net.ContentHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * A Class for converting infix expression to postfix expression
 */
public class infixToPostfix {
    String Tag = "log1";

 private int getPreference(char c){
     if(c=='+'|| c=='-') return 1;
     else if(c=='*' || c=='/') return 2;
     else return -1;
 }

    protected List<String> getPostFixString(String s){
        //Creating the stack
        Stack<Character> stack = new Stack<>();

        //
        List<String> postFixList = new ArrayList<>();

        //A boolean used for
        boolean flag = false;

        //
        for(int i=0;i<s.length();i++){
            char word = s.charAt(i);
            if(word==' '){
                continue;
            }

            if(word=='('){
                stack.push(word);
                flag = false;
            }

            else if(word==')'){
                flag = false;
                while(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                        break;
                    }else{
                        postFixList.add(stack.pop()+"");
                    }
                }
            }

            else if(word=='+' || word=='-' || word=='*' || word=='/'){
                flag = false;
                if(stack.isEmpty()){
                    stack.push(word);
                }
                else{
                    while(!stack.isEmpty() && getPreference(stack.peek())>=getPreference(word)){
                        postFixList.add(stack.pop()+"");
                    }
                    stack.push(word);
                }
            }

            else{
                if(flag){
                    String lastNumber = postFixList.get(postFixList.size()-1);
                    lastNumber+=word;
                    postFixList.set(postFixList.size()-1, lastNumber);
                }else
                    postFixList.add(word+"");
                flag = true;
            }
        }
        while(!stack.isEmpty()){
            postFixList.add(stack.pop()+"");
        }
        return postFixList;
    }
    protected double calculatePostFix(List<String> postFixList){
     double number1=0;
     double number2=0;
        Stack<Double> stack = new Stack<>();

        for(int i=0;i<postFixList.size();i++){
            String word = postFixList.get(i);


            if(word.length()==1 && (word.charAt(0)=='+'||word.charAt(0)=='-'||word.charAt(0)=='*'||word.charAt(0)=='/')){
                if(!stack.isEmpty()) {
                    number2 = stack.pop();
                    number1 = stack.pop();
                }
                if(word.charAt(0)=='+'){
                    double number = number1+number2;
                    stack.push(number);
                }else if(word.charAt(0)=='-'){
                    double number = number1-number2;
                    stack.push(number);
                }else if(word.charAt(0)=='*'){
                    double number = number1*number2;
                    stack.push(number);
                }else{
                    double number = number1/number2;
                    stack.push(number);
                }
            }
            else{
                double number = Double.parseDouble(word);
                stack.push(number);
            }
        }
        return stack.peek();
    }






}


