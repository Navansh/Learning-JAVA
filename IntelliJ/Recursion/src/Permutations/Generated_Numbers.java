package Permutations;

import java.util.HashMap;
import java.util.HashSet;

public class Generated_Numbers {
    public static void main(String[] args) {
        System.out.println(generateNumbersDP(10,2,5));
    }

    public static int generateNumbersDP(int total, int A, int B) {
        boolean[] arr = new boolean[total + 1];

        arr[total] = true;

        for (int i = arr.length - 1;  i >= 0 ; i--) {
            if(!arr[i]) {
                continue;
            }

            int x = i - A;
            int y = i - B;

            if(x > 0) {
                arr[x] = true;
            }

            if(y > 0) {
                arr[y] = true;
            }

        }


        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]) {
                count++;
            }
        }

        return count;
    }

    public static int generateNumbers(int total, int A, int B) {
        int ans = 0;
        HashSet<Integer> checker = new HashSet<>();

        ans = generateHelper(total, A, B, 1, checker);
        return -1;
    }

    public static int generateHelper(int total, int A, int B, int count, HashSet<Integer> checker) {
        if(total <= 0) {
            return count;
        }

        int ans1 = 0;
        int ans2 = 0;

        if(checker.contains(total)) {
            generateHelper(total - A, A, B, count + 1, checker);
            generateHelper(total - B, A, B, count + 1, checker);
        } else {
            generateHelper(total - A, A, B, count, checker);
            generateHelper(total - B, A, B, count, checker);
        }

        return -1;

    }
}
