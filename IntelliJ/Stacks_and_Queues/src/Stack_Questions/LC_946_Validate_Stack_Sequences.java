package Stack_Questions;

import java.util.Stack;

public class LC_946_Validate_Stack_Sequences {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequencesoptimized(pushed, popped));
    }

    public static boolean validateStackSequencesoptimized(int[] pushed, int[] popped) {
        //use pushed array as stack

        int pushed_pointer = 0;
        int popped_pointer = 0; //pointer to popped array

        for(int val : pushed) {
            pushed[pushed_pointer++] = val;
            //set the val to the pushed array
            while(pushed_pointer > 0 && pushed[pushed_pointer - 1] == popped[popped_pointer]){ // pushed[i - 1] values equal to popped[j];
                pushed_pointer--;
                popped_pointer++;
            }
        }
        return pushed_pointer == 0; // Since pushed is a permutation of popped so at the end we are supposed to be left with an empty stack

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stacker = new Stack<>();
        int counter = 0;
        for (int i = 0; i < pushed.length; i++) {
            //push this to the stack
            stacker.push(pushed[i]);
            while (!stacker.isEmpty() && stacker.peek() == popped[counter]) {
                //pop from stacker
                //means this combination is possible
                stacker.pop();
                counter++;
            }
        }

        return stacker.isEmpty();
    }
}
