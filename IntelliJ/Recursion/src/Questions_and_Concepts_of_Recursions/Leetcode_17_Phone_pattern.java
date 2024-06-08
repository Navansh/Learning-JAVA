package Questions_and_Concepts_of_Recursions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_17_Phone_pattern {
    public static void main(String[] args) {
//        Pad("","99");
        List<String> ans = PadReturnLeetcode("","99");
        System.out.println(ans);
    }

    static void Pad(String processed, String unprocessed){
        if (unprocessed.isEmpty())
        {
            System.out.println(processed);
            return;
        }

        int digit = unprocessed.charAt(0) -'0';
        //this will convert '2' to 2

        for (int i = (digit - 1)*3 ; i < (digit*3); i++) {
            char ch = (char)('a' + i);
            //as we are doing wrt to 'a', and adding the range to it
            Pad(processed+ch,unprocessed.substring(1));
        }

    }

    static ArrayList<String> PadReturn(String processed, String unprocessed){
        if (unprocessed.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int digit = unprocessed.charAt(0) -'0';
        //this will convert '2' to 2
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1)*3 ; i < (digit*3); i++) {
            char ch = (char)('a' + i);
            ans.addAll(PadReturn(processed+ch,unprocessed.substring(1)));
        }

        return ans;
    }
    static List<String> PadReturnLeetcode(String processed, String unprocessed){
        if (unprocessed.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int digit = unprocessed.charAt(0) -'1';
        //this will convert '2' to 2
        ArrayList<String> ans = new ArrayList<>();
        if (digit==6){
            for (int i = (digit - 1)*3 ; i < (digit*3) + 1; i++) {
                char ch = (char)('a' + i);
                ans.addAll(PadReturnLeetcode(processed+ch,unprocessed.substring(1)));
            }
        } else if (digit == 7) {
            for (int i = (digit - 1)*3 + 1 ; i < (digit*3) + 1; i++) {
                char ch = (char)('a' + i);
                ans.addAll(PadReturnLeetcode(processed+ch,unprocessed.substring(1)));
            }
        } else if (digit==8) {
            for (int i = (digit - 1)*3 + 1 ; i < (digit*3) + 2; i++) {
                char ch = (char)('a' + i);
                ans.addAll(PadReturnLeetcode(processed+ch,unprocessed.substring(1)));
            }
        }
        else
            for (int i = (digit - 1)*3 ; i < (digit*3); i++) {
                char ch = (char)('a' + i);
                ans.addAll(PadReturnLeetcode(processed+ch,unprocessed.substring(1)));
            }

        return ans;
    }
}
