package Questions;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };

        int b = -3;

        System.out.println(Arrays.toString(twoSum(arr,b)));
    }
    public static int[] twoSum(final int[] arr, int B) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
//        int[] ans = new int[2];
        int[][] ans = new int[10000][2];
        int index = 0;


        for (int i = 0; i < arr.length; i++) {
            if(hmap.containsKey(arr[i])) {
                int val = hmap.get(arr[i]);
                hmap.put(arr[i], val + 1 );
            } else {
                hmap.put(arr[i], 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = B - a;

            if(a!=b && hmap.containsKey(b)) {
                //one answer found
                //get the index of a & b
                int indexA = i;
                int indexB = findIndex(arr,b);

                if(indexA > indexB) {
                    ans[index][0] = indexB + 1;
                    ans[index][1] = indexA + 1;
                    index++;

                }

                ans[index][0] = indexA + 1;
                ans[index][1] = indexB + 1;
                index++;

            }

            if(a == b && hmap.get(b) > 1) {
                int indexA = i;
                int indexB = findDuplicateIndex(arr, b, i);
                if(indexA > indexB) {
                    ans[index][0] = indexB + 1;
                    ans[index][1] = indexA + 1;
                    index++;
                }

                ans[index][0] = indexA + 1;
                ans[index][1] = indexB + 1;
                index++;
            }
        }

        //now we have a 2d Array filled of answers and we need to return the lowest
        //index2 and index 1 combination
        int ans_row = 0;
        int ans_col = 0;
        //check whose index is smaller
        for (int i = 0; i < ans.length; i++) {
                if(ans[i][1] < ans_col) {
                    ans_col = ans[i][1];
                }
                if(ans[i][0] > ans_row) {
                    ans_row = ans[i][0];
                }
        }

        return new int[2];
    }



    private static int findIndex(int[] arr, int b) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == b) {
                return i;
            }

        }

        return -1;
    }

    private static int findDuplicateIndex(int[] arr, int b, int dupli) {
        for (int i = 0; i < arr.length; i++) {
            if(i!= dupli && arr[i] == b) {
                return i;
            }

        }

        return -1;
    }

}
