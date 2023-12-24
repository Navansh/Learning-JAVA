public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {

        //code changes in the isFull Condition
        if(isFull()) {
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                //now we need to traverse the complete CQ, and then paste the items
                //in a fresh one

                temp[i] = data[(front + i) % data.length];
            }

            //after this, set the front and end positions of the new CQ
            front = 0;
            end = data.length; // of the new CQ
            //as the prev CQ got fulled

            data = temp;


        }

        return super.insert(item);
    }
}
