package Stack_Questions;

import java.util.Arrays;

public class LC_AssignCookies {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};

        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        //sort both of the arrays, and then check if g[i] <= s[i], if yes
        //then we can satisfy that otherwise not

        Arrays.sort(g);
        Arrays.sort(s);

        int size = Math.min(g.length, s.length);
        int content = 0;

        for (int j : g) {
            for (int k : s) {
                if (j <= k) {
                    content++;
                    break;
                }
            }
        }

        return content;
    }
}
