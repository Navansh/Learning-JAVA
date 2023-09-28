package Subset_Subsequence_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_Iterative_Sol
{
    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        List<List<Integer>> ans = Subset(arr);
        int[] arr = {2,1,2};
        List<List<Integer>> ans = SubsetDupli(arr);

        for (List<Integer> list:ans) {
            System.out.print(list);
            System.out.print(" ,");
        }
    }

    static List<List<Integer>> Subset(int[] arr){
        //we will return a list of lists in which we assume every element is a list
        //hence [2,3] is a list and so on.. so finally when we'll return the subset it will be a list of lists

        List<List<Integer>> outer = new ArrayList<>();
        //this contains the list of subset lists like [ [1,2] , [2,3] .... ]
        outer.add(new ArrayList<>());
        //adding a new empty arraylist, to which we can start adding the elements of which we want to create subsets of
        //this is the initial empty list upon which we'll start the left iteration, of adding
        for (int num : arr) {
            int size = outer.size();
            //here we calculate the size of outer, means how many lists it has, then utne hi hamein aur add karni hai
            for (int i = 0; i < size; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                //we get the i(th) list from the outer(which is a list of lists)
                internal.add(num);
                //add our number to the list, jiska hamein subsets banane hain
                //take the new list and our number to that list : size number of times
                outer.add(internal);
                //and add that to the original list of lists
                //as size was calculated before adding new lists to the outer, hence this loop won't run
                //indefinitely

            }
        }
        return outer;
        //finally return the list of lists containing all the subsets
    }

    static List<List<Integer>> SubsetDupli(int[] arr){
        //this function handles the situation in which the given arr has duplicate elements which causes
        //creation of duplicate subsets which we don't want

        Arrays.sort(arr);
        //so first we sort the array, so that all the duplicates come together, only then our below algo to
        //find the unique subsets will work

        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        //adding a new empty arraylist, to which we can start adding the elements of which we want to create subsets of

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            //if current and previous element is same then new start = (prev end + 1)
            if (i>0 && arr[i]==arr[i-1]) {
                start = end + 1;
                //if the previous element is same then start adding from prev end till outer lists ka size - 1
            }
            end = outer.size() - 1;
            int size = outer.size();
            //here we calculate the size of outer, means how many lists it has, then utne hi hamein aur add karni hai

            for (int j = start; j < size; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                //we get the i(th) list from the outer(which is a list of lists)
                internal.add(arr[i]);
                //add our number to the list, jiska hamein subsets banane hain
                outer.add(internal);
                //and add that to the original list of lists

            }
        }
        return outer;
        //finally return the list of lists containing all the subsets
    }
}
