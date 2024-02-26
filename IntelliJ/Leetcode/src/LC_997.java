import java.util.HashMap;

public class LC_997 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3},
                {2,3},
                {3,1}
        };
        System.out.println(findJudge(arr.length, arr));
    }

    public static int findJudge(int n, int[][] trust) {
        //create a HashMap
        //not working*****************
        HashMap<Integer, Integer> hx = new HashMap<>();
        int max_freq = 0;
        int max_person = Integer.MIN_VALUE;

        for (int i = 0; i < trust.length; i++) {
            for (int j = 0; j < trust[0].length; j++) {
                //add the second element to the hashmap and count its frequency
                if(hx.containsKey(trust[i][1])) {
                    int temp = hx.get(trust[i][1]);
                    hx.put(trust[i][1], temp + 1);
                    if(temp + 1 > max_freq) {
                        max_person = trust[i][1];
                    }
                    max_freq = Math.max(temp + 1, max_freq);
                } else {
                    hx.put(trust[i][1], 1);
                }
            }
        }


        //now check if max_person exists in the 0th position of the trust
        for (int i = 0; i < trust.length; i++) {
            for (int j = 0; j < trust[0].length; j++) {
                if(trust[i][0] == max_person) {
                    return -1;
                }
            }
        }

        return max_person;


    }
}
