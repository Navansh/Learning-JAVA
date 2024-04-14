package Stack_Questions;

import java.util.Stack;

public class GFG_PairwiseConsecutiveElements {
    public static void main(String[] args) {
        Stack<Integer> stacko = new Stack<>();
        stacko.push(19);
        stacko.push(21);
//        stacko.push(3);
//        stacko.push(4);
//        stacko.push(5);
//        stacko.push(6);

        System.out.println(pairWiseConsecutive(stacko));
    }

    public static boolean pairWiseConsecutive(Stack<Integer> st)
    {
        // Your code here
        //everytime while pushing check the if its consecutive with the prev element
        //in the stack

        int[] arr = new int[1000];
        int index = 0;
        while(!st.isEmpty()) {
            arr[index] = st.pop();
            index++;
        }

        //now all the elements are there in the array
        //now check if they're consecutive or not

        int difference = arr[1] - arr[0];

        if(difference != 1) {
            if(difference != -1) {
                return false;
            }
        }

        for(int i = 1; i < index ; i++) {
            if(arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }

        return true;

    }
}
