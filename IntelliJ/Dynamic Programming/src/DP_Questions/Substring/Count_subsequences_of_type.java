package DP_Questions.Substring;

public class Count_subsequences_of_type {
    public static void main(String[] args) {
        //Count subsequences of type a^i, b^j, c^k
        //https://www.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
    }

    public int fun(String s) {
        long endAtA = 0;
        long endAtB = 0;
        long endAtC = 0;

        //ismein dp use karne ki arurat nhi padi as
        //we just needed the prevCount agat uske peeche ka chahiye
        //hota then dp use karte



        long mod = 1000000007;
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                endAtA = ((endAtA * 2) + 1) % mod;
            } else if(s.charAt(i) == 'b') {
                endAtB = ((endAtB * 2) + endAtA) % mod;
            } else {
                //means it is 'c'
                endAtC = ((endAtC * 2) + endAtB) % mod;
            }
        }

        return (int) endAtC;
    }
}
