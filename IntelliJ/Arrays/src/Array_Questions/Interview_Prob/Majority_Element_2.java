package Array_Questions.Interview_Prob;

import java.util.*;

public class Majority_Element_2 {
    public static void main(String[] args) {

    }

    private List<Integer> majorityElementOptimized(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        int val1 = arr[0];
        int count1 = 1;
        int val2 = Integer.MIN_VALUE;
        //can take any max or min, don't take any random int, as it may occur in the array
        //and disturb the ans
        //Ex : arr = -1, -1, -1 and we took val2 = -1
        int count2 = 0;
        //because we haven't found the second distinct element yet

        for (int i = 1; i < arr.length; i++) {
            //starting from 1, as we have manually put in val1 as arr[0], otherwise
            //we would've started from i = 0;

            if(arr[i] == val1) {
                count1++;
            } else if(arr[i] == val2) {
                count2++;
            } else if (count1 == 0) {
                //yes, we've found a different element, but we don't have val1, actually
                //present. meaning its freq is 0
                //so
                val1 = arr[i];
                count1 = 1;
            } else if (count2 == 0) {
                //similarly
                val2 = arr[i];
                count2 = 1;
            } else {
                //now we are at the case, where we've found three distinct triplets
                //namely val1, val2, and arr[i], hence we cancel them and reduce the
                //count of val1 and val2

                count1--;
                count2--;
            }
        }

        //now check for the freq of val1 and val2
        //count the occurance of val1;
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val1) {
                count1++;
            }
            if(arr[i] == val2) {
                count2++;
            }
        }

        if(count1 > arr.length/3) {
            ans.add(val1);
        }

        if(count2 > arr.length/3) {
            ans.add(val2);
        }

        return ans;


    }

    private List<Integer> majorityElement(int[] arr) {
        //this is the unoptimized idea
        HashMap<Integer, Integer> hx = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            if(hx.containsKey(arr[i])) {
                int temp = hx.get(arr[i]);
                hx.put(arr[i], temp + 1);
            } else {
                hx.put(arr[i], 1);
            }
        }

        //now check which element has frequency greater than n / 2
        int req_freq = arr.length / 3;

        for(int i = 0; i < arr.length; i++) {
            if(hx.get(arr[i]) > req_freq) {
                hs.add(arr[i]);
            }
        }

        return hs.stream().toList();
    }


}
