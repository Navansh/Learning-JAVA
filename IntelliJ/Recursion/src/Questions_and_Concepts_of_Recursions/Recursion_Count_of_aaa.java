package Questions_and_Concepts_of_Recursions;

public class Recursion_Count_of_aaa {
    public static void main(String[] args) {
        System.out.println(count1("aaaaaa", 0, 0));
        System.out.println(count2("aaaaaa", 0,0));
    }
    private static int count1(String st, int vidx, int count) {
        // Write a recursive function which counts, the number of times “aaa”
        //appears in the string, they may overlap ***
        if(st.length() < 3){
            return count;
        }

        char start = st.charAt(vidx);
        char mid = st.charAt(vidx + 1);
        char end = st.charAt(vidx + 2);

        if(start == mid && mid == end) {
           return count1(st.substring(1), vidx, count + 1);
        }

        return count1(st.substring(1), vidx, count);

    }

    private static int count2(String st, int vidx, int count) {
        //here we need to count the unique occurances of aaa
        if(st.length() < 3) {
            return count;
        }

        int start = st.charAt(0);
        int mid = st.charAt(1);
        int end = st.charAt(2);

        if(start == mid && mid == end) {
            return count2(st.substring(3), vidx, count + 1);
        }

        return count2(st.substring(1), vidx, count);
        //being index should be 1 as if we didn't get three a, then move to next char
        //and check it for 3a's
    }

}
