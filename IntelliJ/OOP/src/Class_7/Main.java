package Class_7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Collection
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        ArrayList<Integer> listerr = new ArrayList<>();
        listerr.add(34);
        listerr.add(34);
        listerr.add(34);
        listerr.add(34);
        System.out.println(listerr.get(0));

    }
}
