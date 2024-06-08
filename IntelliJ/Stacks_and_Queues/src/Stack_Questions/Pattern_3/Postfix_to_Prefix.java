package Stack_Questions.Pattern_3;

import java.util.Stack;

public class Postfix_to_Prefix {
    public static void main(String[] args) {
        String s = "ABC/-AK/L-*";
        System.out.println(postToPre(s));
    }

    static String postToPre(String post_exp) {
        Stack<String> operand = new Stack<>();

        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);
            if(isOperator(ch)){
                String val2 = operand.pop();
                String val1 = operand.pop();
                String ans = ch + val1 + val2;
                operand.push(ans);
            } else {
                operand.push(ch +"");
            }
        }

        return operand.pop();
    }

    private static boolean isOperator(char ch) {
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        } else {
            return false;
        }
    }


}
