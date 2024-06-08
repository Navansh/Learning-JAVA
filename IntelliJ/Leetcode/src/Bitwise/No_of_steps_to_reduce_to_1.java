package Bitwise;

public class No_of_steps_to_reduce_to_1 {
    public static void main(String[] args) {

    }

    public int numSteps(String s) {
        int steps = 0;
        while (s.length() > 1) {
            //as if length is 1, then it is just the number 1, if we did all
            //our steps correctly, as the question says after doing
            //all the steps correctly, we'll finally reach 1
            if(s.charAt(s.length() - 1) == '0') {
                //meaning its an even number
                //so just do a right shift on the entire number
                s = s.substring(0, s.length() - 1);
                //this will remove the last character from the string
                steps++;
                continue;
            }
        }

        return -1;
    }
}
