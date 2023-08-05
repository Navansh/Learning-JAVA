import java.util.Deque;

public class CustomQueue {
    //insertion from last/end
    //deletion from first/start

    //here we will be dealing with the approach of just using one pointer to both of these operations
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = -1;
    public CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }
    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length - 1;
    }

    public boolean isEmpty() {
        return (end == -1);
    }



}
