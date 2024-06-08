import java.util.Arrays;

public class Max_Odd_Binary_Number {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
    }
    public static String maximumOddBinaryNumber(String s) {
        //get the
        char[] arr = s.toCharArray();
        int[] ans = new int[arr.length];

        boolean set = false;
        int index = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            //check if it is 1
            if(arr[i] == '1' && !set) {
                //means this is the first
                ans[arr.length - 1] = 1;
                set = true;
                continue;
            }

            if(arr[i] == '1') {
                ans[index] = 1;
                index++;
            }
        }

        //set the char array as ans
        for (int i = 0; i < ans.length; i++) {
            str.append(ans[i]);
        }

        return str.toString();
    }
}
