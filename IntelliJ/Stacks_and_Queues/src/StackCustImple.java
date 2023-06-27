public class StackCustImple {
    protected int[] data;
    //hence this is not a dynamic stack as the array's size doesn't automatically increase
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public StackCustImple(){
        //here use the default size
        this(DEFAULT_SIZE);
        //hence it will the constructor which takes in the integer argument
        //***Special Use Case of this
    }
    public StackCustImple(int size) {
        this.data = new int[size];
         //this is initialized to 0
    }

    public boolean push(int item) {

        if (ptr == data.length - 1) {
            System.out.println("Stack is full, insertion not allowed");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (ptr == -1 ) {
            throw  new Exception("Cannot pop from an Empty Stack");
        }
        int removed_item = data[ptr];
//        ptr--;
//        return  removed_item;
        //or we can do
        return data[ptr--];
    }

    public int peek() throws Exception {
        if (ptr == -1 ) {
            throw  new Exception("Cannot peek from an Empty Stack");
        }
        return data[ptr];
    }




}
