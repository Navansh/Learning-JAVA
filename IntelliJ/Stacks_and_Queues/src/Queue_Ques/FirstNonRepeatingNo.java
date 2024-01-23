package Queue_Ques;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstNonRepeatingNo {
    public static void main(String[] args) {
        String A = "yewaahkpuo";
//        System.out.println(FirstNonRepeating(A));
        System.out.println(FirstNonRepeating2(A));

    }

    public static String FirstNonRepeating(String A)
    {

        //Solution won't work as we are using just Hashmaps which won't keep the track
        //of order of which one occurred first( the non repeating char )
        // code here
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> hx = new HashMap<>();


        char op = ' ';
        char[] arr = A.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            if(hx.containsKey(arr[i])) {
                int temp = hx.get(arr[i]);
                hx.put(arr[i], temp + 1);
                ans.append("#");
            } else {
                hx.put(arr[i], 1);
                if(i == 0) {
                    ans.append(arr[i]);
                    continue;
                }
                if(i > 1 && hx.get(arr[i-1]) == 1) {
                    ans.append(arr[i-1]);
                } else {
                    ans.append(arr[i]);
                }
            }
        }

        return ans.toString();

    }

    public static String FirstNonRepeating2(String A) {
        HashMap<Character, Integer> hx =new HashMap<>();
        Queue<Character> queuer = new LinkedList<>();

        StringBuilder ans = new StringBuilder();

        char[] arr = A.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            //add it to queue
            queuer.add(arr[i]);

            if(hx.containsKey(arr[i])) {
                int temp = hx.get(arr[i]);
                hx.put(arr[i],temp + 1);
            } else {
                hx.put(arr[i],1);
            }

            while(!queuer.isEmpty() && hx.get(queuer.peek()) > 1) {
                queuer.remove();
                //removing if any element that has appear afterwards but was in the queue
                //so that it doesn't get appended
            }

            if(!queuer.isEmpty()) {
                ans.append(queuer.peek());
            } else {
                ans.append('#');
            }

        }

        return ans.toString();
    }
}
