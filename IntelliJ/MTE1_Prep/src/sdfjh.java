import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sdfjh {
    public static void main(String[] args) {
        List<String> stringer = new ArrayList<>();
        System.out.println(maxLength(stringer));
    }

    public static int maxLength(List<String> arr) {
        //queue + HashMap

        if(arr.size() == 1) {
            return arr.get(0).length();
        }

        //take the elements and store it in a queue
        Queue<String> queuer = new LinkedList<>();

        //add the first element to the queue
        queuer.add(arr.get(0));

        for (int i = 1; i < queuer.size(); i++) {
            //take every element of queue and concatenate the ith String from the
            //arr to it
            String element = queuer.remove();
            for (int j = 1; j < arr.size() ; j++) {
                //add each element to the queue element and add it to the queue
                queuer.add(element + arr.get(i));
            }
        }

    }
}
