package Stack_Questions;

import java.util.Stack;

public class Remove_K_Digits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1234567890",9));
    }

    public static String removeKdigitsCorrect(String num, int k) {
        char[] arr = num.toCharArray();
        Stack<Character> stacker = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (stacker.size() > 0 && stacker.peek() > arr[i] && k > 0) {
                stacker.pop();
                k--;
            }

            if(stacker.size() > 0 || arr[i] != '0') {
                stacker.push(arr[i]);
                //otherwise we'll be filling it up with zero, in starting
                //to avoid the case when we have preceeding zeroes
            }
        }

        while (!stacker.isEmpty() && k > 0) {
            stacker.pop();
            k--;
        }

        char[] arx = new char[stacker.size()];
        int i = arx.length - 1;
        while (!stacker.isEmpty()) {
            arx[i] = stacker.pop();
            i--;
        }

        if(arx.length == 0) {
            return "0";
        }

        String str = new String(arx);

        return str;

    }

    public static String removeKdigits(String num, int k) {
        //fails some test cases and a lot of ifs used
        if(num.length() <= k) {
            return "0";
        }
        int total_doable = k;
        char[] arr = num.toCharArray();
        Stack<Character> stacker = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stacker.isEmpty() && total_doable > 0) {
                int current_ele = arr[i] - '0';
                int peeked_ele = stacker.peek() - '0';

                if(current_ele < peeked_ele ) {
                    //then pop that element that is causing the pattern to break
                    stacker.pop();
                    total_doable--;
                } else {
                    break;
                }

            }
            stacker.push(arr[i]);
        }

        //now the elements left in the stack must be in increasing order

        //now even after all of this the total_doable is still > 0,
        //meaning either our resultant string was in increasing order
        //or became increasing order then chop off that no of ele from the top of stack
        while (total_doable > 0) {
            stacker.pop();
            total_doable--;
        }

        char[] arx = new char[stacker.size()];
        int i = arx.length - 1;
        while (!stacker.isEmpty()) {
            arx[i] = stacker.pop();
            i--;
        }

        StringBuilder str = new StringBuilder();
        boolean first_numeric = false;

        for (int j = 0; j < arx.length; j++) {
            if(arx[j] =='0' && arx.length == 1) {
                return "0";
            }
            if(arx[j] == '0' && !first_numeric) {
                continue;
            } else {
                first_numeric = true;
            }
            str.append(arx[j]);
        }

        //this has been optimized in the above code

        //remove starting zeroes from the string :

        return str.toString();


    }
}
