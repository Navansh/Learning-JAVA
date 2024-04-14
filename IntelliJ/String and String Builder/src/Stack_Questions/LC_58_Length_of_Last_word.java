package Stack_Questions;

import java.util.Stack;

public class LC_58_Length_of_Last_word {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        StringBuilder sbdlr = new StringBuilder();
        Stack<Character> stacker = new Stack<>();

        char[] arr = s.toCharArray();
        boolean spaced = false;

        for (int i = (arr.length - 1); i >= 0 ; i--) {
            //eliminate any spacing that may occur from the last
            //then add the word and then end
            if(arr[i] == ' ') {
                if(!spaced) {
                    continue;
                } else {
                    break;
                }
            } else {
                spaced = true;
                stacker.push(arr[i]);
            }
        }

        int stack_size = stacker.size();
        for (int i = 0; i < stack_size; i++) {
            sbdlr.append(stacker.pop());
        }

        return sbdlr.length();
    }
}
