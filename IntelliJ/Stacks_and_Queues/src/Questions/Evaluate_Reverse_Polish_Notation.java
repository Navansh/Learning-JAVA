package Questions;

import java.util.Objects;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        //my approach
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        //whenever
        //add the string to a stack and whenever an operator comes,
        // we resolve the contents of the stack

        Stack<String> tokenStack = new Stack<>();

        boolean operatorCame = false;
        for (int i = 0; i < tokens.length; i++) {

            if(!Objects.equals(tokens[i], "*") && !Objects.equals(tokens[i], "+") && !Objects.equals(tokens[i], "-" ) && !Objects.equals(tokens[i], "/") ) {
                tokenStack.add(tokens[i]);
            } else {
                tokenStack.add(tokens[i]);
                resolveStack(tokenStack);
            }
        }


        //after all this has happened only the answer will be in the stack
        return Integer.parseInt(tokenStack.pop());
    }

    private static void resolveStack(Stack<String> tokenStack) {
        //calculate the result and add it to the stack again
        String operator = tokenStack.pop();
        int b = Integer.parseInt(tokenStack.pop());
        int a = Integer.parseInt(tokenStack.pop());

        if(Objects.equals(operator, "*")) {
            int result = a * b;
            tokenStack.add(Integer.toString(result));
        } else if(Objects.equals(operator, "+")) {
            int result = a + b;
            tokenStack.add(Integer.toString(result));
        } else if(Objects.equals(operator, "-")) {
            int result = a - b;
            tokenStack.add(Integer.toString(result));
        } else {
            int result = a / b;
            tokenStack.add(Integer.toString(result));
        }
    }
}
