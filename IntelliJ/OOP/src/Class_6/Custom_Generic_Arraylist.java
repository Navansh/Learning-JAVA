package Class_6;

import java.util.ArrayList;
import java.util.Arrays;

public class Custom_Generic_Arraylist<T> {
    private Object[] data;
    //T -> type parameter of class Custom_Generic_Arraylist
    private static int DEFAULT_SIZE = 10;
    private int size = 0;
    //also working as an index value

    public Custom_Generic_Arraylist() {
        this.data = new Object[DEFAULT_SIZE];
        //because T type cannot be instantiated directly, we use the Object Type
    }
    public void add(T num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length*2];
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

    public T remove(){
        T removed =(T)(data[--size]);
        //because here we are modifying, hence we need to cast it to this(T)
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
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
//        Custom_Generic_Arraylist list = new Custom_Generic_Arraylist();
        //problem with this arralist -> can create list of only int type
//        list.add(5);
//        list.add(3);
//        list.add(9);

//        for (int i = 0; i < 14; i++) {
//            list.add(i*2);
//        }

        Custom_Generic_Arraylist<String> list = new Custom_Generic_Arraylist<>();
//        list.add("45");
//        list.add("D");
//        list.add(" ");
        ArrayList<String> listerr = new ArrayList<>();


        for (int i = 0; i < 14; i++) {
            list.add(String.valueOf((i)));
        }

        System.out.println(listerr);

        System.out.println(list);
    }
}
