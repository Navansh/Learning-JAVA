package Questions_and_Concepts_of_Recursions;

public class Recursion_Count_of_aaa {
    public static void main(String[] args) {
        System.out.println(count1("aaaaaa", 0, 0));
    }
    private static int count1(String st, int vidx, int count) {
        if(st.length() < 3){
            return count;
        }

        char start = st.charAt(vidx);
        char mid = st.charAt(vidx + 1);
        char end = st.charAt(vidx + 2);

        if(start == mid && mid == end) {
           return count1(st.substring(1), vidx+ 1, count + 1);
        }

        return count1(st.substring(1), vidx+ 1, count);

    }

}
