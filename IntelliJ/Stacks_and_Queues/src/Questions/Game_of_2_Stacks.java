package Questions;

import java.util.Arrays;
import java.util.List;

public class Game_of_2_Stacks {
    public static void main(String[] args) {

    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return twoStacks(maxSum, a, b, 0,0) - 1;

    }
    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int moves) {
        if(sum > maxSum) {
            return moves;
        }

        //check is both the arrays has more than 0 element
        if(a.isEmpty() || b.isEmpty()) {
            return moves;
        }


        int ans1 = twoStacks(maxSum, a.subList(1,a.size()), b, sum + a.get(0), moves + 1);
        int ans2 = twoStacks(maxSum, a, b.subList(1,b.size()), sum + b.get(0), moves + 1);

        return Math.max(ans1,ans2);
    }
}
