package Sort_Objects;

import java.util.Comparator;

public class Sort_an_Array_of_Objects {
    public static void main(String[] args) {

    }


}

class Pair implements Comparable<Pair> {
    int x;
    int y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }

    public int compareTo(Pair o) {
        return this.y - o.y;
        //this means sort in increasing order on the basis of value of y's

        //for decreasing order, just write in the opposite way

    }
}

