package Stack_Questions;

import java.util.Stack;

public class LC_1544 {
    public static void main(String[] args) {
        String s = "kkdsFuqUfSDKK";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        //doesn't work***************


        if(s.isEmpty()) {
            return s;
        }
        //we'll be using Stack here

        char[] arr = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        StringBuilder sbldr = new StringBuilder();

        //push the first ele in the stack
        characterStack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(!characterStack.isEmpty()) {
                //peek the previous ele from the stack
                char peeked_char = Character.toUpperCase(characterStack.peek());
                //this will make it capital
                if(peeked_char == arr[i] || characterStack.peek() == Character.toLowerCase(arr[i])) {
                    //means this a bad character pair
                    characterStack.pop();
                } else {
                    characterStack.push(arr[i]);
                }
            } else {
                characterStack.push(arr[i]);
            }

        }

        if(characterStack.isEmpty()) {
            return "";
        }

        //in the end create a new Stack
        int new_stack_size = characterStack.size();
        Stack<Character> stacker = new Stack<>();

        for (int i = 0; i < new_stack_size; i++) {
            stacker.push(characterStack.pop());
        }

        for (int i = 0; i < new_stack_size; i++) {
            sbldr.append(stacker.pop());
        }

        return sbldr.toString();
    }

    public String makeGoodCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                //as difference between a capital letter and a small letter and vice versa
                //is either -32 or 32
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
