package Stack_Questions.Pattern_3;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Stack;

public class Postfix_Evaluation {
    public static void main(String[] args) {
        //https://leetcode.com/problems/evaluate-reverse-polish-notation/
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if(isOperator(tokens[i])) {
                int val2 = operand.pop();
                int val1 = operand.pop();
                int ans = calc(val1, val2,tokens[i].charAt(0));
                operand.push(ans);
            } else {
                operand.push(Integer.parseInt(tokens[i]));
            }
        }

        return operand.pop();
    }

    private static boolean isOperator(String token) {
        char ch = token.charAt(0);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            //either it will be an operator or a negative number
            if(token.length() > 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
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
