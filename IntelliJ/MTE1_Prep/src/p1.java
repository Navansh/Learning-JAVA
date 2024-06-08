import java.util.ArrayList;

public class p1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3};
        int k = 2;
        int max = FindMax(arr, k);
        System.out.println(max);
    }

    private static int FindMax(int[] arr, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if((i + k) <= arr.length - 1) {
                int diff = Math.abs(arr[i]) - Math.abs(arr[i+k]);
                if(diff < 0){
                    diff = diff * -1;
                }
                list.add(diff);
            }
        }

        int max = -999999;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > max){
                max = list.get(i);
            }
        }

        return max;
    }
}
