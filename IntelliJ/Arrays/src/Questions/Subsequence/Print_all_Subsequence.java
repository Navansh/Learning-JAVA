package Questions.Subsequence;

import java.util.ArrayList;
import java.util.List;

public class Print_all_Subsequence {
    public static void main(String[] args) {
        //print all the subsequence for the given arr
        int[] arr = {10,20,30};
        List<List<Integer>> lists = new ArrayList<>();
        lists = printAllSubsequence(arr);

//        for (int i = 0; i < lists.size(); i++) {
//            for (int j = 0; j < lists.get(i).size(); j++) {
//                System.out.print(lists.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }

        //can also print like
        for(List<Integer> li : lists) {
            System.out.print("{ ");
            for(int i : li) {
                System.out.print(i + " ");
            }
            System.out.println('}');
        }
    }

    public static List<List<Integer>> printAllSubsequence(int[] arr) {
        //considering 10, _, 20, _, this is one subsequence, hence this is made in
        //one subsequence, hence list of all subsequence forms the entire list
        int n = arr.length;
        int total_numbers = 1 << n;
        //this means 2 to the power n

        List<List<Integer>> listerr = new ArrayList<>();

        for (int i = 0; i < total_numbers; i++) {
            //less than total_numbers, as for 8 numbers in binary we go from 0 to 7
            List<Integer> this_Subsequence = new ArrayList<>();

            //now iterate over the bits of this number and check which are set and unset
            for (int j = 0; j < n; j++) {
                if(checkBit(i,j)) {
                    //we'll check for number i's bit indexes and using that
                    //we'll form our subsequence
                    this_Subsequence.add(arr[j]);
                }
            }

            listerr.add(this_Subsequence);
        }

        return listerr;
    }

    public static boolean checkBit(int ele, int position) {
        return ((ele >> position) & 1) == 1;
    }
}
