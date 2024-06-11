package HashMap_Questions;

import java.util.HashMap;

public class count_right_triangle {
    public static void main(String[] args) {
//        Count of right triangles
        int[] x = {1,3,5,5,1};
        int[] y = {3,3,3,1,1};
        System.out.println(CountRightTriangleBruteforce(x,y));
        System.out.println(CountRightTriangleOptimal(x,y));
    }

    public static int CountRightTriangleBruteforce(int[] x, int[] y) {
        int count = 0;
        int n = x.length;

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                for (int k = 0; k <= n - 1; k++) {
                    if (x[i] == x[j] && y[i] == y[k] && i != j && i != k && j != k) {
                        count++;
                    }
                }
            }
        }

        return count;

    }

    public static int CountRightTriangleOptimal(int[] x, int[] y) {
        //first calculate the frequency of every x and y coordinate( seperately) using
        //a HashMap
        HashMap<Integer, Integer> fx = new HashMap<>();
        HashMap<Integer, Integer> fy = new HashMap<>();

        int n = x.length;

        for (int i = 0; i < n; i++) {
            if(fx.containsKey(x[i])) {
                int temp = fx.get(x[i]);
                fx.put(x[i], temp + 1);
            } else {
                fx.put(x[i] , 1);
            }

            if(fy.containsKey(y[i])) {
                int temp = fy.get(y[i]);
                fy.put(y[i], temp + 1);
            } else {
                fy.put(y[i] , 1);
            }
        }

        //now we have the freq count of all the x's coordinates and y's coordi
        int ans =  0;
        for (int i = 0; i < n; i++) {
            //now make the point as the 90 deg part and count the no of
            //possible triangle that can form from that point
            //possible trianle will only form if :
            //for x:coordinate : should be same for parallel to Y
            //for y " : should " " " to X
            //that means while calculating the freq, for each coordinate, for that
            //coordinate the freq > 1 to give any possible ans

            int countX = fx.get(x[i]);
            int countY = fy.get(y[i]);
            //here we got the freq
            //hence har kisi point par jaakar usko 90 deg waala
            //point consider kar rhe and uske respect mein
            //baaki right angles form kar rhe

            ans = ans + (countX - 1) * (countY - 1);
            // -1 because jis point par 90 deg assume kar rhe woh point thodi
            //naa koi aur side banega

        }

        return ans;
    }


}
