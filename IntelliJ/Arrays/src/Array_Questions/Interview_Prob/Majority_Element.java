package Array_Questions.Interview_Prob;

import java.util.HashMap;
import java.util.Random;

public class Majority_Element {
    public static void main(String[] args) {

    }

    public int majorityElementOptimized(int[] arr) {
        int val = arr[0];
        //this val will contain our majority element
        
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            //we are starting from 1st index because we've already substituted
            //0th index element on val, and from here we start checking for similar
            //elements

            if(arr[i] == val) {
                count++;
            } else {
                //now they're different so we can cancel them
                if(count == 0) {
                    //n one left to cancel, so
                    val = arr[i];
                    count = 1;
                    //reset the count, so to indicate that the (available) freq of this element
                    //which is 1 currently
                } else {
                    count--;
                }
            }
        }

        return val;

        
    }
    public int majorityElement(int[] arr) {
        //slower and not so optimzed optimized solution
        HashMap<Integer, Integer> hx = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(hx.containsKey(arr[i])) {
                int temp = hx.get(arr[i]);
                hx.put(arr[i], temp + 1);
            } else {
                hx.put(arr[i], 1);
            }
        }

        //now check which element has frequency greater than n / 2
        int req_freq = arr.length / 2;

        for(int i = 0; i < arr.length; i++) {
            if(hx.get(arr[i]) > req_freq) {
                return arr[i];
            }
        }

        return -1;
    }

    public int majorityElementOp(int[] arr) {
        //if an element occurs more than half times
        //then if we randomly select 20 elements and look
        //if they're are the majority element then
        //we can find it in 20 oterations only
        //and without any additional space

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randIndex = random.nextInt(0, arr.length);
            if(checkIfMajority(randIndex, arr)) {
                return arr[randIndex];
            }
        }

        return -1;
    }

    private boolean checkIfMajority(int randIndex, int[] arr) {
        //https://x.com/Priyansh_31Dec/status/1806985932630798506?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Etweet
        int num = arr[randIndex];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                count++;
            }
        }

        if(count > arr.length / 2) {
            return true;
        }

        return false;
    }
}
