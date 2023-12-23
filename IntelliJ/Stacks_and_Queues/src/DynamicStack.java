public class DynamicStack extends StackCustImple{

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.ptr == this.data.length - 1) {
            //double the array size

            int[] temp = new int[data.length*2];
            //transfer all the items from the prev array to this array

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
            //this means that data now points to the array of the temp variable in the heap memory.
        }
        //at the end of this, the original data of "data" variable will be removed by garbage collector
        //and the temp will also be removed as it will go out of scope
        //this all step was to make sure the Stack new runs out of space

        if(isFull()) {
            System.out.println("Dance");
        }

        //Pushing part
        //at this point we know that the array is not full
        return super.push(item);
    }
}
