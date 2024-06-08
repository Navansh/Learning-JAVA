import java.util.HashMap;
import java.util.List;

public class Repeat_Number {
    public static void main(String[] args) {

    }

    public static int repeatedNumber(final List<Integer> a) {
        //use HashMap, and O(N)
        int n = a.size()/3;

        HashMap<Integer, Integer> hx = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            if(hx.containsKey(a.get(i))) {
                int temp = hx.get(a.get(i));
                hx.put(a.get(i), temp + 1);
            } else {
                hx.put(a.get(i), 1);
            }
        }

        //now check for every entry In HashMap if its greater than or equal to n
        for (int i = 0; i < a.size(); i++) {
            if(hx.get(a.get(i)) > n) {
                return a.get(i);
            }
        }

        return -1;
    }
}
