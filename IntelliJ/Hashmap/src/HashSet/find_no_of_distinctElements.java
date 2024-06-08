package HashSet;

import java.util.HashSet;

public class find_no_of_distinctElements {
    public static void main(String[] args) {
        int[] arr = {4,6,7,6,5,5,5,6,};
        System.out.println(noDistinctElements(arr));
    }

    public static int noDistinctElements(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();

        for (int j : arr) {
            hs.add(j);
        }

        return hs.size();
    }
}
