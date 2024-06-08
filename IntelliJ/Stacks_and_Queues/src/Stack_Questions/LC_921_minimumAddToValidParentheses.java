package Stack_Questions;

import java.util.Stack;

public class LC_921_minimumAddToValidParentheses {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid(")()"));
    }

    public static int minAddToMakeValid(String s) {
        //this is correct but slow

        char[] charArray = s.toCharArray();
        Stack<Character> stacker = new Stack<>();
        int fix = 0;

        for (char ch : charArray) {
            //check if the stack is empty
            if(stacker.isEmpty()) {
                //then directly push the char
                stacker.push(ch);
                fix++;
            } else {
                //if its not the first element, then peek the topmost element and see
                //if they're same
                //if yes then pop that and move forward
                char peeked_char = stacker.peek();
                if(ch == '}' && peeked_char == '{') {
                    stacker.pop();
                    fix--;
                } else if (ch == ']' && peeked_char == '[') {
                    stacker.pop();
                    fix--;
                } else if (ch == ')' && peeked_char == '(') {
                    stacker.pop();
                    fix--;
                } else {
                    fix++;
                    stacker.push(ch);

                }
            }
        }

        //in the end if the stack is empty then its valid o/w not
        return fix;
    }



}
