package Maths;

import java.util.HashMap;

public class X_of_a_kind_in_a_deck_of_cards {
    public static void main(String[] args) {

    }

    public boolean hasGroupsSizeX(int[] deck) {
        //first calculate the frew of each element
        HashMap<Integer, Integer> hx = new HashMap<>();


        for(int i = 0; i < deck.length; i++) {
            if(hx.containsKey(deck[i])) {
                int temp = hx.get(deck[i]);
                hx.put(deck[i], temp + 1);
            } else {
                hx.put(deck[i], 1);
            }
        }

        //take gcd of the entire array
        int gcd_arr = 0;

        for(int i = 0; i < deck.length; i++) {
            gcd_arr = GCD(gcd_arr, hx.get(deck[i]));
        }

        return gcd_arr > 1;
    }

    public int GCD(int a, int b) {
        if(a == 0) {
            return b;
        }

        return GCD(b % a, a);
    }
}
