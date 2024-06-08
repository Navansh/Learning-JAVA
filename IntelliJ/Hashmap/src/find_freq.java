import java.util.HashMap;

public class find_freq {
    public static void main(String[] args) {
        //given N array elements & Q queries, for every query find freq of element
        //can be done using HashMap
        int[] arr = {2, 8, 6, 9, 8, 6, 8, 2,11};
        int[] queries = {2,8};
        findFreq(arr, queries);
    }

    public static void findFreq(int[] arr, int[] queries) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            if(hmap.containsKey(arr[i])) {
                //update the query freq
                int temp = hmap.get(arr[i]);
                hmap.put(arr[i],temp + 1 );
            } else {
                hmap.put(arr[i],1 );
            }
        }

        //now print the freq of the queries
        for(int i = 0; i < queries.length; i++) {
            if(hmap.containsKey(queries[i])) {
                System.out.println(hmap.get(queries[i]));
            } else {
                System.out.println("0");
            }
        }

    }



}
