package Stack_Questions;

import java.util.Stack;

public class LC_1541_minInsertions {
    public static void main(String[] args) {
        String s = "(()))";
        System.out.println(minInsertioons(s));
    }

    public static int minInsertions(String s) {
        int consec_two = 0;
        int one = 0;

        char[] paren_array = s.toCharArray();
        int i = 1;
       while( i < paren_array.length ) {
            if(paren_array[i-1] == '(') {
                one++;
                i++;
                continue;
            }
            if(paren_array[i-1] == paren_array[i]) {
                consec_two++;
                i = i + 2;
            }
        }

        System.out.println("The dance is " + one + consec_two);
        return consec_two;
    }

    public static int minInsertioons(String s) {

        //misses some edge cases
        Stack<Character> stacker = new Stack<Character>();
        char[] paren_array = s.toCharArray();

        int i = 0;
        int single_holder = 0;
        int double_holder = 0;
        char peeked_ele = '0';
        int balanced =0;

        while(i < paren_array.length) {
            if(!stacker.isEmpty()) {
                peeked_ele = stacker.peek();
            }
            if(paren_array[i] == '(') {
                stacker.push(paren_array[i]);
                single_holder +=2;
            }

            if(paren_array[i] == ')') {
                if(!stacker.isEmpty() && peeked_ele == ')') {
                    stacker.pop();
                    double_holder--;
                    if(stacker.isEmpty()) {
                        double_holder++;
                    }
                    if(!stacker.isEmpty()) {
                        stacker.pop();
                        single_holder-=2;
                    }

                } else {
                    stacker.push(paren_array[i]);
                    double_holder++;
                }
            }
            i++;
        }

        int minInsertions = 2*single_holder - double_holder;
        System.out.println("These are the values of " + single_holder + double_holder);
        return -1;
    }

}
