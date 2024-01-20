import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queuer = new CustomQueue(5);
        Queue<Integer> qi = new LinkedList<>();

//        queuer.insert(45);
//        queuer.insert(44);
//        queuer.insert(43);
//        queuer.insert(42);
//        queuer.insert(41);
//
//        queuer.display();
//
//        System.out.println(queuer.remove());
//
//        queuer.display();

        CircularQueue q = new CircularQueue(5);
        q.insert(5);
        q.insert(4);
        q.insert(3);
        q.insert(2);
        q.insert(1);

        q.display();
        q.remove();
        q.display();

    }
}


