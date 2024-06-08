package Class_6;

import java.util.Arrays;

public class Custom_Arraylist {
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;
    //also working as an index value

    public Custom_Arraylist() {
        this.data = new int[DEFAULT_SIZE];
    }
    public void add(int num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length*2];
        //copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
        //so the data(ref var) now points to the object of temp(ref var)
        //hence we have successfully resized the data array to double size
    }


    private boolean isFull() {
        return this.size == data.length;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "Custom_Arraylist{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Custom_Arraylist list = new Custom_Arraylist();
        //problem with this arralist -> can create list of only int type
//        list.add(5);
//        list.add(3);
//        list.add(9);

        for (int i = 0; i < 14; i++) {
            list.add(i*2);
        }

        System.out.println(list);
    }
}
