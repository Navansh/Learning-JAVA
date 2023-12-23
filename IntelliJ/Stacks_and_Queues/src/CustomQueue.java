import java.util.Deque;

public class CustomQueue {
    //insertion from last/end
    //deletion from first/start

    //here we will be dealing with the approach of just using one pointer to both of these operations
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;
    //we are setting up with the end of the LL, as this where the insertion is gonna happen
    //if you initialize it with -1, then it is full at data.length - 1
    //and empty at -1
    public CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }
    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return (end == 0);
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }

        data[end++] = item;
        return true;

    }

    public int remove() throws Exception {
        //always removed from the first position
        if(isEmpty()) {
            throw new Exception("Queue is empty, can remove");
        }

        int removed_item = data[0];

        //shift the items of the array to the left by one place
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed_item;
    }

    public int front() throws Exception {
        //displays the item in the front
        if(isEmpty()) {
            throw new Exception("Queue is empty, can remove");
        }

        return data[0];
    }

}
