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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        for (int i = 0; i < queue.size() ; i++) {
            System.out.println(queue.remove());
        }

        //this will not print all the elements of queue as q.size() will also dynamically
        //update and somehwere maybe the condition i < queue.size() may not hold true
        //even though queue has more elements to remove

        //hence we use queue.isEmpty() and a while loop

//        q.display();
//        q.remove();
//        q.display();

    }
}


