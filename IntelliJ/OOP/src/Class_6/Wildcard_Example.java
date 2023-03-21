package Class_6;

import java.util.ArrayList;
import java.util.Arrays;

public class Wildcard_Example<T extends Number> {
    //through the use of wildcards we can restrict which type of Arraylist we want the
    //the user to create
    //say we used the class Number here, means the user can create this Arraylist of only
    //float, double, int or Number type....
    private Object[] data;
    //T -> type parameter of class Custom_Generic_Arraylist
    private static int DEFAULT_SIZE = 10;
    private int size = 0;
    //also working as an index value

    public Wildcard_Example() {
        this.data = new Object[DEFAULT_SIZE];
        //because T type cannot be instantiated directly, we use the Object Type
    }

    public void getList(Wildcard_Example<Number> list){
        //here you can only pass Number type and not the subclasses of it
        //but if you want to pass subclasses of it, then do
//        public void getList(List<? extends Number> list) -> THIS IS WILDCARD 💡

        //do something
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
        //problem with this arraylist -> can create list of only int type
//        list.add(5);
//        list.add(3);
//        list.add(9);

//        for (int i = 0; i < 14; i++) {
//            list.add(i*2);
//        }

//        Wildcard_Example<String> list = new Wildcard_Example<>();
        //now this string won't work and give error as we have explicitly defined in the class
        //Wildcard example to accept input of Number type only
//        list.add("45");
//        list.add("D");
//        list.add(" ");

        Wildcard_Example<Double> list = new Wildcard_Example<>();


        for (int i = 0; i < 14; i++) {
            list.add((double) i);
        }


        System.out.println(list);
    }
}
