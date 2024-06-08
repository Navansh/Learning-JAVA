package Stack_Questions;

import java.util.Stack;

public class LC_20_ValidParantheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //insert the entity into the stack and at every insertion, check
        //if the topmost element is the same as the element that we are inserting
        //then skip that element and move to the next element
        //if at the end your stack is empty then, then its true ( valid )
        //otherwise not

        //convert string to charArray
        char[] charArray = s.toCharArray();
        Stack<Character> stacker = new Stack<>();


        for (char ch : charArray) {
            //check if the stack is empty
            if(stacker.isEmpty()) {
                //then directly push the char
                stacker.push(ch);
            } else {
                //if its not the first element, then peek the topmost element and see
                //if they're same
                //if yes then pop that and move forward
                char peeked_char = stacker.peek();
                if(ch == '}' && peeked_char == '{') {
                    stacker.pop();
                } else if (ch == ']' && peeked_char == '[') {
                    stacker.pop();
                } else if (ch == ')' && peeked_char == '(') {
                    stacker.pop();
                } else {
                    stacker.push(ch);
                }
            }
        }

        //in the end if the stack is empty then its valid o/w not
        return stacker.isEmpty();
    }
}
