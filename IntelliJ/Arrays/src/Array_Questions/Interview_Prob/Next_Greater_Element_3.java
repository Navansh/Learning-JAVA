package Array_Questions.Interview_Prob;

import java.util.Arrays;

public class Next_Greater_Element_3 {
    public static void main(String[] args) {
        nextGreaterElement(2147483476);
        nextGreaterElementOptimized(12222333);

        //ans should be 2147483647 12222333

    }
    public static int nextGreaterElementOptimized(int n) {
        //create the string out of it
        //TC : O(N) solution, as we are using reversing here instead of sorting

        String num = Integer.toString(n);
        //convert num to character array
        char[] numArray = num.toCharArray();
        int[] numbers = new int[numArray.length];

        //now we start with the last index of the array and find the index closest
        //to that which has the number smaller than that index ( current )
        //form a integer array using the character array

        for(int i = 0; i < numArray.length; i++) {
            numbers[i] = Character.getNumericValue(numArray[i]);
        }

        int possible_index = -1;

        for (int i = numbers.length - 2; i >= 0; i--) {
            //we are starting from -2 as we want to go towards the right of it,
            //and for the last element, the right doesn't exist anyways
            //check if the right index element is bigger than current index element
            //then we can possibly swap between them
            if(numbers[i] < numbers[i + 1]) {
                //store the ith index
                //checking with the adjacent indexes only
                //bcz, we want to get to the just bigger, if we increase our distance
                //between indices that we won't get just bigger element
                possible_index = i;
                break;
            }
        }

        if(possible_index == -1) {
            //then we never found a possible index and we already have the maximum
            //number possible with the current digits
            return -1;
        }

        int val = numbers[possible_index];
        int smallest_val = possible_index + 1;
        //we've found an possible smallest value index, this we assume
        //but bcz we've only checked with adjacent index, we need to verify
        //by checking, from going to right side of this possible index to arr.length -1
        //that the index we have is the smallest one only and there
        //exists no other bigger than i and smaller than i + 1 ( our current )

        for (int i = possible_index + 1; i < numbers.length; i++) {
            if(numbers[i] > val && numbers[smallest_val] >= numbers[i]) {
                //numbers[smallest_val] >= numbers[i] : here equals is imp, cz even if we have 2 equal
                //nos, that are same but on diff place values, then we want to pick the number that is on the
                //least place value, so to get the just bigger number, so that when we eventually sort the
                //nos between the indices we get the just bigger number
                smallest_val = i;
            }
        }

        //now swap the two
        int temp = numbers[possible_index];
        numbers[possible_index] = numbers[smallest_val];
        numbers[smallest_val] = temp;

        //now do reversal in the array, from
        //this is the optimizes part
//        System.out.println("Number array in between" + Arrays.toString(numbers));
//        Arrays.sort(numbers, possible_index + 1, numbers.length);
        reverseArray(numbers, possible_index + 1, numbers.length - 1);
//        System.out.println("Number array in after" + Arrays.toString(numbers));


        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numArray.length; i++) {
            ans.append(numbers[i]);
        }
//        System.out.println(ans);
        long ansLong = Long.parseLong(ans.toString());
        System.out.println(ansLong);
        if(ansLong > Integer.MAX_VALUE) {
            return -1;
        }

//        System.out.println(Integer.MAX_VALUE);
        return (int) ansLong;

    }

    private static void reverseArray(int[] numbers, int start, int end) {
        //reverse the array
        while(start < end) {
            //reverse start and end
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static int nextGreaterElement(int n) {
        //create the string out of it
        //TC : O() solution

        String num = Integer.toString(n);
        //convert num to character array
        char[] numArray = num.toCharArray();
        int[] numbers = new int[numArray.length];

        //now we start with the last index of the array and find the index closest
        //to that which has the number smaller than that index ( current )
        //form a integer array using the character array

        for(int i = 0; i < numArray.length; i++) {
            numbers[i] = Character.getNumericValue(numArray[i]);
        }

        int possible_index = -1;

        for (int i = numbers.length - 2; i >= 0; i--) {
            //we are starting from -2 as we want to go towards the right of it,
            //and for the last element, the right doesn't exist anyways
            //check if the right index element is bigger than current index element
            //then we can possibly swap between them
            if(numbers[i] < numbers[i + 1]) {
                //store the ith index
                //checking with the adjacent indexes only
                //bcz, we want to get to the just bigger, if we increase our distance
                //between indices that we won't get just bigger element
                possible_index = i;
                break;
            }
        }

        if(possible_index == -1) {
            //then we never found a possible index and we already have the maximum
            //number possible with the current digits
            return -1;
        }

        int val = numbers[possible_index];
        int smallest_val = possible_index + 1;
        //we've found an possible smallest value index, this we assume
        //but bcz we've only checked with adjacent index, we need to verify
        //by checking, from going to right side of this possible index to arr.length -1
        //that the index we have is the smallest one only and there
        //exists no other bigger than i and smaller than i + 1 ( our current )

        for (int i = possible_index + 1; i < numbers.length; i++) {
            if(numbers[i] > val && numbers[smallest_val] >= numbers[i]) {
                smallest_val = i;
            }
        }

        //now swap the two
        int temp = numbers[possible_index];
        numbers[possible_index] = numbers[smallest_val];
        numbers[smallest_val] = temp;

        //now do sorting in the array, from
//        System.out.println("Number array in between" + Arrays.toString(numbers));
        Arrays.sort(numbers, possible_index + 1, numbers.length);
//        System.out.println("Number array in after" + Arrays.toString(numbers));


        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numArray.length; i++) {
            ans.append(numbers[i]);
        }
//        System.out.println(ans);
        long ansLong = Long.parseLong(ans.toString());
        System.out.println(ansLong);
        if(ansLong > Integer.MAX_VALUE) {
            return -1;
        }

//        System.out.println(Integer.MAX_VALUE);
        return (int) ansLong;

    }


}
