import java.util.HashMap;

public class firstNonRepeating {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,1,4};
        System.out.println(firstNonRepeating(arr));
    }

    public static int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(hmap.containsKey(arr[i])) {
                int val = hmap.get(arr[i]);
                hmap.put(arr[i], val + 1 );
            } else {
                hmap.put(arr[i], 1);
            }
        }

        //now iterate over the entire array and find the first element whose freq
        //is 1

        for (int i = 0; i < arr.length; i++) {
            if(hmap.get(arr[i]) == 1) {
                return arr[i];
            }
        }

        return -1;
    }
}
