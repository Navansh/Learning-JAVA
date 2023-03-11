package Permutations;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
//        Permus("","abc");
        ArrayList<String> ans = PermusArrayList("","abc");
        System.out.println(ans);
    }
    static void Permus(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.print(processed);
            System.out.print(" ,");

            return;
        }
        char ch = unprocessed.charAt(0);
        //extract the char which we want to insert in different places of the processed
        for (int i = 0; i < processed.length() + 1; i++) {
            String first_part = processed.substring(0,i);
            //in the substring method the (x,y), so y-> exclusive here, hence we get substring from x to y-1
            String second_part = processed.substring(i,processed.length());
            Permus(first_part+ch+second_part,unprocessed.substring(1));

        }
    }

    static ArrayList<String> PermusArrayList(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        //extract the char which we want to insert in different places of the processed

        ArrayList<String> ans = new ArrayList<>();
        //as this is being made inside a function call hence it is local to that function call only
        for (int i = 0; i < processed.length() + 1; i++) {
            String first_part = processed.substring(0,i);
            //in the substring method the substring(x,y), so y-> exclusive here, hence we get substring from x to y-1
            String second_part = processed.substring(i,processed.length());

            ans.addAll(PermusArrayList(first_part+ch+second_part,unprocessed.substring(1)));
            //addign the contents of an already existing list into a list using the addAll method
        }
        return ans;
    }

}
