package Questions_and_Concepts_of_Recursions;

import java.util.ArrayList;

public class Leetcode_1155_Dice_Rolls_With_Target_Sum
{
    public static void main(String[] args) {
//        dice_roll("",4);
        System.out.println(dice_rollArray("",4));
    }
    static void dice_roll(String processed,int target){
        if (target==0){
            System.out.println(processed);
            return;
        }
        for (int i = 1; i<=6 && i <= target ; i++) {
            dice_roll(processed+i,target - i);
        }
    }
    static ArrayList<String> dice_rollArray(String processed, int target){
        if (target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i<=6 && i <= target ; i++) {
            ans.addAll(dice_rollArray(processed+i,target - i));
        }
        return ans;
    }
}
