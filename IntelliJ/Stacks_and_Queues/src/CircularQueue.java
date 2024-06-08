public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    //tell the place(index), where the new elements would be inserted
    protected int front = 0;
    private int size = 0;
    public CircularQueue() {
        this.data = new int[DEFAULT_SIZE];
    }
    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
        //because the end may come to 0
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }

        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        //this time we aren't required to shift the elements
        if(isEmpty()) {
            throw new Exception("Cannot remove from empty queue");
        }

        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;

    }

    public int front() throws Exception {
        //displays the item in the front
        if(isEmpty()) {
            throw new Exception("Queue is empty, can remove");
        }

        return data[front];
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;

        do {
            System.out.print(data[i] + "-> ");
            i++;
            i = i % data.length;
        }  while (i != end);

        System.out.println("END");
    }
}
