package Stack_Questions.Pattern_3;

import java.util.Stack;

public class Prefix_to_Infix {
    public static void main(String[] args) {
        String exp = "+-+2*346+2*32";
        //we don't need to take care of precedence in these conversions as while
        //converting to prefix, its been already taken care of
        System.out.println(prefixToInfix(exp));
    }

    public static String prefixToInfix(String exp) {
        //do the reverse of the string and you'll get operators first and evaluate
        //it iteratively
        //make closing bracket an opening one and opening an closing one
        StringBuilder reversedExp = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            reversedExp.append(exp.charAt(i));
        }

        //now its converted to postfix and we can evaluate just by iterating
        Stack<String> operand = new Stack<>();

        for (int i = 0; i < reversedExp.length(); i++) {
            char ch = reversedExp.charAt(i);
            if(isOperator(ch)) {
                String val1 = operand.pop();
                //as we did reverse, so the first pop will give val1
                String val2 = operand.pop();
                String ans = val1 + ch + val2;
                operand.push(ans);
            } else {
                operand.push(ch +"");
            }
        }

        return operand.pop();

    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

}
