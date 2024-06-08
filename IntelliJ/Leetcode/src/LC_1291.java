import java.util.ArrayList;
import java.util.List;

public class LC_1291 {
    public static void main(String[] args) {
        System.out.println(sequentialDigitsSingle(100,300));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        //this will give TLE, we need O(1) solution
        List<Integer> ansList = new ArrayList<>();

        for (int i = low; i <= high ; i++) {
            if(checkSequential(Integer.toString(i))) {
                ansList.add(i);
            }
        }

        return ansList;
    }

    private static boolean checkSequential(String string) {
        char[] placeArray = string.toCharArray();

        for (int i = 1; i < placeArray.length ; i++) {
            int first = placeArray[i - 1] - '0';
            int second = placeArray[i] - '0';

            if(second - first == 1) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> sequentialDigitsSingle(int low, int high) {
        String c = "123456789";
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < c.length(); i++) {
            for (int j = i + 1; j <= c.length(); j++) {
                int curr = Integer.parseInt(c.substring(i, j));
                if (curr <= high && curr >= low) {
                    a.add(curr);
                }
            }
        }

        a.sort(null);
        return a;

    }
}
