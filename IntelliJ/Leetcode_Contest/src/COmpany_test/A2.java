package COmpany_test;

import java.util.HashMap;
import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int minOperations = minOperationsToLexLargest(input);
        System.out.println(minOperations);
    }

    public static int minOperationsToLexLargest(String s) {
        int transitions = 0;

        // Count the transitions from '1' to '0'
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                transitions++;
            }
        }

        return transitions;
    }
}
