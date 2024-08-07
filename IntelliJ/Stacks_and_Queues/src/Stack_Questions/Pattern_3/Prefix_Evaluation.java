package Stack_Questions.Pattern_3;

import java.util.Stack;

public class Prefix_Evaluation {
    public static void main(String[] args) {
        String exp = "+-+2*346+2*32";
        System.out.println(evalPrefix(exp));
    }

    public static int evalPrefix(String exp) {
        //do the reverse of the string and you'll get operators first and evaluate
        //it iteratively
        //make closing bracket an opening one and opening an closing one
        StringBuilder reversedExp = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            reversedExp.append(exp.charAt(i));
        }

        //now its converted to postfix and we can evaluate just by iterating
        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < reversedExp.length(); i++) {
            char ch = reversedExp.charAt(i);
            if(isOperator(ch)) {
                int val1 = operand.pop();
                //as we did reverse, so the first pop will give val1
                int val2 = operand.pop();
                int ans = calc(val1, val2,ch);
                operand.push(ans);
            } else {
                operand.push(ch -'0');
            }
        }

        return operand.pop();

    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
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
