package Stack_Questions.Pattern_3;

import java.util.Stack;

public class Basic_Calculator {
    public static void main(String[] args) {
        //infix evaluation with brackets
        //https://leetcode.com/problems/basic-calculator/
        String s = "1-(     -2)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        //doesn't work ******************
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;
        //points to the current index of the string we are talking about
        while (i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                //we convert the numeric 0 and 9 to ASCII values and check if the
                //incoming letter's ASCII value falls between it

                int num = 0;
                //now the number can be a 1, 2,3.. digit number
                //so we check the length for it and create our number

                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num*10 + (s.charAt(i) - '0');
                    //(s.charAt(i) - '0') converted char to int
                    //as what this does is ASCII value of 2 - ASCII value of 0
                    //both the ASCII value have a difference of 2
                    //so we get numeric 2 as ans
                    i++;
                }

                operand.push(num);
                i--;
                //as for the above condition to be false, hamne usse pehle waali
                //mein i++ kiya hoga and then check kiya hoga and then it became false
                //toh isko waapis previous state par lekaer aane ke liye we do i--;


            } else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                while (!operator.isEmpty() && operator.peek() != '(' && precedence(operator.peek()) >= precedence(s.charAt(i))) {
                    //if this happens then we can solve the previous operators in the stack
                    char operatorX = operator.pop();

                    int val2 = operand.pop();
                    int val1 = operand.pop();

                    int cal = calc(val1, val2, operatorX);
                    operand.push(cal);

                }
                operator.push(s.charAt(i));
                //add the ith operator to the stack


            } else if (s.charAt(i) == '(') {
                operator.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                //then solve for the whole bracket
                while (!operator.isEmpty() && operator.peek() != '(') {
                    //if this happens then we can solve the previous operators in the stack
                    char operatorX = operator.pop();

                    int val2 = operand.pop();
                    int val1 = operand.pop();

                    int cal = calc(val1, val2, operatorX);
                    operand.push(cal);

                }
                operator.pop();
            } else {
                //according to question there exists some spaces between the
                //operands and the operators so we need to ignore that
                //don't put continue here, why ??? -> gives TLE
                //waise gives correct ans on IntelliJ
//                continue;
            }
            i++;
            //this i++ will take us to the next iteration
        }

        //now after doing all of this you still have something left in your operator stack
        //so solve all those
        while (operator.size() > 0) {
            //no need to worry about precendence here as all of them will of same precedence
            //only, as they're left, otherwise our "if" condition at top would've solved it
            char operatorX = operator.pop();

            int val2 = operand.pop();
            int val1 = operand.pop();

            int cal = calc(val1, val2, operatorX);
            operand.push(cal);
        }

        //the final ans is the last value pushed in the stack
        return operand.pop();
    }

    private static int precedence(Character peek) {
        if(peek == '(') {
            return 2;
        }
        if(peek == '*' || peek == '/') {
            return 1;
        }

        if(peek == '-' || peek == '+') {
            return 0;
        }

        return -1;
    }

    public static int calc(int a, int b, char c) {
        //utility function for various calculations
        if(c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        } else {
            return a/b;
        }
    }
}
