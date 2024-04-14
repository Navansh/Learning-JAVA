package Stack_Questions;

public class Leetcode_1704_halvesAreAlike {
    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        //split the string
        int half = s.length() / 2;
        String first = s.substring(0, half);
        String second = s.substring(half);

        return vowelCounter(first) == vowelCounter(second);
        //vowel checker
    }

    private static int vowelCounter(String checker) {
        checker = checker.toLowerCase();
        //convert checker to a charArray and count the number of vowels
        int count = 0;
        char[] str = checker.toCharArray();
        for (char c : str) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count += 1;
            }
        }

        return count;
    }
}
