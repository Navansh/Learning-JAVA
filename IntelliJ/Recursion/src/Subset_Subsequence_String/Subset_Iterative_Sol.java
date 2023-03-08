package Subset_Subsequence_String;

import java.util.ArrayList;
import java.util.List;

public class Subset_Iterative_Sol
{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = Subset(arr);

        for (List<Integer> list:ans) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> Subset(int[] arr){
        //we will return a list of lists in which we assume every element is a list
        //hence [2,3] is a list and so on.. so finally when we'll return the subset it will be a list of lists

        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        //adding a new empty arraylist

        for (int num : arr) {
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);

            }
        }
        return outer;
    }
}
