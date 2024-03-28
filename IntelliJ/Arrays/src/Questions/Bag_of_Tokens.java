package Questions;

import java.util.Arrays;

public class Bag_of_Tokens {
    public static void main(String[] args) {
//        System.out.println(bagOfTokensScore());
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        //use 2 pointers method,
        //when you have power and want to earn score use the min cost
        //possible from the left side
        //when you want to earn power do it in max way using the right side value

        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (l <= r) {
            if(power >= tokens[l]) {
                //use the power and gain a score
                power -= tokens[l];
                score++;
                l++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                //then use this to take max power by giving 1 score
                power += tokens[r];
                score--;
                r--;
            } else {
                break;
                //if nothing is possible then break
                //Case tokens[] = 100 and power = 50
            }
        }

        return maxScore;
    }
}
